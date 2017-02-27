package com.dongwei.kangbao.po;

import java.io.Serializable;

public class AdminQuery implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//分页查询的条件
	private Integer startRow;//起始行
	private Integer pageSize = 3;//每页显示条数
	private Integer pageNo = 1;//页码
	
	private Integer id;
	private String username;
	private String password;//密码
	private String telphone;//手机号
	private Integer states;//是否启用
	private Integer last_login_time;//最后登录时间
	private Integer role_id;//角色
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public Integer getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Integer last_login_time) {
		this.last_login_time = last_login_time;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
	
	
}
