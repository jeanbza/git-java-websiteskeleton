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
        jspResolver.setPrefix("/views/");
        jspResolver.setSuffix(".jsp");
        return jspResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/**").addResourceLocations("classpath:/META-INF/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/META-INF/resources/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/META-INF/resources/img/");
    }
}
