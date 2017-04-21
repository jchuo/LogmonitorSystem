package com.anchora.util;
/*
 *作者:jchuo
 *日期:2017年4月21日
 *时间:下午2:41:40
**/

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	public static JSONObject StringtoJson(String str) {
		JSONObject json = (JSONObject) JSONObject.parse(str);
		return json;
	}

}
