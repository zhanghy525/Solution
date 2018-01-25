package com.etoak.book.common.page;

import java.util.List;

//该类封装所有与分页有关的方法和属性
public class Page<T> {
	private int pageNumber;//当前页
	private int pageCount;//总页数
	private int total;//总记录数
	private int pageSize=3;//每页显示多少条
	
	private int pre;//上一页
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageCount() {
		return (total+pageSize-1)/pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPre() {
		if(pageNumber>1){
			return pageNumber-1;
		}
		return 1;
	}
	public int getNext() {
		if(pageNumber<getPageCount()){
			return pageNumber+1;
		}
		return getPageCount();
	}
	//limit start,max
	public int getStart() {
		return (pageNumber-1)*pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	private int next;//下一页
	
	private int start;//每页的起始位置
	
	private List<T> rows;//本页的数据
	
}
