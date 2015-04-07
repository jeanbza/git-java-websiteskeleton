package com.websiteskeleton.core;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver jspResolver = new InternalResourceViewResolver();
        jspResolver.setPrefix("/*");
        jspResolver.setSuffix(".jsp");
        return jspResolver;
    }
}
