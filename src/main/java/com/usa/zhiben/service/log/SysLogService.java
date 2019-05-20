package com.usa.zhiben.service.log;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志保存类接口
 *
 * @author 胖花
 * @create 2019-03-19 10:36
 */

public interface SysLogService {


    /**
     * 保存一般日志
     *
     * @param logEvent 日志事件
     * @param logLevel 日志等级  1 资讯 2 警告 3错误
     * @param log_type 日志类型 1系统日志 2使用者日志 3线上使用者日志
     * @param details  日志详细
     * @param request  HttpServletRequest 用来获取IP session 等
     */
    public void saveSysLog(String logEvent, int logLevel, int log_type, String details, HttpServletRequest request);

    /**
     * 保存登录日志
     *
     * @param logLevel 日志等级  1 资讯 2 警告 3错误   一般正常登录就1   登录密码输出5次就3   IP 被拦截的登录就2
     * @param request
     * @param action   action 操作阻止状态 1通过 2阻止
     * @param details  日志详细
     */
    public void saveSysLoginLog(int logLevel, int action, String details, HttpServletRequest request);
}
