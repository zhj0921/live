package com.dongwei.kangbao.utils;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;

public class JsonUtil {

	 public static <T> T parseJsonToObj(String jsonStr, Class<T> clazz) {
	        return JSON.parseObject(jsonStr, clazz);
	    }
	    public static <T> List<T> parseJsonToArray(String jsonStr, Class<T> clazz) {
	        return JSON.parseArray(jsonStr, clazz);
	    }

	    public static String objToJsonStr(Object obj) {
	        return  JSON.toJSONString(obj);
	    }
	    
	    //xml赚json
	    public static String xml2jsonString(String xml)throws JSONException{
	    	JSONObject xmlJSONObj = XML.toJSONObject(xml);
	    	return xmlJSONObj.toString();
	    	}
	    
	    
	    public static <T> T getSingleBean(String jsonData, Class<T> clazz) throws Exception {
	        return JSON.parseObject(jsonData, clazz);
	    }
	    
	    public static JSONArray writeList2Json(List<Object> qxList){
			//将pageBean转换成json数据
			//JsonConfig jc = new JsonConfig();
			JSONArray jsonObj = JSONArray.fromObject(qxList);
		

			//String json = jsonObj.toString();
			return jsonObj;
		}
	        

	    
}
