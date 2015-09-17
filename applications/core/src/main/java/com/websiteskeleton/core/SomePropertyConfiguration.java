package com.websiteskeleton.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:some-properties.properties")
public class SomePropertyConfiguration {
    @Value("${foo.bar}")
    private String propsFileValue;

    @Bean
    public String propsFileValue() {
        return propsFileValue;
    }
}
