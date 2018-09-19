package wjc.spring.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-19 19:11
 **/
public class XmlSchemaAuthoringSampleApplication {
    private final static Logger logger = LoggerFactory.getLogger(XmlSchemaAuthoringSampleApplication.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kirito.xml");
        ServiceBean serviceBean = ctx.getBean(ServiceBean.class);
        System.out.println(serviceBean);
        ApplicationConfig applicationConfig = ctx.getBean(ApplicationConfig.class);
        System.out.println(applicationConfig);
    }
}
