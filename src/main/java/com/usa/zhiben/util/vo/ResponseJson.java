package com.usa.zhiben.util.vo;

import com.usa.zhiben.util.jsonUtils.FastJSONUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 胖花
 * @create 2019-03-21 15:28
 */

public class ResponseJson {


    public static void responseJsonInfo(HttpServletResponse response, String key, Object msg) {
        response.reset();

        Map<String, Object> map = new HashMap<>();
        key = StringUtils.isBlank(key) ? "status" : key;
        map.put(key, msg);
        String jsonMap = FastJSONUtils.toJSONS(map);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(jsonMap.getBytes("UTF-8"));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
