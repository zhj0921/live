package com.dongwei.kangbao.po;

import java.io.Serializable;

public class AndroidversionQuery implements Serializable{

	private static final long serialVersionUID = -4687127753609289622L;
	
	private Integer id;		//id
	private String path;	//安装包上传的路径
	private String version;	//版本号
	private String describe;//版本描述
	
	private Integer startRow;//起始行
	private Integer pageSize = 3;//每页显示条数
	private Integer pageNo = 1;//页码
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
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
	
	
	@Override
	public String toString() {
		return "AndroidversionQuery [id=" + id + ", path=" + path + ", version=" + version + ", describe=" + describe
				+ ", startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + "]";
	}
	
	
}
