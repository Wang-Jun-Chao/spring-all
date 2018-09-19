
package com.example.spring.boot.actuator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for endpoints configuration.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("endpoints")
public class EndpointsPropertiesSampleActuatorApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCustomErrorPath() {
        @SuppressWarnings("rawtypes")
        ResponseEntity<Map> entity = this.restTemplate
                .withBasicAuth("user", getPassword()).getForEntity("/oops", Map.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        @SuppressWarnings("unchecked")
        Map<String, Object> body = entity.getBody();
        assertThat(body.get("error")).isEqualTo("None");
        assertThat(body.get("status")).isEqualTo(999);
    }

    @Test
    public void testCustomContextPath() {
        ResponseEntity<String> entity = this.restTemplate
                .withBasicAuth("user", getPassword())
                .getForEntity("/admin/health", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("\"status\":\"UP\"");
        assertThat(entity.getBody()).contains("\"hello\":\"world\"");
    }

    private String getPassword() {
        return "password";
    }

}
