package com.dongwei.kangbao.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限实体
 * 
 *
 */
public class Privilege implements Serializable{
	
	private static final long serialVersionUID = -7521184711690794980L;
	
	private Integer id;
	private String title;//权限名称
	private String url;//权限对应的url访问路径
	private Integer pid;//当前权限的上级权限
	private Set<Privilege> children = new HashSet<Privilege>();//当前权限的下级权限集合
	private Set<Role> roles = new HashSet<Role>();//当前权限对应的角色集合
	private Integer states;//权限状态
	private String code;//权限关键字
	
	
	
	
	private Integer roleId;//管理组Id
	private String roleName;//管理组名称
	private String qxzId;//权限id标识
	private Integer status;//管理组状态
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getQxzId() {
		return qxzId;
	}
	public void setQxzId(String qxzId) {
		this.qxzId = qxzId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Privilege [id=" + id + ", title=" + title + ", url=" + url + ", pid=" + pid + ", children=" + children
				+ ", roles=" + roles + ", states=" + states + ", code=" + code + ", roleId=" + roleId + ", roleName="
				+ roleName + ", qxzId=" + qxzId + ", status=" + status + "]";
	}
}
