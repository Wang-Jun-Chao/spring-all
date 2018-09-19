package wjc.spring.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-09-19 18:58
 **/
public class ServiceBean {
    private final static Logger logger = LoggerFactory.getLogger(ServiceBean.class);

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
