package com.dongwei.kangbao.po;

import java.io.Serializable;

/**
 * 站点--站点配置
 * @author 作者: Administrator
 * @version 创建时间：2017年2月24日 下午3:47:54
 */
public class SiteConfiguration implements Serializable{

	private static final long serialVersionUID = -7241750593492424283L;

	private Integer id;
	private Integer s_id;
	private String title;
	private String key_word;
	private String describe;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKey_word() {
		return key_word;
	}
	public void setKey_word(String key_word) {
		this.key_word = key_word;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SiteConfiguration [id=" + id + ", s_id=" + s_id + ", title=" + title + ", key_word=" + key_word
				+ ", describe=" + describe + ", status=" + status + "]";
	}
	
}
