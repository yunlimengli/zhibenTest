package com.usa.zhiben.service.fileService;

import com.usa.zhiben.bean.web.file.FileList;

/**
 * @author 胖花
 * @create 2019-03-26 10:31
 */

public interface FileService {

    /**
     * 从采集站下载文件
     * @param ip
     * @param fileList
     * @param token
     */
    public void  dowmStataionFile(String ip,FileList fileList,String token);


    /**
     * 获取保存的盘符
     * @return
     */
    public String getSaveRoot(double fileSize);

    /**
     * 判断是否有空余的资源请求WEB 获取下载地址下载
     */
    void getDownFilePathFromWeb();

    /**
     * 处理socket 推送来的 需要下载的文件
     * @param msg
     */
    void starDowmFile(String msg);
}
