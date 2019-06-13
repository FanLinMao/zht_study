package cn.edu.cuit.study.utils;

import java.util.List;

/**
 * 分页对象
 * @author Flemming
 */
public class PageBean<T> {

	private List<T> list;    //数据
	private int pageSize;    //每页显示多少
	private int pageNo;   //当前页
	private int totalRecords;    //总页数



	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPages() {
		if (totalRecords%pageSize==0) {
			return totalRecords/pageSize;
		} else {
			return totalRecords/pageSize+1;
		}
	}

	/**
	 * 首页
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 上一页
	 * @return
	 */
	public int getPreviousPageNo() {
		if (pageNo<=1) 
			return 1;
		return pageNo-1;
	}

	/**
	 * 尾页
	 * @return
	 */
	public int getBottomPageNo() {
		return getTotalPages();
	}

	/**
	 * 下一页
	 * @return
	 */
	public int getNextPageNo(){
		if(pageNo>=getBottomPageNo())
			return getBottomPageNo();
			return pageNo+1;
		}


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
