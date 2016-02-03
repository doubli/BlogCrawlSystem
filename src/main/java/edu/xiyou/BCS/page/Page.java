package edu.xiyou.BCS.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Page<T> implements Serializable{
	
	private static final long serialVersionUID = -6206830784046697246L;

	/** 页面大小	 */
	private int pageSize = PageConstant.DEFAULT_PAGE_SIZE;
	/** 总页数	 */
	private int totalPage = 0;
	/** 当前页数 */
	private int currentPage =PageConstant.DEFAULT_CURRENT_PAGE;
	/** 总记录数 */
	private int totalRecords = 0;
	/** 是否有前一页 */
	private boolean hasPrePage;
	/** 是否有后一页 */
	private boolean hasNextPage;
	/** 开始的记录index */
	private int beginIndex;
	/** 结束的记录index */
	private int endIndex;
    /** 查询数据对象 */
    private T  object;
	/** 数据list */
	private List<T> pageList;

	public Page(int currentPage, int totalRecords, int pageSize){
		this.pageSize = pageSize;
		this.currentPage = currentPage;
        this.totalRecords = totalRecords;

        this.totalPage = getTotalPage(pageSize, totalRecords);
        this.beginIndex = getBeginIndex(pageSize, currentPage);
        this.endIndex = getEndIndex(currentPage, totalRecords, pageSize);
        this.hasNextPage = hasNextPage(currentPage, this.totalPage);
        this.hasPrePage = hasPrePage(currentPage);
        this.currentPage = getCurrentPage(currentPage);
	}

	public Page(){
	}

	private int getCurrentPage(int currentPage){
		return currentPage <= 0 ? 1 : currentPage;
	}

	private int getBeginIndex(int pageSize, int currentPage){
		return (currentPage - 1) * pageSize;// 数据库中查询是从0开始
	}

	private int getTotalPage(int pageSize, int totalRecords){
		int totalPage = totalRecords / pageSize;
		return totalRecords % pageSize == 0 ? totalPage : totalPage +1;
	}

	private boolean hasPrePage(int currentPage){
		return currentPage != 1;
	}

	private boolean hasNextPage(int currentPage, int totalPage){
		return totalPage != 0 && totalPage != currentPage;
	}

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
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

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

    public int getEndIndex(int currentPage, int totalRecords, int pageSize) {
        int end = currentPage * pageSize;
        return end > totalRecords ? totalRecords : end;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

    @Override
    public String toString() {
        return "Page{" +
                "beginIndex=" + beginIndex +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", totalRecords=" + totalRecords +
                ", hasPrePage=" + hasPrePage +
                ", hasNextPage=" + hasNextPage +
                ", pageList=" + pageList +
                '}';
    }

    public static void main(String[] args) {
        Page page = new Page();
        System.out.println(page);
        System.out.println("==============");
        System.out.println(new Page(4,10,3));
    }
}
