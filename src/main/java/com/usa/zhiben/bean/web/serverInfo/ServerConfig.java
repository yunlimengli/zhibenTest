package com.usa.zhiben.bean.web.serverInfo;

public class ServerConfig {
    private Integer id;//主键

    private String serverIp;//服务器IP

    private Integer parentId;//上一级服务器ID

    private String serverName;//服务器名称

    private String serverId;//服务器编号

    private String serverConfig;//服务器cpu 内存  8核 16G

    private String serverDiskType;//磁盘类型

    private String serverSystemDisk;//系统盘大小

    private String serverDataDisk;//数据盘大小

    private String serverHostType;//主机类型

    private String serverBandwidthInformation;//带宽信息

    private String serverLine;//线路

    private String serverMirrorInformation;//镜像信息

    private String serverIntranetIp; //内网IP

    private String serverPublicIp;//公网IP

    private String serviceInformation;//服务信息
    
    private String serverMemory;//内存

    private Integer serverOpenStatus;//服务器是否在线 0不在线 1在线
    
    private String sub1; // 预留字段1
    
    
    
    public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName == null ? null : serverName.trim();
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId == null ? null : serverId.trim();
    }

    public String getServerConfig() {
        return serverConfig;
    }

    public void setServerConfig(String serverConfig) {
        this.serverConfig = serverConfig == null ? null : serverConfig.trim();
    }

    public String getServerDiskType() {
        return serverDiskType;
    }

    public void setServerDiskType(String serverDiskType) {
        this.serverDiskType = serverDiskType == null ? null : serverDiskType.trim();
    }

    public String getServerSystemDisk() {
        return serverSystemDisk;
    }

    public void setServerSystemDisk(String serverSystemDisk) {
        this.serverSystemDisk = serverSystemDisk == null ? null : serverSystemDisk.trim();
    }

    public String getServerDataDisk() {
        return serverDataDisk;
    }

    public void setServerDataDisk(String serverDataDisk) {
        this.serverDataDisk = serverDataDisk == null ? null : serverDataDisk.trim();
    }

    public String getServerHostType() {
        return serverHostType;
    }

    public void setServerHostType(String serverHostType) {
        this.serverHostType = serverHostType == null ? null : serverHostType.trim();
    }

    public String getServerBandwidthInformation() {
        return serverBandwidthInformation;
    }

    public void setServerBandwidthInformation(String serverBandwidthInformation) {
        this.serverBandwidthInformation = serverBandwidthInformation == null ? null : serverBandwidthInformation.trim();
    }

    public String getServerLine() {
        return serverLine;
    }

    public void setServerLine(String serverLine) {
        this.serverLine = serverLine == null ? null : serverLine.trim();
    }

    public String getServerMirrorInformation() {
        return serverMirrorInformation;
    }

    public void setServerMirrorInformation(String serverMirrorInformation) {
        this.serverMirrorInformation = serverMirrorInformation == null ? null : serverMirrorInformation.trim();
    }

    public String getServerIntranetIp() {
        return serverIntranetIp;
    }

    public void setServerIntranetIp(String serverIntranetIp) {
        this.serverIntranetIp = serverIntranetIp == null ? null : serverIntranetIp.trim();
    }

    public String getServerPublicIp() {
        return serverPublicIp;
    }

    public void setServerPublicIp(String serverPublicIp) {
        this.serverPublicIp = serverPublicIp == null ? null : serverPublicIp.trim();
    }

    public String getServiceInformation() {
        return serviceInformation;
    }

    public void setServiceInformation(String serviceInformation) {
        this.serviceInformation = serviceInformation == null ? null : serviceInformation.trim();
    }

    public Integer getServerOpenStatus() {
        return serverOpenStatus;
    }

    public void setServerOpenStatus(Integer serverOpenStatus) {
        this.serverOpenStatus = serverOpenStatus;
    }

    
    
	public String getServerMemory() {
		return serverMemory;
	}

	public void setServerMemory(String serverMemory) {
		this.serverMemory = serverMemory;
	}

	public ServerConfig() {
		super();
	}

	public ServerConfig(String serverIp, Integer parentId, String serverName, String serverId, String serverConfig,
			String serverDiskType, String serverSystemDisk, String serverDataDisk, String serverHostType,
			String serverBandwidthInformation, String serverLine, String serverMirrorInformation,
			String serverIntranetIp, String serverPublicIp, String serviceInformation, String serverMemory,
			Integer serverOpenStatus) {
		super();
		this.serverIp = serverIp;
		this.parentId = parentId;
		this.serverName = serverName;
		this.serverId = serverId;
		this.serverConfig = serverConfig;
		this.serverDiskType = serverDiskType;
		this.serverSystemDisk = serverSystemDisk;
		this.serverDataDisk = serverDataDisk;
		this.serverHostType = serverHostType;
		this.serverBandwidthInformation = serverBandwidthInformation;
		this.serverLine = serverLine;
		this.serverMirrorInformation = serverMirrorInformation;
		this.serverIntranetIp = serverIntranetIp;
		this.serverPublicIp = serverPublicIp;
		this.serviceInformation = serviceInformation;
		this.serverMemory = serverMemory;
		this.serverOpenStatus = serverOpenStatus;
	}
    
    
}