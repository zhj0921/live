package com.dongwei.kangbao.utils;

import java.util.List;
/**
 * 
 * @ClassName: Page
 * @Company: http://www.itcast.cn/
 * @Description: 分页对象
 * @author JD 
 * @date 2016�?2�?25�? 下午4:06:36 
 * @param <T>
 */
public class Page<T> {
    
	private int total;    // 总条�?
	private int page;     // 当前�?
	private int size;     // 每页显示的条�?
    private List<T> rows; // 查询的结果集
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
