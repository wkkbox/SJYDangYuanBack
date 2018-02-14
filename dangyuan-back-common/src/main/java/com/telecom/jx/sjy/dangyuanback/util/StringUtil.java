package com.telecom.jx.sjy.dangyuanback.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public final class StringUtil {
	
	private StringUtil(){}
	
	public static String trim(Object obj){
		
		if (null == obj || obj.toString().trim().equals("")) {
			return "";
		}
		return obj.toString();
	}
	
	//isEmpty(Object parameter)
	public static boolean isEmpty(String str) {
        return null == str || "".equals(str.trim());
    }
	
	public static boolean isEmpty(Object... obj) {
        return null == obj || 0 == obj.length;
    }
	
	public static boolean isEmpty(List<?> list) {
        return null == list || list.size() == 0;
    }
	    
	public static boolean isEmpty(Map<?,?> map) {
        return null == map || map.size() == 0;
    }
	
	//getSize(Object parameter)
	public static int getSize(String str) {
		return isEmpty(str) ? 0 : str.length();
	}
	
	public static int getSize(Object... obj) {
		return isEmpty(obj) ? 0 : obj.length;
	}
	
	public static int getSize(List<?> list) {
		return isEmpty(list) ? 0 : list.size();
	}
	
	public static int getSize(Map<?,?> map) {
		return isEmpty(map) ? 0 : map.size();
	}
	
	//计算采用utf-8编码方式时字符串所占字节数
	public static int getStringByteSize(String str) throws UnsupportedEncodingException{
		return null == str ? 0 : str.getBytes(StandardCharsets.UTF_8.name()).length;
	}
	
}
