package com.aau.noticeboard;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("homepage");
        registry.addViewController("/signUp").setViewName("signUp");
        registry.addViewController("/adminBar").setViewName("adminBar");
         registry.addViewController("/offices").setViewName("offices");
        registry.addViewController("/UserDashboard").setViewName("UserDashboard");   
          }

}
