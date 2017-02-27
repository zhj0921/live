package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 送礼物表
 * @author 作者: Administrator
 * @version 创建时间：2017年1月12日 下午1:44:06
 */
public class GivingGifts implements Serializable{

	private static final long serialVersionUID = -7259897724223793050L;
	
	private Integer id;
	private Integer rid;
	private Integer uid;
	private String name;
	private Integer time;
	
	private String userName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		if (time==null) {
			return "未定义";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(time, null);
			return timeStamp2Date;
		}
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getUserName() {
		if (userName==null) {
			return "-- --";
		}
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "GivingGifts [id=" + id + ", rid=" + rid + ", uid=" + uid + ", name=" + name + ", time=" + time
				+ ", userName=" + userName + "]";
	}
	
}
