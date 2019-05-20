package com.usa.zhiben.config.fileAuthConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 胖花
 * @create 2019-03-21 15:13
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/D/**").addResourceLocations("file:D:/");
        registry.addResourceHandler("/image/F/**").addResourceLocations("file:F:/");
    }
}