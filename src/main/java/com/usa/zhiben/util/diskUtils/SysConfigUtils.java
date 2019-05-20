package com.usa.zhiben.util.diskUtils;
import com.usa.zhiben.bean.web.serverInfo.ServerConfigStatus;
import com.usa.zhiben.bean.web.serverInfo.ServerDiskInfo;
import com.usa.zhiben.bean.web.serverInfo.ServerInfo;
import com.usa.zhiben.util.dataUtils.RegexUtils;
import org.apache.commons.lang.StringUtils;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.*;


public class SysConfigUtils {


	public static void property(Map<String,Object> messageInfo) throws UnknownHostException {
		Runtime r = Runtime.getRuntime();
		Properties props = System.getProperties();
		InetAddress addr;
		addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress();
		Map<String, String> map = System.getenv();
		String userName = map.get("USERNAME");// 获取用户名
		String computerName = map.get("COMPUTERNAME");// 获取计算机名
		String userDomain = map.get("USERDOMAIN");// 获取计算机域名
		System.out.println("用户名:    " + userName);
		messageInfo.put("1.1", userName);

		System.out.println("计算机名:    " + computerName);
		messageInfo.put("1.2", computerName);

		System.out.println("计算机域名:    " + userDomain);
		messageInfo.put("1.3", userDomain);

		System.out.println("本地ip地址:    " + ip);
		messageInfo.put("1.4", ip);

		System.out.println("本地主机名:    " + addr.getHostName());
		messageInfo.put("1.5", addr.getHostName());

		System.out.println("JVM可以使用的总内存:    " + r.totalMemory());
		System.out.println("JVM可以使用的剩余内存:    " + r.freeMemory());
		System.out.println("JVM可以使用的处理器个数:    " + r.availableProcessors());
		System.out.println("Java的运行环境版本：    " + props.getProperty("java.version"));
		System.out.println("Java的运行环境供应商：    " + props.getProperty("java.vendor"));
		System.out.println("Java供应商的URL：    " + props.getProperty("java.vendor.url"));
		System.out.println("Java的安装路径：    " + props.getProperty("java.home"));
		System.out.println("Java的虚拟机规范版本：    " + props.getProperty("java.vm.specification.version"));
		System.out.println("Java的虚拟机规范供应商：    " + props.getProperty("java.vm.specification.vendor"));
		System.out.println("Java的虚拟机规范名称：    " + props.getProperty("java.vm.specification.name"));
		System.out.println("Java的虚拟机实现版本：    " + props.getProperty("java.vm.version"));
		System.out.println("Java的虚拟机实现供应商：    " + props.getProperty("java.vm.vendor"));
		System.out.println("Java的虚拟机实现名称：    " + props.getProperty("java.vm.name"));
		System.out.println("Java运行时环境规范版本：    " + props.getProperty("java.specification.version"));
		System.out.println("Java运行时环境规范供应商：    " + props.getProperty("java.specification.vender"));
		System.out.println("Java运行时环境规范名称：    " + props.getProperty("java.specification.name"));
		System.out.println("Java的类格式版本号：    " + props.getProperty("java.class.version"));
		System.out.println("Java的类路径：    " + props.getProperty("java.class.path"));
		System.out.println("加载库时搜索的路径列表：    " + props.getProperty("java.library.path"));
		System.out.println("默认的临时文件路径：    " + props.getProperty("java.io.tmpdir"));
		System.out.println("一个或多个扩展目录的路径：    " + props.getProperty("java.ext.dirs"));

		System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
		messageInfo.put("1.6", props.getProperty("os.name"));

		System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
		messageInfo.put("1.7", props.getProperty("os.arch"));

		System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
		System.out.println("文件分隔符：    " + props.getProperty("file.separator"));
		System.out.println("路径分隔符：    " + props.getProperty("path.separator"));
		System.out.println("行分隔符：    " + props.getProperty("line.separator"));
		System.out.println("用户的账户名称：    " + props.getProperty("user.name"));
		System.out.println("用户的主目录：    " + props.getProperty("user.home"));
		System.out.println("用户的当前工作目录：    " + props.getProperty("user.dir"));
	}

	public static void memory(Map<String,Object> messageInfo) throws SigarException {
		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		// 内存总量
		System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
		messageInfo.put("2.1", mem.getTotal() / 1024L/1024L + "MB");
		// 当前内存使用量
		System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
		messageInfo.put("2.2", mem.getUsed() / 1024L/1024L + "MB");
		// 当前内存剩余量
		System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
		messageInfo.put("2.3", mem.getFree() / 1024L/1024L + "MB");
		Swap swap = sigar.getSwap();
		// 交换区总量
		System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
		// 当前交换区使用量
		System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
		// 当前交换区剩余量
		System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");
	}

	public static void cpu(Map<String,Object> messageInfo) throws SigarException {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Sigar sigar = new Sigar();
		CpuInfo infos[] = sigar.getCpuInfoList();
		CpuPerc cpuList[] = null;
		cpuList = sigar.getCpuPercList();
		messageInfo.put("4.1", infos.length+"X");
		messageInfo.put("4.2", infos[0].getMhz()+" HZ");
		messageInfo.put("4.3", "CPU类别："+infos[0].getModel());
		Double cupUserL = 0.0;
		for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
			CpuInfo info = infos[i];
			System.out.println("第" + (i + 1) + "块CPU信息");
			System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
			System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
			System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
			System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
			double printCpuPerc = printCpuPerc(cpuList[i]);
			cupUserL += printCpuPerc;
		}
		System.out.println("CPU使用率："+String.format("%.2f", cupUserL/infos.length));
		messageInfo.put("4.4", "CPU使用率："+String.format("%.2f", cupUserL/infos.length)+"%");



	}

	public static double printCpuPerc(CpuPerc cpu) {

		System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
		System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
		System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
		System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
		System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
		System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
		String format = CpuPerc.format(cpu.getCombined());
		String[] split = format.split("\\%");
		double parseDouble = Double.parseDouble(split[0]);
		return parseDouble;
	}

	public static void os() {
		OperatingSystem OS = OperatingSystem.getInstance();
		// 操作系统内核类型如： 386、486、586等x86
		System.out.println("操作系统:    " + OS.getArch());
		System.out.println("操作系统CpuEndian():    " + OS.getCpuEndian());//
		System.out.println("操作系统DataModel():    " + OS.getDataModel());//
		// 系统描述
		System.out.println("操作系统的描述:    " + OS.getDescription());
		// 操作系统类型
		// System.out.println("OS.getName():    " + OS.getName());
		// System.out.println("OS.getPatchLevel():    " + OS.getPatchLevel());//
		// 操作系统的卖主
		System.out.println("操作系统的卖主:    " + OS.getVendor());
		// 卖主名称
		System.out.println("操作系统的卖主名:    " + OS.getVendorCodeName());
		// 操作系统名称
		System.out.println("操作系统名称:    " + OS.getVendorName());
		// 操作系统卖主类型
		System.out.println("操作系统卖主类型:    " + OS.getVendorVersion());
		// 操作系统的版本号
		System.out.println("操作系统的版本号:    " + OS.getVersion());
	}

	public static void who() throws SigarException {
		Sigar sigar = new Sigar();
		Who who[] = sigar.getWhoList();
		if (who != null && who.length > 0) {
			for (int i = 0; i < who.length; i++) {
				// System.out.println("当前系统进程表中的用户名" + String.valueOf(i));
				Who _who = who[i];
				System.out.println("用户控制台:    " + _who.getDevice());
				System.out.println("用户host:    " + _who.getHost());
				// System.out.println("getTime():    " + _who.getTime());
				// 当前系统进程表中的用户名
				System.out.println("当前系统进程表中的用户名:    " + _who.getUser());
			}
		}
	}

	@Autowired
	public static void file(Map<String,Object> messageInfo) throws Exception{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		File[] roots = File.listRoots();
		double constm = 1024 * 1024 * 1024 ;
		double total = 0d;
		double usedtotal = 0d;
		for (File file : roots) {
			Map<String,Object> map = new HashMap<String, Object>();
			System.out.println(file.getPath());
			map.put("3b", file.getPath());
			System.out.println("剩余空间 = " + doubleFormat(file.getFreeSpace()/constm)+" G");
			map.put("3e", doubleFormat(file.getFreeSpace()/constm)+" G");

			System.out.println("已使用空间 = " + doubleFormat(file.getUsableSpace()/constm)+" G");
			map.put("3g", doubleFormat(file.getUsableSpace()/constm)+" G");
			usedtotal +=file.getUsableSpace();

			System.out.println(file.getPath()+"盘总大小 = " + doubleFormat(file.getTotalSpace()/constm)+" G");
			map.put("3d", doubleFormat(file.getTotalSpace()/constm)+" G");
			total += file.getTotalSpace();
			long usableSpace = file.getUsableSpace();
			if(usableSpace==0){
				map.put("3h", 0+"%");
			}else{
				//使用率
				double to = file.getTotalSpace()/constm;
				double u = file.getUsableSpace()/constm;
				String doubleFormat = doubleFormat(u/to*100);
				map.put("3h", doubleFormat+"%");
				System.out.println("磁盘使用率："+doubleFormat+"%");
			}

			list.add(map);
		}
		System.out.println("你的硬盘总大小 = "+doubleFormat(total/constm));
		System.out.println("你的硬盘已使用 = "+doubleFormat(usedtotal/constm));
		messageInfo.put("3.1", list);
		messageInfo.put("3.2", doubleFormat(total/constm));//磁盘总大小
		messageInfo.put("3.3", doubleFormat(usedtotal/constm));//硬盘已使用

	}
	private static String doubleFormat(double d){
		DecimalFormat df = new DecimalFormat("0.##");
		return df.format(d);
	}

	public static void net() throws Exception {
		Sigar sigar = new Sigar();
		String ifNames[] = sigar.getNetInterfaceList();
		for (int i = 0; i < ifNames.length; i++) {
			String name = ifNames[i];
			NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name);
			System.out.println("网络设备名:    " + name);// 网络设备名
			System.out.println("IP地址:    " + ifconfig.getAddress());// IP地址
			System.out.println("子网掩码:    " + ifconfig.getNetmask());// 子网掩码
			if ((ifconfig.getFlags() & 1L) <= 0L) {
				System.out.println("!IFF_UP...skipping getNetInterfaceStat");
				continue;
			}
			NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);
			System.out.println(name + "接收的总包裹数:" + ifstat.getRxPackets());// 接收的总包裹数
			System.out.println(name + "发送的总包裹数:" + ifstat.getTxPackets());// 发送的总包裹数
			System.out.println(name + "接收到的总字节数:" + ifstat.getRxBytes());// 接收到的总字节数
			System.out.println(name + "发送的总字节数:" + ifstat.getTxBytes());// 发送的总字节数
			System.out.println(name + "接收到的错误包数:" + ifstat.getRxErrors());// 接收到的错误包数
			System.out.println(name + "发送数据包时的错误数:" + ifstat.getTxErrors());// 发送数据包时的错误数
			System.out.println(name + "接收时丢弃的包数:" + ifstat.getRxDropped());// 接收时丢弃的包数
			System.out.println(name + "发送时丢弃的包数:" + ifstat.getTxDropped());// 发送时丢弃的包数
		}
	}

	public static void ethernet() throws SigarException {
		Sigar sigar = null;
		sigar = new Sigar();
		String[] ifaces = sigar.getNetInterfaceList();
		for (int i = 0; i < ifaces.length; i++) {
			NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
			if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
					|| NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
				continue;
			}
			System.out.println(cfg.getName() + "IP地址:" + cfg.getAddress());// IP地址
			System.out.println(cfg.getName() + "网关广播地址:" + cfg.getBroadcast());// 网关广播地址
			System.out.println(cfg.getName() + "网卡MAC地址:" + cfg.getHwaddr());// 网卡MAC地址
			System.out.println(cfg.getName() + "子网掩码:" + cfg.getNetmask());// 子网掩码
			System.out.println(cfg.getName() + "网卡描述信息:" + cfg.getDescription());// 网卡描述信息
			System.out.println(cfg.getName() + "网卡类型" + cfg.getType());//
		}
	}

	public static void getCpuAndMemory(Map<String,Object> messageInfo) throws Exception{
		//cpu 信息
		Sigar sigar = new Sigar();
		CpuInfo infos[] = sigar.getCpuInfoList();
		CpuPerc cpuList[] = null;
		cpuList = sigar.getCpuPercList();
		Double cupUserL = 0.0;
		for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
			CpuInfo info = infos[i];
			System.out.println("第" + (i + 1) + "块CPU信息");
			System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
			System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
			System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
			System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
			double printCpuPerc = printCpuPerc(cpuList[i]);
			cupUserL += printCpuPerc;
		}
		System.out.println("CPU使用率："+String.format("%.2f", cupUserL/infos.length)+"%");
		messageInfo.put("cpu", String.format("%.2f", cupUserL/infos.length)+"%");
		//内存
		Mem mem = sigar.getMem();
		// 内存总量
		// 当前内存使用量
		double totalM =  mem.getTotal()/1024L/1024L;
		System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L/1024L + "MB");
		messageInfo.put("memoryUsed", mem.getUsed() / 1024L/1024L/totalM+"%");
		// 当前内存剩余量
		System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L /1024L+ "MB");
		messageInfo.put("memoryS", mem.getFree() / 1024L/1024L/totalM+"%" );
		System.out.println("内存使用率："+(mem.getUsed() / 1024L/1024L/totalM)*100+"%");
		String doubleFormat = doubleFormat((mem.getUsed() / 1024L/1024L/totalM)*100);
		messageInfo.put("memorySl", doubleFormat+"%" );
		file(messageInfo);

	}

	//------------------------国标版采集站--------------------------------

	/**
	 * 获取当前windos 服务器的 所有的IP MAC地址
	 * @param serverInfo
	 * @return
	 * @throws Exception
	 */
	public static void getNetInfo(ServerInfo serverInfo) throws Exception{

		Sigar sigar = new Sigar();
		String[] ifaces = sigar.getNetInterfaceList();
		for (int i = 0; i < ifaces.length; i++) {
			NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
			if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0
					|| NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
				continue;
			}
			String address = cfg.getAddress();
			boolean checkIpAddress = RegexUtils.checkIpAddress(address);
			if(!checkIpAddress){
				continue;
			}
			//先添加第一个IP
			serverInfo.setServerIp(address);

//		            System.out.println(cfg.getName() + "IP地址:" + cfg.getAddress());// IP地址
//		            System.out.println(cfg.getName() + "网关广播地址:" + cfg.getBroadcast());// 网关广播地址
//		            System.out.println(cfg.getName() + "网卡MAC地址:" + cfg.getHwaddr());// 网卡MAC地址
//		            System.out.println(cfg.getName() + "子网掩码:" + cfg.getNetmask());// 子网掩码
//		            System.out.println(cfg.getName() + "网卡描述信息:" + cfg.getDescription());// 网卡描述信息
//		            System.out.println(cfg.getName() + "网卡类型" + cfg.getType());//
		}
	}

	/**
	 * 获取所以的盘符信息 已经磁盘空间大小
	 * @param serverInfo
	 */
	public static void getDiskInfo(ServerInfo serverInfo){

		File[] roots = File.listRoots();
		double constm = 1024 * 1024 * 1024 ;
		double total = 0d;
		double freeTotal = 0d;
		StringBuilder panfuName = new StringBuilder();
		for (File file : roots) {
			String path = file.getPath();
			String[] split = path.split("\\:");
			if(split!=null){
				path = split[0];
				panfuName.append(path);
				panfuName.append(",");
			}
			System.out.println(path);

			total += file.getTotalSpace();
			System.out.println(path+"总空间 = " + doubleFormat(file.getTotalSpace()/constm)+" G");
			freeTotal +=file.getFreeSpace();
			System.out.println(path+"剩余空间 = " + doubleFormat(file.getFreeSpace()/constm)+" G");

		}
		System.out.println("你的硬盘总大小 = "+doubleFormat(total/constm));
		System.out.println("你的硬盘剩余 = "+doubleFormat(freeTotal/constm));

		//总容量
		serverInfo.setServerCapacity(doubleFormat(total/constm));
		serverInfo.setServerDisks(String.valueOf(roots.length));
		serverInfo.setServerFreeSpace(doubleFormat(freeTotal/constm));
		double temp = freeTotal/total;
		if(temp>0.3){
			serverInfo.setServerHealthyStatus("1");//健康
		}
		if(temp>0.1&&temp<0.3){
			serverInfo.setServerHealthyStatus("2");//警告
		}
		if(temp<0.1){
			serverInfo.setServerHealthyStatus("3");//危险
		}
	}

	/**
	 * 获取CPU 以及 内存信息
	 * @param serverInfo
	 * @throws SigarException
	 */
	public static void getCpuAndMemory(ServerInfo serverInfo) throws SigarException{

	    /*    Sigar sigar = new Sigar();
	        CpuInfo infos[] = sigar.getCpuInfoList();
	        String cpuInfo = infos[0].getModel() +"   X"+ infos.length;
	        System.out.println(cpuInfo);
	        //CPU信息
	        serverInfo.setServerCpu(cpuInfo);
	    	//内存信息
	        Mem mem = sigar.getMem();
	        // 内存总量
	        String serverMemory = String.valueOf(mem.getTotal() / 1024L/ 1024L);
	        System.out.println(serverMemory+"MB");
	        serverInfo.setServerMemory(serverMemory+" MB");*/
	}
	/**
	 * 设置服务器名称
	 * @param serverInfo
	 */
	public static void getServerName(ServerInfo serverInfo){
		Map<String, String> map = System.getenv();
		String userName = map.get("USERNAME");// 获取用户名
		String computerName = map.get("COMPUTERNAME");// 获取计算机名
		serverInfo.setServerName(computerName);
	}

	/**
	 * 获取CPU的使用率
	 * @param serverConfigStatus
	 * @throws SigarException
	 */
	public static void getServerCpuStatus(ServerConfigStatus serverConfigStatus) throws SigarException{


		Sigar sigar = new Sigar();
		CpuPerc cpuList[] = sigar.getCpuPercList();
		Double cupUserL = 0.0;
		for (CpuPerc cpuPerc : cpuList) {
			double printCpuPerc = printCpuPerc(cpuPerc);
			cupUserL += printCpuPerc;
		}
		if(cpuList!=null&&cpuList.length>0){
			System.out.println("CPU使用率："+String.format("%.2f", cupUserL/cpuList.length));
			serverConfigStatus.setCpuUsageRate(String.format("%.2f", cupUserL/cpuList.length));
		}

	}

	/**
	 * 获取服务器内存信息
	 * @param serverConfigStatus
	 * @throws SigarException
	 */
	public static void getServerMemoryStatus(ServerConfigStatus serverConfigStatus) throws SigarException{

		Sigar sigar = new Sigar();
		Mem mem = sigar.getMem();
		// 内存总量
		long total = mem.getTotal()/ 1024L/ 1024L;
		serverConfigStatus.setMemoryTotal(total+" MB");
		//当前内存剩余量
		long free = mem.getFree() / 1024L/1024L;
		serverConfigStatus.setMemoryFreeTotal(free+" MB");
		String percent = getPercent((total-free), total);
		serverConfigStatus.setMemoryUsageRate(percent);
	}
	/**
	 * 获取各个盘符的 磁盘使用情况
	 * @param serverConfigStatus
	 * @return
	 */
	public static void getServerDiskStatus(ServerConfigStatus serverConfigStatus){

		List<ServerDiskInfo> diskInfoList = new ArrayList<>();
		File[] roots = File.listRoots();
		double constm = 1024 * 1024 * 1024 ;
		double total = 0d;
		double freeTotal = 0d;
		for (File file : roots) {
			ServerDiskInfo serverDiskInfo = new ServerDiskInfo();
			String path = file.getPath();
			String[] split = path.split("\\:");
			if(split!=null){
				path = split[0];
			}
			serverDiskInfo.setName(path);
			//总大小
			String totalSize = doubleFormat(file.getTotalSpace()/constm);
			serverDiskInfo.setTotalSize(totalSize);
			//剩余
			String freeSize = doubleFormat(file.getFreeSpace()/constm);
			serverDiskInfo.setFreeSize(freeSize);
			long freeSpace = file.getFreeSpace();
			long totalSpace = file.getTotalSpace();
			total += totalSpace;
			freeTotal +=freeSpace;
			if(totalSpace!=0){
				serverDiskInfo.setFreeRate(String.format("%.2f", ((freeSpace*1.0)/totalSpace)*100));
			}else{
				serverDiskInfo.setFreeRate("0");
			}
			diskInfoList.add(serverDiskInfo);
		}

		System.out.println("你的硬盘总大小 = "+doubleFormat(total/constm));
		System.out.println("你的剩余使用 = "+doubleFormat(freeTotal/constm));
		serverConfigStatus.setDiskUsageRate(diskInfoList);
		serverConfigStatus.setDiskTotal(doubleFormat(total/constm));
		serverConfigStatus.setDiskFreeTotal(doubleFormat(freeTotal/constm));
		serverConfigStatus.setDiskTotalUsageRate(String.format("%.2f", (freeTotal/total)*100));
	}

	public static String getPercent(long num,long totalPeople ){
		DecimalFormat df = new DecimalFormat("0.00");//格式化小数
		String te = df.format((double)(num*1.0/totalPeople)*100);//返回的是String类型
		return te;
	}


	/**
	 * 判断当前的系统
	 * @return
	 */
	public static int getSystemType() {

		Properties props = System.getProperties();
        String property = props.getProperty("os.name");
        String str = property.toUpperCase();
        if(str.startsWith("WIN")){
            return  1;//windos
        }else {
            return  2;//linux
        }


    }


    /**
     * 获取当前主机的
     * @return
     */
    public static Map<String, Double> getSurplusDiskSize() {

        Map<String,Double> map = new HashMap<>();
        File[] roots = File.listRoots();
        double constm = 1024 * 1024  ;//单位 MB
        double total = 0d;
        double freeTotal = 0d;
        for (File file : roots) {
            String path = file.getPath();
            String[] split = StringUtils.split(path, "\\:");

            total += file.getTotalSpace();
            System.out.println(path+"总空间 = " + doubleFormat(file.getTotalSpace()/constm)+" G");
            freeTotal +=file.getFreeSpace();
            System.out.println(path+"剩余空间 = " + doubleFormat(file.getFreeSpace()/constm)+" G");
            map.put(split[0],file.getFreeSpace()/constm);
        }

        //总容量
        map.put("totalSize",total);
        map.put("surplusSize",freeTotal);

        return map;

    }
}
