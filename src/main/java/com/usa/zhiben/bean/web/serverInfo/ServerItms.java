package com.usa.zhiben.bean.web.serverInfo;

import java.io.Serializable;

public class ServerItms implements Serializable {
    private Integer serverId;

    private String serverHealthStatus;

    private String serverTemperature;

    private String serverFanHealth;

    private String serverRaidStatus;

    private String serverActiveDisks;

    private String serverInactiveDisks;

    private String serverDiskStaus;

    private static final long serialVersionUID = 1L;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerHealthStatus() {
        return serverHealthStatus;
    }

    public void setServerHealthStatus(String serverHealthStatus) {
        this.serverHealthStatus = serverHealthStatus == null ? null : serverHealthStatus.trim();
    }

    public String getServerTemperature() {
        return serverTemperature;
    }

    public void setServerTemperature(String serverTemperature) {
        this.serverTemperature = serverTemperature == null ? null : serverTemperature.trim();
    }

    public String getServerFanHealth() {
        return serverFanHealth;
    }

    public void setServerFanHealth(String serverFanHealth) {
        this.serverFanHealth = serverFanHealth == null ? null : serverFanHealth.trim();
    }

    public String getServerRaidStatus() {
        return serverRaidStatus;
    }

    public void setServerRaidStatus(String serverRaidStatus) {
        this.serverRaidStatus = serverRaidStatus == null ? null : serverRaidStatus.trim();
    }

    public String getServerActiveDisks() {
        return serverActiveDisks;
    }

    public void setServerActiveDisks(String serverActiveDisks) {
        this.serverActiveDisks = serverActiveDisks == null ? null : serverActiveDisks.trim();
    }

    public String getServerInactiveDisks() {
        return serverInactiveDisks;
    }

    public void setServerInactiveDisks(String serverInactiveDisks) {
        this.serverInactiveDisks = serverInactiveDisks == null ? null : serverInactiveDisks.trim();
    }

    public String getServerDiskStaus() {
        return serverDiskStaus;
    }

    public void setServerDiskStaus(String serverDiskStaus) {
        this.serverDiskStaus = serverDiskStaus == null ? null : serverDiskStaus.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serverId=").append(serverId);
        sb.append(", serverHealthStatus=").append(serverHealthStatus);
        sb.append(", serverTemperature=").append(serverTemperature);
        sb.append(", serverFanHealth=").append(serverFanHealth);
        sb.append(", serverRaidStatus=").append(serverRaidStatus);
        sb.append(", serverActiveDisks=").append(serverActiveDisks);
        sb.append(", serverInactiveDisks=").append(serverInactiveDisks);
        sb.append(", serverDiskStaus=").append(serverDiskStaus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}