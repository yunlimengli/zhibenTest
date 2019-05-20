package com.usa.zhiben.bean.web.user;

import java.util.Date;

public class LockIp {
    /**
     *
     */
    private Integer id;

    /**
     * 锁定IP地址
     */
    private String ipAddress;

    /**
     * 锁定时间
     */
    private Date lockTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 锁定IP地址
     *
     * @return ip_address 锁定IP地址
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 锁定IP地址
     *
     * @param ipAddress 锁定IP地址
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    /**
     * 锁定时间
     *
     * @return lock_time 锁定时间
     */
    public Date getLockTime() {
        return lockTime;
    }

    /**
     * 锁定时间
     *
     * @param lockTime 锁定时间
     */
    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}