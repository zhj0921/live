package com.dongwei.kangbao.po;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Role implements Serializable{

	private static final long serialVersionUID = 2205442908846335127L;
	
	private Integer id;
	private String name;//角色名称
	private Integer status = 1;//是否启用
	private Set<HealthScreening> admins = new HashSet<HealthScreening>();
	private Set<Privilege> privileges = new HashSet<Privilege>();//当前角色对应的权限集合
	private String qxid;//权限id标识
	
	private String[] qxList;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Set<HealthScreening> getAdmins() {
		return admins;
	}
	public void setAdmins(Set<HealthScreening> admins) {
		this.admins = admins;
	}
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	public String getQxid() {
		return qxid;
	}
	public void setQxid(String qxid) {
		this.qxid = qxid;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", status=" + status + ", admins=" + admins + ", privileges="
				+ privileges + ", qxid=" + qxid + ", qxList=" + Arrays.toString(qxList) + "]";
	}
	public String[] getQxList() {
		return qxList;
	}
	public void setQxList(String[] qxList) {
		this.qxList = qxList;
	}
	
}
