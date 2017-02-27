package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 评论表
 * @author 作者: Administrator
 * @version 创建时间：2017年1月12日 下午2:05:47
 */
public class Comment implements Serializable{

	private static final long serialVersionUID = 6908678703882356687L;

	private Integer id;
	private Integer rid;	//直播间id
	private Integer uid;	//用户id
	private String comment;	//评论内容
	private Integer time;	//评论时间
	
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		return "Comment [id=" + id + ", rid=" + rid + ", uid=" + uid + ", comment=" + comment + ", time=" + time
				+ ", userName=" + userName + "]";
	}
	
}
