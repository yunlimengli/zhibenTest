package com.usa.zhiben.util.jsonUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;
import java.util.Map;

/**
 * 阿里的json 工具类
 *
 * @author PC
 * <dependency>
 * <groupId>com.alibaba</groupId>
 * <artifactId>fastjson</artifactId>
 * <version>1.1.23</version>
 * </dependency>
 */
public class FastJSONUtils {

    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式  
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式  
    }

    private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue, // 输出空置字段  
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null  
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null  
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null  
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null  
    };

    /**
     * 将 任意的对象转换为json 字符串
     * 带格式的   时间会被格式化
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    /**
     * 将 任意的对象转换为json 字符串
     * 建议用这个
     *
     * @param object
     * @return
     */
    public static String toJSONS(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将 任意的对象转换为json 字符串
     * 不带格式
     *
     * @param object
     * @return
     */
    public static String toJSONNoFeatures(Object object) {
        return JSON.toJSONString(object, config, SerializerFeature.DisableCircularReferenceDetect);
    }


    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    /**
     * json字符串转 java对象
     *
     * @param text
     * @param clazz
     * @return
     */
    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    // 转换为数组  
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    /**
     * json字符串转  数组
     *
     * @param text
     * @param clazz
     * @return
     */
    // 转换为数组  
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * json字符串转  list
     *
     * @param text
     * @param clazz
     * @return
     */
    // 转换为List  
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * 将javabean转化为序列化的json字符串
     *
     * @param keyvalue
     * @return
     */
    public static Object beanToJson(KeyValue keyvalue) {
        String textJson = JSON.toJSONString(keyvalue);
        Object objectJson = JSON.parse(textJson);
        return objectJson;
    }

    /**
     * 将string转化为序列化的json字符串
     *
     * @param
     * @return
     */
    public static Object textToJson(String text) {
        Object objectJson = JSON.parse(text);
        return objectJson;
    }

    /**
     * json字符串转化为map
     *
     * @param s
     * @return
     */
    public static Map stringToCollect(String s) {
        Map m = JSONObject.parseObject(s);
        return m;
    }

    /**
     * 将map转化为string
     *
     * @param m
     * @return
     */
    public static String collectToString(Map m) {
        String s = JSONObject.toJSONString(m);
        return s;
    }


    /**
     * 把对象转换为指定对象
     */
    public static <T> T toObjectFromSource(Object source, Class<T> target) {
        return toBean(toJSONString(source), target);
    }


}
