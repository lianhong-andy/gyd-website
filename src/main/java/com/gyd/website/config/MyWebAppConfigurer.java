package com.gyd.website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lianhong
 * @description 拦截器配置
 * @date 2019/10/21 0021下午 1:22
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    private MenuInterceptor menuInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(menuInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**可放掉多个路径下的静态资源*/
        registry.addResourceHandler("/static/**","/templates/**").addResourceLocations("classpath:/static/","classpath:/templates/");
    }
}
