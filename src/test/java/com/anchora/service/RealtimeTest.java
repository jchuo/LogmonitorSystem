package com.anchora.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.anchora.entity.SearchModel;
import com.anchora.service.impl.RealTimeSearchServiceImpl;

/*
 *作者:jchuo
 *日期:2017年4月21日
 *时间:下午3:38:06
**/
public class RealtimeTest {

	@Test
	public void test() {
		SearchModel model = new SearchModel();
		String index = "logstash-b0a42329";
		model.setKeyword("main");
		model.setPage(0);
		RealTimeSearchServiceImpl real = new RealTimeSearchServiceImpl();
		List<SearchModel> list = real.searchbykeyword(model, index);
		for(SearchModel m :list){
			System.out.println(m);
		}
		
	}

}
