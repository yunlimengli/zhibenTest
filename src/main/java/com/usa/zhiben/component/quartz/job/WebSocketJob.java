package com.usa.zhiben.component.quartz.job;

import com.usa.zhiben.component.socketClient.SocketClientTask;
import org.java_websocket.WebSocket;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author 胖花
 * @create 2019-03-26 16:32
 */

public class WebSocketJob extends QuartzJobBean {

    @Autowired
    SocketClientTask socketClientTask;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("socket服务状态监测");
        //
        if(SocketClientTask.webServerSocketClient==null){
            socketClientTask.runWebSocket();
        }
        boolean equals = SocketClientTask.webServerSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN);
        if(equals){

            return;
        }else{
            //先关闭
            try {
                SocketClientTask.webServerSocketClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //在连接
            socketClientTask.runWebSocket();
        }

    }
}