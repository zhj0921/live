package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 消息表
 * @author 作者: Administrator
 * @version 创建时间：2017年1月18日 上午10:06:48
 */
public class Message implements Serializable{

	private static final long serialVersionUID = 4153937168853704059L;

	private Integer id;
	private Integer uid;
	private Integer utype;
	private String title;
	private String content;
	private Integer addtime;
	
	private String userName;

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

	public Integer getUtype() {
		return utype;
	}

	public void setUtype(Integer utype) {
		this.utype = utype;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddtime() {
		if (addtime==null) {
			return "未知";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(addtime, null);
			return timeStamp2Date;
		}
	}

	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
