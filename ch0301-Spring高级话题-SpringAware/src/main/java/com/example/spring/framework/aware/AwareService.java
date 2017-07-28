package com.example.spring.framework.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * ①实现BeanNameAware、ResourceLoaderAware接口，获得Bean 名称和资源、加载的服务。
 * ②实现ResourceLoaderAware 需章写setResourceLoadero
 * ③实现BeanNameAware需重写setBeanName 方法。
 *
 * Author: 王俊超
 * Date: 2017-07-11 07:47
 * All Rights Reserved !!!
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称为：" + beanName);

        Resource resource = loader.getResource(
                "classpath:com/example/spring/framework/aware/test.txt");
        try {

            System.out.println("ResourceLoader加载的文件内容为: " +
                    IOUtils.toString(resource.getInputStream(), "utf-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
