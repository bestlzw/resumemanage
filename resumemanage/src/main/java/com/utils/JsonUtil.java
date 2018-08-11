package com.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class JsonUtil {
	public static final String TEXT_CONTENT_TYPE = "text/plain;charset=UTF-8";
	public static final String JSON_CONTENT_TYPE = "application/json;charset=UTF-8";

	/** Jackson包中JSON */
	protected static ObjectMapper mapper = new ObjectMapper();
	// 定义静态GSON对象
	public static Gson gson = null;

	// 将对象转换成JSON字符串
	public static String objectToJson(Object ts) {
		String jsonStr = null;
		if (gson == null) {
			gson = new Gson();
		}
		if (gson != null) {
			jsonStr = gson.toJson(ts);
		}
		return jsonStr;
	}

	// 输出JSON字符串
	public static void printJson(HttpServletResponse response, String json) {
		try {
			response.setHeader("Cache-Control", "no-cache");
			// response.setContentType("text;charset=gb2312");
			response.setContentType("text/plain;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}
	
	public static <T> T toObject(String json, Class<?> cls) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return (T) mapper.readValue(json, cls);
	}
}
