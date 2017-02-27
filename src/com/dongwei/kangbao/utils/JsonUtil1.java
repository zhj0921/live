package com.dongwei.kangbao.utils;

import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JsonUtil1 {

	public static <T> T parseJsonToObj(String jsonStr, Class<T> clazz) {
		return JSON.parseObject(jsonStr, clazz);
	}

	public static <T> List<T> parseJsonToArray(String jsonStr, Class<T> clazz) {
		return JSON.parseArray(jsonStr, clazz);
	}

	public static String objToJsonStr(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static String writeList2Json(List<?> list, String[] excludes) throws IOException {
		// 将pageBean转换成json数据
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(excludes);
		JSONArray jsonObj = JSONArray.fromObject(list, jc);
		String json = jsonObj.toString();
		/*
		 * response.setContentType("text/json;charset=utf-8");
		 * response.getWriter().print(json);
		 */
		return json;
	}

	/**
	 * 冒泡排序法
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23
				, 34, 15, 35, 25, 53, 51 };
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void test() {
		
		
		
		
		
	}

}
