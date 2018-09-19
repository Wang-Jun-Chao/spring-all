
package com.example.spring.boot.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for separate management and main service ports.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ShutdownSampleActuatorApplicationTests {

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
    @DirtiesContext
    public void testShutdown() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.restTemplate
                .withBasicAuth("user", getPassword())
                .postForEntity("/actuator/shutdown", null, Map.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        @SuppressWarnings("unchecked")
        Map<String, Object> body = entity.getBody();
        assertThat(((String) body.get("message"))).contains("Shutting down");
    }

    private String getPassword() {
        return "password";
    }

}
