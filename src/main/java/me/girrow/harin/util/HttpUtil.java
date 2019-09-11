package me.girrow.harin.util;

import java.util.HashMap;

public class HttpUtil {

	public static HashMap<String,Object> put(int status,String comment){
		HashMap<String,Object> resultMap= new HashMap<String,Object>();
		resultMap.put("status", status);
		resultMap.put("comment", comment);
		return resultMap;
	}
}
