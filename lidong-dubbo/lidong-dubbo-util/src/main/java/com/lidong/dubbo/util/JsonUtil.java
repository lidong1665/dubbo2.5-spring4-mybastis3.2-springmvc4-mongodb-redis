package com.lidong.dubbo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @className :JsonUtil
 * @desc      :
 * @author    :lidong
 * @createTime:2017/1/8 下午8:38
 * @company   :chni
 * @QQ        :1561281670
 * @email     :lidong1665@163.com
 */
public class JsonUtil {
    static Logger logger = LoggerFactory
            .getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {

    }

    /**
     * @param json
     *            字符串
     * @param cls
     *            需要转成的bean类
     * @return 转成的对象
     */
    @SuppressWarnings("hiding")
    public static <T> T json2bean(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (Exception e) {
            logger.info("json", e.toString());
            return null;
        }
    }

    /**
     * json 字符串转换为List
     * @param json
     * @param cls
     * @return
     */
    public static ArrayList<?> json2List(String json, Class<?> cls) {
        try {
            @SuppressWarnings("deprecation")
            JavaType valueType = mapper.getTypeFactory().constructParametricType(ArrayList.class, cls);
            return (ArrayList<?>) mapper.readValue(json, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 对象转化json字符串
     * @param obj 需要转化的对象
     * @return json字符串
     */
    public static String bean2json(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String map2json(Map<String,Object> map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> f = new HashMap<String, Object>();
        f.put("dd", "ddddddddddddd");
        f.put("dd1", "ddddddddddddd");
        String map2json = map2json(f );
        System.out.println(map2json);
    }

}

