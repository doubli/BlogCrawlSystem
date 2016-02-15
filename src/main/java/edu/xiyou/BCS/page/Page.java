package edu.xiyou.BCS.page;

import java.io.Serializable;
import java.util.List;


public class Page<T> implements Serializable{
	
	private static final long serialVersionUID = -6206830784046697246L;

	/** 页面大小*/
	private int pageSize = PageConstant.DEFAULT_PAGE_SIZE;
	
	/** 当前页数 */
	private int currentPage = PageConstant.DEFAULT_PAGE_NUM;
	
	/** 总页数 */
	private int maxPage;
	
	/** 总记录数 *//*
	private int totalRecords;*/
	
	/** 数据List<T> */
	private List<T> dataList;

	public Page() {
		
	}
	
	
	
	/*public Pager(int pageNum,int pageSize,List<T> sourceList){
		if(sourceList == null){
			return;
		}
		//总记录数
		this.totalRecords = sourceList.size();
		
		//每页显示多少条记录
		this.pageSize = pageSize;
		
		//获取总页数
		int temp = this.totalRecords / this.pageSize;
		this.totalPage = (this.totalRecords % this.pageSize)==0 ? temp : temp + 1;
		
		//当前第几页
		if(this.totalPage < pageNum){
			this.currentPage = this.totalPage;
		}else{
			this.currentPage = pageNum;
		}
		
		//		起始索引
		int fromIndex = this.pageSize *  (this.currentPage - 1);
		
		//结束索引
		int toIndex = this.pageSize * this.currentPage > this.totalRecords ? this.totalRecords : this.pageSize * this.currentPage;
		
		//获取dataList   
		this.dataList = sourceList.subList(fromIndex, toIndex);
	}*/

	
}
