package com.usa.zhiben.bean.sysLog;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable {


    private Integer id;

    private String logEnevt;//日志事件

    private Integer logType;//日志类型  1系统日志 2使用者日志 3线上使用者日志

    private Integer userId;//操作账户  user 表主键

    private Date logDate;//日志时间

    private String requestIp;//访问IP

    private String serverIp;//请求服务器IP

    private Integer action;//动作

    private Integer logLevel;//日志级别  1 资讯 2 警告 3错误

    private String logDetails;//日志详细

    public SysLog() {
    }

    public SysLog(String logEnevt, Integer logType, Integer userId, Date logDate, String requestIp, String serverIp, Integer action, Integer logLevel, String logDetails) {
        this.logEnevt = logEnevt;
        this.logType = logType;
        this.userId = userId;
        this.logDate = logDate;
        this.requestIp = requestIp;
        this.serverIp = serverIp;
        this.action = action;
        this.logLevel = logLevel;
        this.logDetails = logDetails;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogEnevt() {
        return logEnevt;
    }

    public void setLogEnevt(String logEnevt) {
        this.logEnevt = logEnevt == null ? null : logEnevt.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp == null ? null : requestIp.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogDetails() {
        return logDetails;
    }

    public void setLogDetails(String logDetails) {
        this.logDetails = logDetails == null ? null : logDetails.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logEnevt=").append(logEnevt);
        sb.append(", logType=").append(logType);
        sb.append(", userId=").append(userId);
        sb.append(", logDate=").append(logDate);
        sb.append(", requestIp=").append(requestIp);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", action=").append(action);
        sb.append(", logLevel=").append(logLevel);
        sb.append(", logDetails=").append(logDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}