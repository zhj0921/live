package com.dongwei.kangbao.po;

import java.io.Serializable;

public class PrivilegeQuery implements Serializable{

	private static final long serialVersionUID = 1647641144657184988L;
	//分页查询的条件
	private Integer startRow;//起始行
	private Integer pageSize = 3;//每页显示条数
	private Integer pageNo = 1;//页码
	
	private String name;
	private Integer classify;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getClassify() {
		return classify;
	}
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	@Override
	public String toString() {
		return "PrivilegeQuery [startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + ", name="
				+ name + ", classify=" + classify + "]";
	}
	
}
