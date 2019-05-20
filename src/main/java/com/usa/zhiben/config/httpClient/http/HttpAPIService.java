package com.usa.zhiben.config.httpClient.http;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Component
public class HttpAPIService {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;


    /**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url) throws Exception {
        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(url);

        // 装载配置信息
        httpGet.setConfig(config);

        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpGet);

        // 判断状态码是否为200
        if (response.getStatusLine().getStatusCode() == 200) {
            // 返回响应体的内容
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }
        return null;
    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回null
     *
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        URIBuilder uriBuilder = new URIBuilder(url);

        if (map != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        // 调用不带参数的get请求
        return this.doGet(uriBuilder.build().toString());

    }

    /**
     * 带参数的post请求
     *
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, Map<String, Object> map) throws Exception {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(config);

        // 判断map是否为空，不为空则进行遍历，封装from表单对象
        if (map != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            // 构造from表单对象
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

            // 把表单放到post里
            httpPost.setEntity(urlEncodedFormEntity);
        }

        // 发起请求
        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), "UTF-8"));
    }

    /**
     * 不带参数post请求
     *
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url) throws Exception {
        return this.doPost(url, null);
    }


    public String uploadFile(String url, String localFile, Map<String, Object> map) {
        // 声明httpPost请求
        HttpPost httpPost = new HttpPost(url);
        // 加入配置信息
        httpPost.setConfig(config);
        CloseableHttpResponse response = null;
        try {
            // 把一个普通参数和文件上传给下面这个地址 是一个servlet

            // 把文件转换成流对象FileBody
            FileBody bin = new FileBody(new File(localFile));
/*

            StringBody userName = new StringBody("Scott", ContentType.create(
                    "text/plain", Consts.UTF_8));
            StringBody password = new StringBody("123456", ContentType.create(
                    "text/plain", Consts.UTF_8));
*/

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            // 相当于<input type="file" name="file"/>
            multipartEntityBuilder.addPart("file", bin);

            // 相当于<input type="text" name="userName" value=userName>
            if (map != null && map.size() > 0) {
                Set<String> keySet = map.keySet();
                for (String key : keySet) {
                    multipartEntityBuilder.addPart(key, new StringBody(String.valueOf(map.get(keySet)), ContentType.create(
                            "text/plain", Consts.UTF_8)));
                }
            }
            org.apache.http.HttpEntity reqEntity = multipartEntityBuilder.build();

            httpPost.setEntity(reqEntity);

            // 发起请求 并返回请求的响应
            response = this.httpClient.execute(httpPost);

            System.out.println("The response value of token:" + response.getFirstHeader("token"));

            // 获取响应对象
            final org.apache.http.HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 打印响应长度
                System.out.println("Response content length: " + resEntity.getContentLength());
                // 打印响应内容
                System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
            }

            // 销毁
            EntityUtils.consume(resEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "1";
    }


    /**
     * 远程下载采集站上的文件
     * @param url
     * @param filepath
     * @param token
     * @return
     */
    public  int download(String url, String filepath ,String downPath , String token,String fileNo) {
             try {
                 HttpClient client = this.httpClient;

                 HttpPost httpPost = new HttpPost(url);
                 // 加入配置信息
                 httpPost.setConfig(config);
                 File file = new File(filepath);
                 List<NameValuePair> list = new ArrayList<NameValuePair>();
                 list.add(new BasicNameValuePair("startByte",String.valueOf(file.length())));
                 list.add(new BasicNameValuePair("token",token));
                 list.add(new BasicNameValuePair("fileNo",fileNo));
                 list.add(new BasicNameValuePair("filePath",downPath));
                 // 构造from表单对象
                 UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

                 // 把表单放到post里
                 httpPost.setEntity(urlEncodedFormEntity);


                 HttpResponse response = client.execute(httpPost);

                 HttpEntity entity = response.getEntity();
                 InputStream is = entity.getContent();


                 file.getParentFile().mkdirs();

                 /**
                  * 根据实际运行效果 设置缓冲区大小
                 */
                 RandomAccessFile  randomAccessFile = null;
                 //已传送数据大小
                 long transmitted = 0;

                 randomAccessFile = new RandomAccessFile(file, "rw");
                 System.out.println("已经下载了："+file.length());
                 randomAccessFile.seek(file.length());

                 byte[] buffer=new byte[1048];
                 int ch = 0;
                 int temp = 0;
                 while ((ch = is.read(buffer)) != -1) {
                     System.out.println("ch长度："+ch);
                     temp = 1;
                     randomAccessFile.write(buffer,0,ch);
                 }
                 is.close();
                 randomAccessFile.close();
                 System.out.println("文件下载成功:__"+filepath);
                 System.out.println("ch：——————"+ch);
                 if(temp==0){
                     //说明没有东西
                        //删除文件
                         file.delete();
                     return  -1;
                 }
                 return  1;

          } catch (Exception e) {
              e.printStackTrace();
             return  -2;
          }
     }


}