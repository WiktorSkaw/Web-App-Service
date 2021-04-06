package com.wiktor.WebApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }


    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {

        registry.addViewController("/mainpage.html");

    }
}
