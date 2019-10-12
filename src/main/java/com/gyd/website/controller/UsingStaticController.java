package com.gyd.website.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author lianhong
 * @description
 * @date 2019/9/30 0030下午 2:53
 */
@Configuration
public class UsingStaticController extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**可放掉多个路径下的静态资源*/
        registry.addResourceHandler("/static/**","/templates/**").addResourceLocations("classpath:/static/","classpath:/templates/");
    }
}
