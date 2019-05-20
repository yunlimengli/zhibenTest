package com.usa.zhiben.bean.web.serverInfo;

/**
 * 磁盘使用状态
 * @author PC
 *
 */
public class ServerDiskInfo {

	private String name;//盘符名称
	private String totalSize;//总大小
	private String freeSize;//剩余
	private String freeRate;//剩余率
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
	}
	public String getFreeSize() {
		return freeSize;
	}
	public void setFreeSize(String freeSize) {
		this.freeSize = freeSize;
	}
	
	public String getFreeRate() {
		return freeRate;
	}
	public void setFreeRate(String freeRate) {
		this.freeRate = freeRate;
	}
	@Override
	public String toString() {
		return "ServerDiskInfo [name=" + name + ", totalSize=" + totalSize
				+ ", freeSize=" + freeSize + "]";
	}
	
	
}
