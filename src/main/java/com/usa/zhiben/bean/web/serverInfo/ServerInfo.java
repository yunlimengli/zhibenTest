package com.usa.zhiben.bean.web.serverInfo;

import java.io.Serializable;

public class ServerInfo implements Serializable {

    private Integer id;

    private String serverName;

    private String serverIp;

    private String serverDisks;

    private String serverCapacity;

    private String serverFreeSpace;

    private String serverHealthyStatus;

    private String serverVersion;

    private String serverId;

    private Integer serverType;

    private String saveRoot;

    private Integer serverHttpPort;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public String getServerDisks() {
        return serverDisks;
    }

    public void setServerDisks(String serverDisks) {
        this.serverDisks = serverDisks == null ? null : serverDisks.trim();
    }

    public String getServerCapacity() {
        return serverCapacity;
    }

    public void setServerCapacity(String serverCapacity) {
        this.serverCapacity = serverCapacity == null ? null : serverCapacity.trim();
    }

    public String getServerFreeSpace() {
        return serverFreeSpace;
    }

    public void setServerFreeSpace(String serverFreeSpace) {
        this.serverFreeSpace = serverFreeSpace == null ? null : serverFreeSpace.trim();
    }

    public String getServerHealthyStatus() {
        return serverHealthyStatus;
    }

    public void setServerHealthyStatus(String serverHealthyStatus) {
        this.serverHealthyStatus = serverHealthyStatus == null ? null : serverHealthyStatus.trim();
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion == null ? null : serverVersion.trim();
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getSaveRoot() {
        return saveRoot;
    }

    public void setSaveRoot(String saveRoot) {
        this.saveRoot = saveRoot == null ? null : saveRoot.trim();
    }

    public Integer getServerHttpPort() {
        return serverHttpPort;
    }

    public void setServerHttpPort(Integer serverHttpPort) {
        this.serverHttpPort = serverHttpPort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", serverName=").append(serverName);
        sb.append(", serverIp=").append(serverIp);
        sb.append(", serverDisks=").append(serverDisks);
        sb.append(", serverCapacity=").append(serverCapacity);
        sb.append(", serverFreeSpace=").append(serverFreeSpace);
        sb.append(", serverHealthyStatus=").append(serverHealthyStatus);
        sb.append(", serverVersion=").append(serverVersion);
        sb.append(", serverId=").append(serverId);
        sb.append(", serverType=").append(serverType);
        sb.append(", saveRoot=").append(saveRoot);
        sb.append(", serverHttpPort=").append(serverHttpPort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}