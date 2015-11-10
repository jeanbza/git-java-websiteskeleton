package com.websiteskeleton.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    @Value("${some.yaml.property}") String someYamlProperty;

    @Bean
    public String someYamlProperty() {
        return someYamlProperty;
    }

    @Bean RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
