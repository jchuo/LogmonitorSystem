package com.anchora.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.anchora.entity.SearchModel;
import com.anchora.util.ElasticsearchClient;
import com.anchora.util.JsonUtil;
import com.anchora.util.TimeUtil;

/*
 *作者:jchuo
 *日期:2017年4月19日
 *时间:下午4:23:50
**/
@Service("realTimeSearchServiceImpl")
public class RealTimeSearchServiceImpl {
	
	
	public List<SearchModel> searchbykeyword(SearchModel model, String index) {

		List<SearchModel> list = new ArrayList<SearchModel>();
//		HighlightBuilder highlightBuilder = new HighlightBuilder().field("*").requireFieldMatch(true);
//		highlightBuilder.preTags("<font size=\"3\" color=\"red\">");
//		highlightBuilder.postTags("</font>");
		String key;
		if (model.getKeyword() == null) {
			key = "";
		} else {
			key = QueryParser.escape(model.getKeyword());
		}
		QueryBuilder qb = QueryBuilders.wildcardQuery("message", "*" + key + "*");

		SearchRequestBuilder srb = ElasticsearchClient.getClient().prepareSearch(index);
		srb.setQuery(qb);
		srb.setExplain(true);
		srb.addSort("@timestamp", SortOrder.DESC);
//		srb.highlighter(highlightBuilder);
		srb.setFrom(model.getPage() - 1);
		srb.setSize(20);

		SearchResponse respone = srb.execute().actionGet();
		SearchHits hits = respone.getHits();
		SearchHit[] hit = hits.getHits();
		if (hit.length == 0)
			return list;
		else {
			JSONObject json;
			SearchModel modelnew = new SearchModel();
			for (SearchHit hitstring : hit) {
				json = JsonUtil.StringtoJson(hitstring.getSourceAsString());
				modelnew.setMessage(json.getString("message"));
				modelnew.setTime(TimeUtil.timeUtil(json.getString("@timestamp")));
				modelnew.setPage(model.getPage() + 1);
				list.add(modelnew);
			}
			return list;
		}
	}

	public Map<Date, Integer> searchall(String index) {
		// TODO Auto-generated method stub
		
		
		
		
		SearchRequestBuilder srb = ElasticsearchClient.getClient().prepareSearch(index)
		// .setQuery()
		;

		
		
		SearchResponse respone = srb.execute().actionGet();

		SearchHits hits = respone.getHits();
		SearchHit[] hit = hits.getHits();

		// srb.setQuery()
		return null;
	}

}
