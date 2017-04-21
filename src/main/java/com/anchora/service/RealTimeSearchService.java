package com.anchora.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.anchora.entity.SearchModel;

/*
 *作者:jchuo
 *日期:2017年4月19日
 *时间:下午4:16:13
**/
public interface RealTimeSearchService  {
	List<SearchModel> searchbykeyword( SearchModel model,String index ); 
	Map<Date, Integer> searchScoll(String index);
}
