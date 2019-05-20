package com.usa.zhiben.config.interceptor;


import com.usa.zhiben.component.interceptor.FileAuthInterceptor;
import com.usa.zhiben.component.interceptor.I18nInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 胖花
 * @create 2019-03-15 11:50
 */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Autowired
    I18nInterceptor i18nInterceptor;
    @Autowired
    FileAuthInterceptor fileAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(i18nInterceptor)
                .addPathPatterns("/**/**");

        registry.addInterceptor(fileAuthInterceptor)
                .addPathPatterns("/image/**");
    }


}
