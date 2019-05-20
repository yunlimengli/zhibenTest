package com.usa.zhiben.config.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author 胖花
 * 国际化配置类
 * @create 2019-03-15 10:28
 */
@Configuration
public class MessageSourceConfig {


    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getMessageSource() throws Exception {

        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setBasenames("i18n/messages/message");
        return resourceBundleMessageSource;

    }


    /*
     *   国际化 语言配置
     * */
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolverBean() {

        return new SessionLocaleResolver();
    }


}
