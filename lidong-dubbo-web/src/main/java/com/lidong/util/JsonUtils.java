package com.lidong.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lidong.websocket.WebSocketSessionHandshakeInterceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * 项目名称：library
 * 类描述： JsonUtils工具类
 * 创建人：lidong
 * 创建时间：2016/9/22 10:21
 * 邮箱 ：lidong@chni.com.cn
 * 修改备注：
 * 版本：1.0.0
 *
 */
public class JsonUtils {
	static Logger logger = LoggerFactory
			.getLogger(JsonUtils.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	private JsonUtils() {

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
	 * @param obj
	 *            需要转化的对象
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
