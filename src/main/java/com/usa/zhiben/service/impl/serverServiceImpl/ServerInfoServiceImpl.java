package com.usa.zhiben.service.impl.serverServiceImpl;

import com.usa.zhiben.bean.web.serverInfo.ServerInfo;
import com.usa.zhiben.service.serverService.ServerInfoService;
import com.usa.zhiben.util.diskUtils.SysConfigUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 胖花
 * @create 2019-03-28 15:03
 */
@Service
public class ServerInfoServiceImpl implements ServerInfoService {


    //加密狗号
    @Value(value ="${socket.server.serverNo}")
    private String serverNo;
    //服务类型
    @Value(value ="${socket.server.type}")
    private Integer serverType;
    //版本信息
    @Value(value ="${socket.server.version}")
    private String serverVersion;
    //版本信息
    @Value(value ="${server.port}")
    private Integer serverPort;

    /**
     * 获取当前采集站的信息
     *
     * @return
     */
    @Override
    public ServerInfo getServerInfo() {

        ServerInfo serverInfo = new ServerInfo();

        try {
            SysConfigUtils.getNetInfo(serverInfo);//ip
            SysConfigUtils.getDiskInfo(serverInfo);//磁盘大小
            SysConfigUtils.getServerName(serverInfo);//服务器
            serverInfo.setServerId(serverNo);
            serverInfo.setServerType(serverType);
            serverInfo.setServerHttpPort(serverPort);
            serverInfo.setServerVersion(serverVersion);
            return  serverInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
