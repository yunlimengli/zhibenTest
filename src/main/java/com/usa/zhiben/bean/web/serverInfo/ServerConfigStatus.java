package com.usa.zhiben.bean.web.serverInfo;

import java.util.List;

public class ServerConfigStatus {

	private String cpuUsageRate;//CPU 使用率
	private String memoryTotal;//内存总数
	private String memoryFreeTotal;//内存剩余总数
	private String memoryUsageRate;//内存 使用率
	private String diskTotal;//磁盘总大小
	private String diskFreeTotal;//剩余大小
	private String diskTotalUsageRate;//磁盘总使用
	private List<ServerDiskInfo> diskUsageRate;//各磁盘使用情况
	
	
	public String getCpuUsageRate() {
		return cpuUsageRate;
	}
	public void setCpuUsageRate(String cpuUsageRate) {
		this.cpuUsageRate = cpuUsageRate;
	}
	public String getMemoryUsageRate() {
		return memoryUsageRate;
	}
	public void setMemoryUsageRate(String memoryUsageRate) {
		this.memoryUsageRate = memoryUsageRate;
	}
	public List<ServerDiskInfo> getDiskUsageRate() {
		return diskUsageRate;
	}
	public void setDiskUsageRate(List<ServerDiskInfo> diskUsageRate) {
		this.diskUsageRate = diskUsageRate;
	}
	public String getMemoryTotal() {
		return memoryTotal;
	}
	public void setMemoryTotal(String memoryTotal) {
		this.memoryTotal = memoryTotal;
	}
	public String getMemoryFreeTotal() {
		return memoryFreeTotal;
	}
	public void setMemoryFreeTotal(String memoryFreeTotal) {
		this.memoryFreeTotal = memoryFreeTotal;
	}
	
	public String getDiskTotal() {
		return diskTotal;
	}
	public void setDiskTotal(String diskTotal) {
		this.diskTotal = diskTotal;
	}
	public String getDiskFreeTotal() {
		return diskFreeTotal;
	}
	public void setDiskFreeTotal(String diskFreeTotal) {
		this.diskFreeTotal = diskFreeTotal;
	}
	
	public String getDiskTotalUsageRate() {
		return diskTotalUsageRate;
	}
	public void setDiskTotalUsageRate(String diskTotalUsageRate) {
		this.diskTotalUsageRate = diskTotalUsageRate;
	}
	@Override
	public String toString() {
		return "ServerConfigStatus [cpuUsageRate=" + cpuUsageRate
				+ ", memoryTotal=" + memoryTotal + ", memoryFreeTotal="
				+ memoryFreeTotal + ", memoryUsageRate=" + memoryUsageRate
				+ ", diskUsageRate=" + diskUsageRate + "]";
	}
	
	
}
