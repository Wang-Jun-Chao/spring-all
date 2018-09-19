package wjc.spring.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-19 18:57
 **/
public class KiritoBeanDefinitionParser implements BeanDefinitionParser {
    private final static Logger logger = LoggerFactory.getLogger(KiritoBeanDefinitionParser.class);

    private final Class<?> clazz;

    public KiritoBeanDefinitionParser(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static BeanDefinition parse(Element element, ParserContext parserContext, Class<?> clazz) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(clazz);
        beanDefinition.setLazyInit(false);
        String name = element.getAttribute("name");
        beanDefinition.getPropertyValues().addPropertyValue("name", name);
        parserContext.getRegistry().registerBeanDefinition(name, beanDefinition);

        return beanDefinition;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return parse(element, parserContext, clazz);
    }
}
