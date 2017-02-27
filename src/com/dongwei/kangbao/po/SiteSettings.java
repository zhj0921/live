package com.dongwei.kangbao.po;

import java.io.Serializable;

/**
 * 站点基本配置
 * @author 作者: Administrator
 * @version 创建时间：2017年2月24日 上午10:58:22
 */
public class SiteSettings implements Serializable{

	private static final long serialVersionUID = -3713914004115823826L;

	private Integer id;
	private String name;
	private String domain_name;
	private String enterprise;
	private Integer status;
	
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
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SiteSettings [id=" + id + ", name=" + name + ", domain_name=" + domain_name + ", enterprise="
				+ enterprise + ", status=" + status + "]";
	}
	
}
