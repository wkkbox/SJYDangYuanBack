
package com.telecom.jx.sjy.dangyuanback.util.dto;

import java.util.List;

public class PageBean<T> {

	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private List<T> pList;

	public int getCurrentPage() {

		return currentPage;
	}

	public void setCurrentPage(int currentPage) {

		this.currentPage = currentPage;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public int getTotalCount() {

		return totalCount;
	}

	public void setTotalCount(int totalCount) {

		this.totalCount = totalCount;
	}

	public int getTotalPage() {

		return totalPage;
	}

	public void setTotalPage(int totalPage) {

		this.totalPage = totalPage;
	}

	public List<T> getpList() {

		return pList;
	}

	public void setpList(List<T> pList) {

		this.pList = pList;
	}

}
