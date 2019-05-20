package com.usa.zhiben.service.sysConfigService;

import java.util.Locale;

/**
 * 系统配置表
 *
 * @author 胖花
 * @create 2019-03-15 14:45
 */

public interface SysConfigService {


    /**
     * 获取当前的语言配置信息  是什么版本的语言
     *
     * @return
     */
    Locale getSysLanguage();

    /**
     * 获取当前语言的配置信息
     *
     * @return
     */
    public String getSysLanguageStr();


    /**
     * 更新当前系统的语言
     *
     * @param language
     * @return
     */
    int updateSysLanguage(String language);


    /**
     * 获取当前国际化的 KEY 对应的信息
     *
     * @param key
     * @return
     */
    public String getI18nMessageByKey(String key);
}
