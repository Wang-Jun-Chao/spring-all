package com.example.spring.boot.cxf.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;

import java.util.Map;

/**
 * Author: 王俊超
 * Date: 2018-01-09 22-26
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class ControllerProxyFactory {

    public static <T> T createControllerProxy(Class<T> clazz, String host, Map<String, String> headers) {
        JAXRSClientFactoryBean factoryBean = new JAXRSClientFactoryBean();
        factoryBean.setAddress(host);
        factoryBean.setHeaders(headers);
        factoryBean.setInheritHeaders(true);
        factoryBean.setServiceClass(clazz);
        factoryBean.setProvider(new JacksonJsonProvider());
        return (T) factoryBean.create();
    }
}
