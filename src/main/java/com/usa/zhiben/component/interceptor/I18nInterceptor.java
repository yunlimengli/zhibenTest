package com.usa.zhiben.component.interceptor;

import com.usa.zhiben.service.sysConfigService.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化的拦截器  为每个请求设置当前服务器的国际化配置
 *
 * @author 胖花
 * @create 2019-03-15 11:14
 */

@Component
public class I18nInterceptor implements HandlerInterceptor {

    @Autowired
    LocaleResolver localeResolver;
    @Autowired
    SysConfigService sysConfigService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        //设置国际化
        //获取当前服务器设置的国际化信息
        //中文 Locale.CHINA;   zh-CN
        //英文 Locale.US;      en-US
        //德语 Locale.GERMAN   de-DE
        //法语 Locale.FRENCH   fr-FR
        //西班牙                es-ES
        //自己创建一个语言  注意 和配置文件的 名称要对应上 如 message_en_US.properties   en 对应 language US 对应 county
        Locale sysLanguage = sysConfigService.getSysLanguage();
        //设置语言
        localeResolver.setLocale(httpServletRequest, httpServletResponse, sysLanguage);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }


}
