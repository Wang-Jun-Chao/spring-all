package wjc.spring.cloud.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
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
