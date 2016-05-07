package com.moma.dawnlove.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pagination implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1768306776032845344L;
	private List<?> list = new ArrayList();
	private int pageSize;
	private int currPage;
	private long total;
	private Map<String, Object> params = new HashMap<String, Object>();
	private long totalPage;

	public Pagination() {
		this.pageSize = 15;
		currPage = 1;
		total = 0;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		
		if(pageSize <= 0 || pageSize > 1000)
			pageSize = 15;
		
		this.pageSize = pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		if(currPage == null || currPage <= 0)
			this.currPage = 1;
		else
			this.currPage = currPage;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
		
		totalPage = (total / pageSize) + (total % pageSize == 0 ? 0 : 1);
	}
	
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, Object> map(){
		
		Map<String, Object> p = new HashMap<String, Object>();
		p.putAll(params);
		p.put("pageSize", this.pageSize);
		p.put("currPage", this.currPage);
		
		int from = 0;
		if(this.currPage > 1)
			from = this.pageSize * (this.currPage -1);
		int to = from + (this.pageSize);
		
		p.put("from", from);
		p.put("to", to);
		
		return p;
	}

	public void put(String key, Object object) {
		params.put(key, object);
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
}
