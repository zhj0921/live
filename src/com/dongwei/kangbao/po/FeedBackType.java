package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 反馈类型
 * @author 作者: Administrator
 * @version 创建时间：2016年12月7日 下午3:57:53
 */
public class FeedBackType implements Serializable{

	private static final long serialVersionUID = 7188725949013127626L;

	private Integer id;
	private String name;		//反馈类型
	private Integer status;		//1启用，2禁用
	private Integer addtime;	//添加时间
	
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
	@Override
	public String toString() {
		return "FeedBackType [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	public Integer getAddtime() {
		return addtime;
	}
	public String getAddtimeStr() {
		if (addtime!=null && addtime!=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(addtime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
		
	}
	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}
	
}
