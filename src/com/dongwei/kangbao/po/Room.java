package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

public class Room implements Serializable{
	
	private static final long serialVersionUID = -3125460535093116808L;
	
	private Integer id;
	private Integer uid;		//用户id
	private String pushflow;	//推流地址
	private String pullflow;	//拉流地址
	private Integer starttime;	//直播开始时间
	private Integer endtime;	//直播结束时间
	private Integer watchnumber;//观看人数
	private Integer addtime;	//添加时间
	private Integer playbackstatus;//0：启用回放  1：禁止回放
	
	private String userName;	//用户名称
	private Integer time;		//时长
	
	
	
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
	public String getPushflow() {
		return pushflow;
	}
	public void setPushflow(String pushflow) {
		this.pushflow = pushflow;
	}
	public String getPullflow() {
		return pullflow;
	}
	public void setPullflow(String pullflow) {
		this.pullflow = pullflow;
	}
	public String getStarttime() {
		if (starttime==null) {
			return "未定义";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(starttime, null);
			return timeStamp2Date;
		}
	}
	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		if (endtime==null) {
			return "未定义";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(endtime, null);
			return timeStamp2Date;
		}
	}
	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}
	public Integer getWatchnumber() {
		return watchnumber;
	}
	public void setWatchnumber(Integer watchnumber) {
		this.watchnumber = watchnumber;
	}
	public String getAddtime() {
		if (addtime==null) {
			return "未定义";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(addtime, null);
			return timeStamp2Date;
		}
	}
	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}
	public Integer getPlaybackstatus() {
		return playbackstatus;
	}
	public void setPlaybackstatus(Integer playbackstatus) {
		this.playbackstatus = playbackstatus;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public String getTime() {
		if (time==null) {
			return "未定义";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(time, null);
			return timeStamp2Date;
		}
	}
	
	public String getUserName() {
		if (userName==null) {
			return "昵称";
		}
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", uid=" + uid + ", pushflow=" + pushflow + ", pullflow=" + pullflow + ", starttime="
				+ starttime + ", endtime=" + endtime + ", watchnumber=" + watchnumber + ", addtime=" + addtime
				+ ", playbackstatus=" + playbackstatus + ", userName=" + userName + ", time=" + time + "]";
	}
	
}
