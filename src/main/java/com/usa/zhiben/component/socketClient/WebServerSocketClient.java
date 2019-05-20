package com.usa.zhiben.component.socketClient;


import com.usa.zhiben.holder.SpringContextHolder;
import com.usa.zhiben.service.fileService.FileService;
import com.usa.zhiben.util.jsonUtils.FastJSONUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * websocket 客户端
 * @author 胖花
 * @create 2019-03-26 14:46
 */

public class WebServerSocketClient extends WebSocketClient {


    public WebServerSocketClient(String url) throws URISyntaxException{

        super(new URI(url));
        System.out.println("已经成功连接服务器");
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        System.out.println("握手...文件存储服务器和服务器建立了连接");
    }

    @Override
    public void onMessage(String paramString) {
        System.out.println("接收到消息："+paramString);
        //解析消息
        if(paramString == null){
            return;
        }
        //转成MAP
        Map map = FastJSONUtils.stringToCollect(paramString);

        FileService fileService = SpringContextHolder.getBean(FileService.class);
        String type = (String) map.get("type");
        if("fileDown".equalsIgnoreCase(type)){
            String msg = (String) map.get("msg");
            fileService.starDowmFile(msg);
        }


    }

    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
        System.out.println("关闭...");
    }

    @Override
    public void onError(Exception e) {
        System.out.println("异常"+e);

    }

}
