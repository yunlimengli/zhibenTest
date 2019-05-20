package com.usa.zhiben.bean.web.serverInfo;


import java.util.Date;

public class CpuResourceUsage {
    private Integer id;

    private String serverId;//服务器id

    private String serverCpu;//CPU使用率

    private String serverMemory;//内存使用率

    private String serverIo;//磁盘使用率

    private Date createTime;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public String getServerCpu() {
        return serverCpu;
    }

    public void setServerCpu(String serverCpu) {
        this.serverCpu = serverCpu == null ? null : serverCpu.trim();
    }

    public String getServerMemory() {
        return serverMemory;
    }

    public void setServerMemory(String serverMemory) {
        this.serverMemory = serverMemory == null ? null : serverMemory.trim();
    }

    public String getServerIo() {
        return serverIo;
    }

    public void setServerIo(String serverIo) {
        this.serverIo = serverIo == null ? null : serverIo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}