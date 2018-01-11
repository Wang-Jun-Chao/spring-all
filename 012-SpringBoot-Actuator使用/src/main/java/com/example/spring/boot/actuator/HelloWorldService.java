
package com.example.spring.boot.actuator;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    private final ServiceProperties configuration;

    public HelloWorldService(ServiceProperties configuration) {
        this.configuration = configuration;
    }

    public String getHelloMessage() {
        return "Hello " + this.configuration.getName();
    }

}
