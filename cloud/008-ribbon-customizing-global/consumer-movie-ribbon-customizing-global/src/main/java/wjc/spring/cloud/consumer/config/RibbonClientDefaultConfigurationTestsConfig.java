package wjc.spring.cloud.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import wjc.spring.cloud.config.DefaultRibbonConfiguration;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-27 15:11
 **/

@RibbonClients(defaultConfiguration = DefaultRibbonConfiguration.class)
public class RibbonClientDefaultConfigurationTestsConfig {
    public static class BazServiceList extends ConfigurationBasedServerList {
        public BazServiceList(IClientConfig config) {
            super.initWithNiwsConfig(config);
        }
    }
}
