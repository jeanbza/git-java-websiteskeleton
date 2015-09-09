package com.websiteskeleton.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class YamlConfiguration {
    @Value("${some.yaml.property}")
    private String yamlPropertyMessage;

    @Bean String yamlPropertyMessage() {
        return yamlPropertyMessage;
    }

    @Profile("default")
    @Configuration
    public static class LocalYamlConfiguration {
        @Bean
        public PropertySourcesPlaceholderConfigurer properties() {
            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(new ClassPathResource("application.yml"));
            propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());

            return propertySourcesPlaceholderConfigurer;
        }
    }

    @Profile("test")
    @Configuration
    public static class TestYamlConfiguration {
        @Bean
        public PropertySourcesPlaceholderConfigurer properties() {
            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(new ClassPathResource("application-test.yml"));
            propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());

            return propertySourcesPlaceholderConfigurer;
        }
    }
}
