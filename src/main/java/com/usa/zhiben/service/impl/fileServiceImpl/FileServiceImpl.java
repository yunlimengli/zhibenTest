package com.usa.zhiben.service.impl.fileServiceImpl;

import com.usa.zhiben.bean.web.file.FileList;
import com.usa.zhiben.component.socketClient.SocketClientTask;
import com.usa.zhiben.config.httpClient.http.HttpAPIService;
import com.usa.zhiben.mapper.web.file.FileListMapper;
import com.usa.zhiben.service.fileService.FileService;
import com.usa.zhiben.util.diskUtils.SysConfigUtils;
import com.usa.zhiben.util.jsonUtils.FastJSONUtils;
import com.usa.zhiben.util.redisUtils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 胖花
 * @create 2019-03-26 11:01
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    HttpAPIService httpAPIService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    SocketClientTask socketClientTask;
    @Resource
    FileListMapper fileListMapper;

    //加密狗号
    @Value(value ="${socket.server.serverNo}")
    private String serverNo;

    //加密狗号
    @Value(value ="${socket.file.maxdown}")
    private int maxdown;


    @Override
    public void dowmStataionFile(String ip, FileList fileList,String token) {

        //1.拼接地址
        String url = "http://"+ip+"/server/dowmFile";
        //判断是否是下了一半的文件
        if(fileList==null){

            //通知主WEB 你出错了
            return;
        }
        //获取保存的盘符
        Double fileSize = fileList.getFileSize();

        String saveRoot = getSaveRoot(fileSize);
        if(saveRoot==null){
            System.out.println("没有获取到盘符");
            return;
        }
        String savePath = saveRoot + fileList.getFilePath() + fileList.getFileName();
        String dowmPath = fileList.getRoot() + fileList.getFilePath() + fileList.getFileName();

        int download = httpAPIService.download(url, savePath,dowmPath ,token,fileList.getFileNo());

        if(download==1){
            //上传成功
                //保存数据库
            fileListMapper.updateFileDownStatus(fileList.getFileNo(),serverNo,saveRoot,2);//下载完成
            System.out.println("文件上传成功");
        }else if(download==-2){
            //失败
              //操作数据库
            fileListMapper.updateFileDownStatus(fileList.getFileNo(),null,null,1);//下载l yiban
            System.out.println("文件一半或 失败");
        }else if(download == -1){
            fileListMapper.updateFileDownStatus(fileList.getFileNo(),null,null,-1);//文件不存在
            System.out.println("文件不存在");
        }
        //将此文件移除下载列表
        removeFileDown(fileList.getFileNo());
    }

    /**
     * 获取保存的盘符
     *
     * @return
     */
    @Override
    public String getSaveRoot(double fileSize) {

        //获取当前服务器保存的盘符
        String saveRoot = "D:\\";
        //当前盘符 需要计算
            //判断当前系统
            int systemType = SysConfigUtils.getSystemType();
            //获取磁盘剩余大小  MB
            String sizeStr = (String) redisUtil.get("server_disk_surplus_"+serverNo);


            if(systemType==1){
                //windos
                //获取磁盘空间
                if(StringUtils.isBlank(sizeStr)){
                    //获取当前磁盘大小

                    Map<String, Double> surplusDiskSize = SysConfigUtils.getSurplusDiskSize();

                    Double totalSize = surplusDiskSize.get("totalSize");
                    Double surplusSize = surplusDiskSize.get("surplusSize");
                    if(surplusSize/totalSize<0.2){
                        //总磁盘空间小于20%  需要通知

                    }
                    if(surplusSize/totalSize<0.1){
                        //总磁盘空间小于10%  需要通知

                    }


                    Double saveRoot1 = surplusDiskSize.get(StringUtils.split(saveRoot,"\\:")[0]);
                    if(saveRoot1>fileSize){
                        return  saveRoot;
                    }else{
                        // 当前保存的磁盘空间不足 需要通知

                        //获取新的盘符保存
                        Set<String> keySet = surplusDiskSize.keySet();
                        for(String key : keySet){

                            if(key.startsWith("surp")||key.startsWith("C")||key.startsWith(saveRoot)||key.startsWith("tota")){
                                continue;
                            }
                            if(surplusDiskSize.get(key)>fileSize){
                                return  key+":/";
                            }
                        }
                    }
                }
            }else{
                //获取当前磁盘大小
                Map<String, Double> surplusDiskSize = SysConfigUtils.getSurplusDiskSize();
                Double surplusSize = surplusDiskSize.get("surplusSize");
                if(surplusSize>fileSize){
                    //空间不足
                    return saveRoot;
                }
            }

        //计算大小
        //返回盘符
            //到这来了 说明没有磁盘空间了

        return null;
    }




    //-----------------------------发送socket命令请求下载------------------------------------------------------

    static Set<String> fileDownSet = new HashSet<>();

    /**
     * 判断是否有空余的资源请求WEB 获取下载地址下载  发消息给web服务端 让其返回一个文件给此服务器来下载
     */
    @Override
    public void getDownFilePathFromWeb() {
        //一次定时任务发一次请求 获取一个下载地址
        if(getFileDownSetSize()<maxdown){
            //发送命令soceket 请求下载地址
            socketClientTask.sendMsgToServer("fileDown","");
        }
    }

    /**
     * 处理socket 推送来的 需要下载的文件
     *
     * @param msg
     */
    @Override
    public void starDowmFile(String msg) {

            //处理数据
            if(StringUtils.isBlank(msg)){
                return;
            }
        try {
            //转换JSOn
            FileList fileList = FastJSONUtils.toBean(msg, FileList.class);
            String serverIp = fileList.getServerIp();
            //将此记录添加至fileDownSet  表示此记录正在下载
            setFileDownSet(fileList.getFileNo());
            //开始下载文件
            dowmStataionFile(serverIp,fileList,fileList.getStorageServerNo());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }






    Lock lock = new ReentrantLock();


    private int  getFileDownSetSize(){

        try {
            lock.lock();
            return  fileDownSet.size();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return  maxdown;
    }

    //新添一个fileList 至正在下载
    private  void setFileDownSet(String fileNo){

        try {
            lock.lock();
            if(fileDownSet.contains(fileNo)){
                return;
            }
            fileDownSet.add(fileNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    //移除正在下载记录
    private  void removeFileDown(String fileNo){
        try {
            lock.lock();
            if(!fileDownSet.contains(fileNo)){
                return;
            }
            fileDownSet.remove(fileNo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
