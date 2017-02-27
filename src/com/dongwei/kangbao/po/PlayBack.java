package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 回放
 * @author 作者: Administrator
 * @version 创建时间：2017年1月12日 下午2:14:14
 */
public class PlayBack implements Serializable{

	private static final long serialVersionUID = 3047760729568139871L;

	private Integer id;
	private Integer rid;
	private Integer uid;
	private String videoaddress;	//视频地址
	private Integer starttime;		//开始时间
	private Integer endtime;		//结束时间
	private Integer watchnumber;	//历史观看人数
	private Integer playnumber;		//播放次数
	
	private String userName;
	private Integer time;	//时长
	
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
	public String getVideoaddress() {
		return videoaddress;
	}
	public void setVideoaddress(String videoaddress) {
		this.videoaddress = videoaddress;
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
	public Integer getPlaynumber() {
		return playnumber;
	}
	public void setPlaynumber(Integer playnumber) {
		this.playnumber = playnumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTime() {
		if (starttime==null || endtime==null) {
			return "未知";
		}else{
			String timeStamp3Date = TimeUtils.getDuration((endtime-starttime));
			return timeStamp3Date;
		}
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "PlayBack [id=" + id + ", rid=" + rid + ", uid=" + uid + ", videoaddress=" + videoaddress
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", watchnumber=" + watchnumber + ", playnumber="
				+ playnumber + ", userName=" + userName + ", time=" + time + "]";
	}
	
}
