package com.usa.zhiben.service.impl.sysConfigServiceImpl;

import com.usa.zhiben.bean.web.sysConfig.SysConfig;
import com.usa.zhiben.mapper.web.sysConfig.SysConfigMapper;
import com.usa.zhiben.service.sysConfigService.SysConfigService;
import com.usa.zhiben.util.redisUtils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 系统配置表的实现
 *
 * @author 胖花
 * @create 2019-03-15 14:47
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {


    @Resource
    SysConfigMapper sysConfigMapper;//系统配置表的mapper
    @Autowired
    RedisUtil redisUtil;//redis的工具类
    @Autowired
    MessageSource messageSource;//国际化资源文件

    @Override
    public Locale getSysLanguage() {

        //1.先重redis 获取 当前的语言配置
        //判断是否存在key
        String language = getLanguage();
        Locale locale = null;
        try {
            //切割
            String[] sysLanguageArr = StringUtils.split(language, "\\-");
            locale = new Locale(sysLanguageArr[0], sysLanguageArr[1]);
        } catch (Exception e) {
            e.printStackTrace();
            locale = new Locale("zh", "CN");
        }

        return locale;
    }

    /**
     * 获取当前语言的配置信息
     *
     * @return
     */
    @Override
    public String getSysLanguageStr() {

        return getLanguage();
    }

    @Override
    public int updateSysLanguage(String language) {
        int status = 0;
        //校验是否是正确的语言配置参数
        if ("zh_CN".equals(language) || "en-US".equals(language) || "de-DE".equals(language) || "fr-FR".equals(language) || "es-ES".equals(language)) {
            //更新数据库
            status = sysConfigMapper.updateSysConfigByConfigName(4, "sys_language", language);
            if (status > 0) {
                //更新成功 更改redis
                redisUtil.set("sys_language", language, 0);
            }
        }
        return status;
    }

    @Override
    public String getI18nMessageByKey(String key) {
        String message = null;
        try {
            //获取当前的语言类型
            Locale sysLanguage = getSysLanguage();
            message = messageSource.getMessage(key, null, sysLanguage);
        } catch (NoSuchMessageException e) {
            e.printStackTrace();
        }
        return message;
    }


    /**
     * 获取当前的语言配置
     *
     * @return
     */
    private String getLanguage() {
        String language = null;
        boolean bolanguage = redisUtil.hasKey("sys_language");
        if (bolanguage) {
            language = (String) redisUtil.get("sys_language");
        }
        if (StringUtils.isBlank(language)) {
            //查询数据库
            SysConfig sys_language = sysConfigMapper.selectByConfigName(4, "sys_language");
            if (sys_language != null) {
                language = sys_language.getConfigContent();
            }
            //设置进redis  永久有效 当管理员修改语言后 直接修改redis 即可
            redisUtil.set("sys_language", language, 0);
        }
        if (StringUtils.isBlank(language)) {
            language = "zh_CN";
        }
        return language;
    }
}
