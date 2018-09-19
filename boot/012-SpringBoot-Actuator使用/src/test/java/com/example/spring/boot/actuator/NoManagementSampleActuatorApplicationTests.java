
package com.example.spring.boot.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for switching off management endpoints.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {
        "management.server.port=-1"})
public class NoManagementSampleActuatorApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHome() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.restTemplate
                .withBasicAuth("user", getPassword()).getForEntity("/", Map.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        @SuppressWarnings("unchecked")
        Map<String, Object> body = entity.getBody();
        assertThat(body.get("message")).isEqualTo("Hello Phil");
    }

    @Test
    public void testMetricsNotAvailable() {
        testHome(); // makes sure some requests have been made
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.restTemplate
                .withBasicAuth("user", getPassword()).getForEntity("/metrics", Map.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private String getPassword() {
        return "password";
    }

}
