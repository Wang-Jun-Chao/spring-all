package com.example.spring.boot.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("counter", 42).build();
    }

}
