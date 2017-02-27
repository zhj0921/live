package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 反馈表
 * @author 作者: Administrator
 * @version 创建时间：2016年12月7日 下午3:51:22
 */
public class FeedBack implements Serializable{

	private static final long serialVersionUID = 2654625404081884293L;

	private Integer id;
	private Integer uid;		//用户id
	private String userName;			//用户或商户名称
	private Integer type_id;		//反馈类型id
	private String typeName;		//反馈类型名称
	private String content;			//反馈内容
	private Integer addtime;		//提交时间
	private Integer status;		    //状态
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAddtime() {
		return addtime;
	}
	public String getAddtimeStr() {
		if (addtime!=null) {
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", uid=" + uid + ", userName=" + userName + ", type_id=" + type_id + ", typeName="
				+ typeName + ", content=" + content + ", addtime=" + addtime + ", status=" + status + "]";
	}
	
	
}
