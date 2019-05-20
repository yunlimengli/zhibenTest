package com.usa.zhiben.component.socketClient;

import com.usa.zhiben.bean.web.serverInfo.ServerInfo;
import com.usa.zhiben.holder.SpringContextHolder;
import com.usa.zhiben.service.serverService.ServerInfoService;
import com.usa.zhiben.util.jsonUtils.FastJSONUtils;
import org.java_websocket.WebSocket;

import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胖花
 * @create 2019-03-26 15:48
 */

public class SocketClientTask {

    public static WebServerSocketClient webServerSocketClient;

    static String  serverNo;

    static String serverSocketUrl;

    public SocketClientTask( String serverSocketUrl,String serverNo) {
        this.serverNo = serverNo;
        this.serverSocketUrl = serverSocketUrl;
    }

    public void runWebSocket() {

        String url = serverSocketUrl+"/"+serverNo;
        System.out.println("ws_url:"+url);
        try {
            webServerSocketClient = new WebServerSocketClient(url);

            webServerSocketClient.connect();

            System.out.println("建立websocket连接");

            //将此服务器的信息传到web服务器
            ServerInfoService bean = SpringContextHolder.getBean(ServerInfoService.class);
            ServerInfo serverInfo = bean.getServerInfo();
            String strJson = FastJSONUtils.toJSONS(serverInfo);
            //发给服务器端
            sendMsgToServer("serverInfo",strJson);

        } catch (Exception e) {
            e.printStackTrace();
            //定时任务重连
        }

    }


    /**
     * 发送消息给服务器
     * @param type  消息类型
     * @param msg   消息主体
     * @return
     */
    public int sendMsgToServer(String type,String msg){

        try {
            //判断连接是否正常
            boolean equals = SocketClientTask.webServerSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN);
            if(equals){
                Map<String,Object> map = new HashMap<>();
                map.put("type",type);
                map.put("msg",msg);
                map.put("serverNo",serverNo);
                //json 化
                String jsonParm = FastJSONUtils.toJSONS(map);
                webServerSocketClient.send(jsonParm);
                return  1;
            }
        } catch (NotYetConnectedException e) {
            e.printStackTrace();
        }

        return  0;

    }




}