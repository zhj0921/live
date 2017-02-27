package com.dongwei.kangbao.po;

import java.io.Serializable;

public class FeedBackQuery implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//分页查询的条件
	private Integer startRow;//起始行
	private Integer pageSize = 3;//每页显示条数
	private Integer pageNo = 1;//页码
	
	private Integer timeEnd; //结束时间
	private Integer timeStart; //开始时间
	
	private Integer id;
	private Integer uid;		//用户id
	private Integer type_id;		//反馈类型id
	private String content;			//反馈内容
	private Integer addtime;		//提交时间
	private Integer status;		    //状态
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAddtime() {
		return addtime;
	}
	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	
	public Integer getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Integer timeEnd) {
		this.timeEnd = timeEnd;
	}
	public Integer getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Integer timeStart) {
		this.timeStart = timeStart;
	}
	@Override
	public String toString() {
		return "FeedBackQuery [startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + ", timeEnd="
				+ timeEnd + ", timeStart=" + timeStart + ", id=" + id + ", uid=" + uid + ", type_id=" + type_id
				+ ", content=" + content + ", addtime=" + addtime + ", status=" + status + "]";
	}
	
	
}
