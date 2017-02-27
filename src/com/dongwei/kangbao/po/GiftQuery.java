package com.dongwei.kangbao.po;

public class GiftQuery {

	//分页查询的条件
	private Integer startRow;//起始行
	private Integer pageSize = 3;//每页显示条数
	private Integer pageNo = 1;//页码
	
	private Integer id;
	private Integer specialeffects;
	private Integer status;
	
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
	public Integer getSpecialeffects() {
		return specialeffects;
	}
	public void setSpecialeffects(Integer specialeffects) {
		this.specialeffects = specialeffects;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "GiftQuery [startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + ", id=" + id
				+ ", specialeffects=" + specialeffects + ", status=" + status + "]";
	}
	
}
