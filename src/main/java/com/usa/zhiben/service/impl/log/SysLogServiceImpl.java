package com.usa.zhiben.service.impl.log;

import com.usa.zhiben.bean.sysLog.SysLog;
import com.usa.zhiben.bean.web.user.User;
import com.usa.zhiben.mapper.sysLog.SysLogMapper;
import com.usa.zhiben.service.log.SysLogService;
import com.usa.zhiben.service.sysConfigService.SysConfigService;
import com.usa.zhiben.util.HttpUtils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 胖花
 * @create 2019-03-19 11:10
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysConfigService sysConfigService;
    @Autowired
    SysLogMapper sysLogMapper;


    /**
     * 保存一般日志
     *
     * @param logEvent 日志事件
     * @param logLevel 日志等级  1 资讯 2 警告 3错误
     * @param log_type 日志类型 1系统日志 2使用者日志 3线上使用者日志
     * @param request  HttpServletRequest 用来获取IP session 等
     */
    @Override
    public void saveSysLog(String logEvent, int logLevel, int log_type, String details, HttpServletRequest request) {

        try {
            //获取国际化的 logEvent
            logEvent = sysConfigService.getI18nMessageByKey(logEvent);
            //获取 访问的IP
            String ipAddr = HttpUtils.getIpAddr(request);
            //获取 Session
            User user = HttpUtils.getSessionUser(request);
            Integer userId = user == null ? null : user.getId();
            //获取本服务器的IP
            String loacServerIp = HttpUtils.getLoacServerIp();
            //详细
            details = sysConfigService.getI18nMessageByKey(details);

            SysLog log = new SysLog(logEvent, log_type, userId, new Date(), ipAddr, loacServerIp, null, logLevel, details);
            sysLogMapper.insert(log);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 保存登录日志
     *
     * @param logLevel 日志等级  1 资讯 2 警告 3错误   一般正常登录就1   登录密码输出5次就3   IP 被拦截的登录就2
     * @param request
     * @param action   action 操作阻止状态 1通过 2阻止
     */
    @Override
    public void saveSysLoginLog(int logLevel, int action, String details, HttpServletRequest request) {


    }


}
