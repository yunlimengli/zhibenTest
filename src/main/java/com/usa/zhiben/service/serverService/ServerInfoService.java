package com.usa.zhiben.service.serverService;

import com.usa.zhiben.bean.web.serverInfo.ServerInfo;

/**服务器相关操作
 * @author 胖花
 * @create 2019-03-27 15:41
 */

public interface ServerInfoService {


    /**
     * 获取当前采集站的信息
     * @return
     */
    public ServerInfo getServerInfo();
}
