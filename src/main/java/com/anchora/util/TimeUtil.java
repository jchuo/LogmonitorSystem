package com.anchora.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *作者:jchuo
 *日期:2017年4月21日
 *时间:下午2:39:56
**/
public class TimeUtil {
	public static Date timeUtil(String date) {
		date = date.replace("Z", " UTC");// 注意是空格+UTC
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");// 注意格式化的表达式
		Date d = null;
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

}
