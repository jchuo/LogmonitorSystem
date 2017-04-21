package com.anchora.entity;

import java.util.Date;

/*
 *作者:jchuo
 *日期:2017年4月21日
 *时间:下午2:31:09
**/
public class SearchModel {
	private int page = 1;
	private String message;
	private Date time;
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public String toString(){
		return this.getMessage() + this.getPage() +this.getKeyword()+this.getTime();
		
	}

}
