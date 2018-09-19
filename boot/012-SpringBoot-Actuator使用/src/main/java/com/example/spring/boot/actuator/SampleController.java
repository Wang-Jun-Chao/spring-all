
package com.example.spring.boot.actuator;

import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@Description("A controller for handling requests for hello messages")
public class SampleController {

    private final HelloWorldService helloWorldService;

    public SampleController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> hello() {
        return Collections.singletonMap("message",
                this.helloWorldService.getHelloMessage());
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> olleh(@Validated Message message) {
        Map<String, Object> model = new LinkedHashMap<>();
        model.put("message", message.getValue());
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return model;
    }

    @RequestMapping("/foo")
    @ResponseBody
    public String foo() {
        throw new IllegalArgumentException("Server error");
    }

    protected static class Message {

        @NotBlank(message = "Message value cannot be empty")
        private String value;

        public String getValue() {
            return this.value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}
