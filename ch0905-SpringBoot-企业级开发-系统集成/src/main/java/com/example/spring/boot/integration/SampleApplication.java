package com.example.spring.boot.integration;

import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.scheduling.PollerMetadata;

import java.io.File;
import java.io.IOException;

/**
 * Author: 王俊超
 * Date: 2017-07-23 14:55
 * All Rights Reserved !!!
 */
@SpringBootApplication
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

    @Value("https://spring.io/blog.atom")
    Resource resource;

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(500).get();
    }

    @Bean
    public FeedEntryMessageSource feedMessageSource() throws IOException { //3
        return new FeedEntryMessageSource(resource.getURL(), "news");
    }

    @Bean
    public IntegrationFlow myFflow() throws IOException {
        return IntegrationFlows.from(feedMessageSource())
                .<SyndEntry, String>route(playload -> playload.getCategories().get(0).getName(),
                        mapping -> mapping.channelMapping("releases", "releasesChannel")
                                .channelMapping("engineering", "engineeringChannel")
                                .channelMapping("news", "newsChannel"))
                .get();
    }

    @Bean
    public IntegrationFlow releasesFlow() {
        return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10)) //1
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink()
                                + System.getProperty("line.separator")) //2
                .handle(Files.outboundAdapter(new File("e:/springblog")) //3
                        .fileExistsMode(FileExistsMode.APPEND) //4
                        .charset("UTF-8") //5
                        .fileNameGenerator(message -> "releases.txt") //6
                        .get())
                .get();
    }


    @Bean
    public IntegrationFlow engineeringFlow() {
        return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 10))
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink()
                                + System.getProperty("line.separator"))
                .handle(Files.outboundAdapter(new File("e:/springblog"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .charset("UTF-8")
                        .fileNameGenerator(message -> "engineering.txt")
                        .get())
                .get();
    }

    @Bean
    public IntegrationFlow newsFlow() {
        return IntegrationFlows.from(MessageChannels.queue("newsChannel", 10))
                .<SyndEntry, String>transform(
                        payload -> "《" + payload.getTitle() + "》 " + payload.getLink()
                                + System.getProperty("line.separator"))
                .enrichHeaders( //1
                        Mail.headers()
                                .subject("来自Spring的新闻")
                                .to("1311831616@qq.com")
                                .from("1311831616@qq.com"))
                .handle(Mail.outboundAdapter("smtp.qq.com") //2
                        .port(465)
                        .protocol("smtp")
                        .credentials("1311831616@qq.com", "NerverGiveUp1314")
                        .javaMailProperties(p -> p.put("mail.debug", "false")),  e -> e.id("smtpOut"))
                .get();
    }
}
