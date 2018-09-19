package wjc.spring.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author: wangjunchao(王俊超)
 * @time: 201-09-19 18:19
 **/
public class KiritoNamespaceHandler extends NamespaceHandlerSupport {
    private final static Logger logger = LoggerFactory.getLogger(KiritoNamespaceHandler.class);

    @Override
    public void init() {
        super.registerBeanDefinitionParser("application",
                new KiritoBeanDefinitionParser(ApplicationConfig.class));
        super.registerBeanDefinitionParser("service",
                new KiritoBeanDefinitionParser(ServiceBean.class));
    }
}
