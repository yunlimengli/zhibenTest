package com.usa.zhiben.config.socketConfig;

import com.usa.zhiben.component.socketClient.SocketClientTask;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 胖花
 * @create 2019-03-26 14:51
 */
@Component
public class SocketCilentConfig {

    @Value(value ="${server.port}")
    private int serverPort;

    @Value(value ="${socket.server.url}")
    private String webSocketUrl;

    @Value(value ="${socket.server.serverNo}")
    private String serverNo;




    @Bean(name = "socketClientTask")
    public SocketClientTask socketClientTask(){
//        String serverNo = "sss";
        System.out.println("serverNo:__________"+serverNo);
        SocketClientTask socketClientTask = new SocketClientTask(webSocketUrl, serverNo);
        socketClientTask.runWebSocket();
        return  socketClientTask;
    }
}
