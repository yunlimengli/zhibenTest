package com.usa.zhiben.controller.file;

import com.usa.zhiben.config.httpClient.http.HttpAPIService;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 采集站文件传输
 *
 * @author 胖花
 * @create 2019-03-25 13:41
 */
@Controller
public class FileController {


    @Autowired
    HttpAPIService httpAPIService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return  "susccess";
    }

    /**
     * 获取该文件需要保存的路径  已经传输大小
     *
     * @param parm
     */
    @RequestMapping("server/file/file")
    public void getFileSize(@RequestParam("parm") String parm) {


    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @RequestMapping("server/file/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择一个文上传";
        }
        String filename = file.getOriginalFilename();
        long fileSize = file.getSize();
        System.out.println("文件名称" + filename + "-------文件大小" + fileSize);
        String path = "F:/test";
        File dest = new File(path + "/" + filename);
        if (!dest.getParentFile().exists()) {
            //父目录不存在就创建一个
            dest.getParentFile().mkdir();
        }
        //保存文件
        try {
            file.transferTo(dest);
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "文件上传失败";
        }
    }

    /**
     * 文件上传
     *
     * @param request
     * @param response
     * @param range
     */
    public void fileUpload(HttpServletRequest request, HttpServletResponse response, @RequestHeader(required = false) String range) {
        //文件目录
        File music = new File("E:\\CloudMusic\\林子祥 - 街头霸王榜.mp3");

        //开始下载位置
        long startByte = 0;
        //结束下载位置
        long endByte = music.length() - 1;


        //要下载的长度（为啥要加一问小学数学老师去）
        long contentLength = endByte - startByte + 1;
        //文件名
        String fileName = music.getName();
        //文件类型
        String contentType = request.getServletContext().getMimeType(fileName);


        //各种响应头设置
        //参考资料：https://www.ibm.com/developerworks/cn/java/joy-down/index.html
        //坑爹地方一：看代码
        response.setHeader("Accept-Ranges", "bytes");
        //坑爹地方二：http状态码要为206
        response.setStatus(response.SC_PARTIAL_CONTENT);
        response.setContentType(contentType);
        response.setHeader("Content-Type", contentType);
        //这里文件名换你想要的，inline表示浏览器直接实用（我方便测试用的）
        //参考资料：http://hw1287789687.iteye.com/blog/2188500
        response.setHeader("Content-Disposition", "inline;filename=test.mp3");
        response.setHeader("Content-Length", String.valueOf(contentLength));
        //坑爹地方三：Content-Range，格式为
        // [要下载的开始位置]-[结束位置]/[文件总大小]
        response.setHeader("Content-Range", "bytes " + startByte + "-" + endByte + "/" + music.length());


        BufferedOutputStream outputStream = null;
        RandomAccessFile randomAccessFile = null;
        //已传送数据大小
        long transmitted = 0;
        try {
            randomAccessFile = new RandomAccessFile(music, "r");
            outputStream = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[4096];
            int len = 0;
            randomAccessFile.seek(startByte);
            //坑爹地方四：判断是否到了最后不足4096（buff的length）个byte这个逻辑（(transmitted + len) <= contentLength）要放前面！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            //不然会会先读取randomAccessFile，造成后面读取位置出错，找了一天才发现问题所在
            while ((transmitted + len) <= contentLength && (len = randomAccessFile.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
                transmitted += len;
                //停一下，方便测试，用的时候删了就行了
                Thread.sleep(10);
            }
            //处理不足buff.length部分
            if (transmitted < contentLength) {
                len = randomAccessFile.read(buff, 0, (int) (contentLength - transmitted));
                outputStream.write(buff, 0, len);
                transmitted += len;
            }

            outputStream.flush();
            response.flushBuffer();
            randomAccessFile.close();
            System.out.println("下载完毕：" + startByte + "-" + endByte + "：" + transmitted);

        } catch (ClientAbortException e) {
            System.out.println("用户停止下载：" + startByte + "-" + endByte + "：" + transmitted);
            //捕获此异常表示拥护停止下载
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @RequestMapping("upload")
    @ResponseBody
    public String getfile(@RequestParam("myfile") MultipartFile file){
        System.out.println("file name = "+file.getOriginalFilename());

        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上产的路径
        String filePath = "d:/upload/";
        // fileName处理
        fileName = filePath+ UUID.randomUUID()+fileName;
        // 文件对象
        File dest = new File(fileName);
        // 创建路径
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";
    }

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws FileNotFoundException {
        File file =new File("C:\\Users\\ASUS\\Desktop\\spring-boot-reference.pdf");
        FileInputStream fileInputStream=new FileInputStream(file);
        // 设置被下载而不是被打开
        response.setContentType("application/gorce-download");
        // 设置被第三方工具打开,设置下载的文件名
        response.addHeader("Content-disposition","attachment;fileName=spring-boot-reference.pdf");
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("httpC")
    public void httpClientDowm(){

        String url = "http://192.168.3.41:8090/filedown";
        String savePath = "F:/test/aaa.avi";

//        httpAPIService.download(url,savePath);

    }

}
