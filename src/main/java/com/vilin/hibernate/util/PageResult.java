package com.vilin.hibernate.util;

import java.util.List;

public class PageResult<T> {

	private Integer pageSize = 5;
	
	private Integer pageNo = 1;
	
	private Integer totalPage;
	
	private List<T> list;

	public PageResult() {
		super();
	}

	/**
	 * 带参构造函数
	 * @param pageSize：每页记录数
	 * @param pageNo：当前页数
	 * @param totalSize：总页数
	 */
	public PageResult(Integer pageSize, Integer pageNo, Integer totalSize) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
	}
	
	//返回上一页
	public Integer getPrePage() {
		return pageNo - 1 >= 1 ? pageNo - 1 : 1;
	}
	
	//返回下一页
	public Integer getNextPage() {
		return pageNo + 1 <= totalPage ? pageNo + 1 : totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
