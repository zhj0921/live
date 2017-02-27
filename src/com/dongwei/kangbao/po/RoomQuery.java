package com.dongwei.kangbao.po;

import java.io.Serializable;

public class RoomQuery implements Serializable{
	
	private static final long serialVersionUID = -8805011494144846730L;
	
	private Integer startRow;//起始行
	private Integer pageSize = 5;//每页显示条数
	private Integer pageNo = 1;//页码
	
	
	/**
	 * 附加字段
	 * @return
	 */
	private Integer id;
	
	private Integer playbackstatus;//0：启用回放  1：禁止回放
	
	private String userName;//用户名称
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Integer getPlaybackstatus() {
		return playbackstatus;
	}
	public void setPlaybackstatus(Integer playbackstatus) {
		this.playbackstatus = playbackstatus;
	}
	@Override
	public String toString() {
		return "RoomQuery [startRow=" + startRow + ", pageSize=" + pageSize + ", pageNo=" + pageNo + ", id=" + id
				+ ", playbackstatus=" + playbackstatus + ", userName=" + userName + ", timeStart=" + timeStart
				+ ", timeEnd=" + timeEnd + "]";
	}
	
}
