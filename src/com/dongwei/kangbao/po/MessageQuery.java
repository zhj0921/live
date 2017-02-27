package com.dongwei.kangbao.po;

import java.io.Serializable;

public class MessageQuery implements Serializable{

	private static final long serialVersionUID = -9153502127065889227L;

	private Integer startRow;//起始行
	private Integer pageSize = 5;//每页显示条数
	private Integer pageNo = 1;//页码
	
	
	/**
	 * 附加字段
	 * @return
	 */
	private Integer id;
	
	private Integer timeStart;//开始时间
	
	private Integer timeEnd;//结束时间
	
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.startRow = (pageNo-1)*pageSize;
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.startRow = (pageNo-1)*pageSize;
		this.pageNo = pageNo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Integer timeStart) {
		this.timeStart = timeStart;
	}
	public Integer getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Integer timeEnd) {
		this.timeEnd = timeEnd;
	}
	@Override
	public String toString() {
		return "MessageQuery [startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + ", id=" + id
				+ ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + "]";
	}
	
}
