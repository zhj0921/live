package com.dongwei.kangbao.po;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 用户详情
 * @author 作者: Administrator
 * @version 创建时间：2017年1月14日 下午3:54:32
 */
public class UserDetails implements Serializable{

	private static final long serialVersionUID = 3637106075091499797L;
	
	private Integer id;		//用户id
	private String phone;		//用户手机号
	private Integer loginTime;		//登录时间
	private Integer quitTime;		//退出时间
	private Integer loginState;
	private Integer status;	//1启用，2禁用
	private Integer memberRegTime;	//注册时间
	private String memberLoginPass;	//登录密码
	private String deviceToken;		//设备token
	private Integer deviceType;		//1安卓，2苹果
	private Integer integral;		//积分
	private Double memberMoney;	//用户金额
	private Integer loginnum;		//登录次数
	private Integer memberGrade;	//用户等级
	private Integer authenticate;	//0未认证 1 认证
	private Integer ispower;		//2不能直播，1能直播
	private Integer dd;		//豆豆
	private Integer authid;		//auth 认证
	private Integer authtype;		//1QQ 2微信 3微博
	private String regid;		//极光推送设备注册ID
	private String nickname;	//用户昵称
	
	
	
	private Integer avator;		//用户头像id
	private Integer sex;		//性别  0没公开 1男 2女
	private Integer age;		//年龄
	private String trades;		//个性签名
	private Integer emotional;	//0未婚 1已婚 2保密
	private String hometown;	//家乡 比如  1，2，3
	private String profession;	//职业
	private String constellation;//星座
	private Integer video_pic;	//图片idd
	//private String videopicpath;	//图片
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLoginTime() {
		if (loginTime !=null && loginTime !=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(loginTime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
	}
	/*public String getLoginTimeStr() {
		if (loginTime !=null && loginTime !=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(loginTime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
	}*/
	
	public void setLoginTime(Integer loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getQuitTime() {
		return quitTime;
	}
	public String getQuitTimeStr() {
		if (quitTime !=null && quitTime !=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(quitTime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
	}
	
	public void setQuitTime(Integer quitTime) {
		this.quitTime = quitTime;
	}
	public Integer getLoginState() {
		return loginState;
	}
	public void setLoginState(Integer loginState) {
		this.loginState = loginState;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMemberRegTime() {
		if (memberRegTime!=null && memberRegTime !=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(memberRegTime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
	}
	/*public String getMemberRegTimeStr() {
		if (memberRegTime!=null && memberRegTime !=0) {
			String timeStamp2Date = TimeUtils.timeStamp2Date(memberRegTime, null);
			return timeStamp2Date;
		}else{
			String curentTime = TimeUtils.getCurentTime();
			return curentTime;
		}
	}*/
	
	public String getMemberLoginPass() {
		return memberLoginPass;
	}
	public void setMemberLoginPass(String memberLoginPass) {
		this.memberLoginPass = memberLoginPass;
	}
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public Integer getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Double getMemberMoney() {
		return memberMoney;
	}
	public void setMemberMoney(Double memberMoney) {
		this.memberMoney = memberMoney;
	}
	public void setMemberRegTime(Integer memberRegTime) {
		this.memberRegTime = memberRegTime;
	}
	public Integer getLoginnum() {
		if(loginnum==null) {
			return 0;
		}
		return loginnum;
	}
	public Integer getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(Integer memberGrade) {
		this.memberGrade = memberGrade;
	}
	public Integer getAuthenticate() {
		return authenticate;
	}
	public void setAuthenticate(Integer authenticate) {
		this.authenticate = authenticate;
	}
	public Integer getIspower() {
		return ispower;
	}
	public void setIspower(Integer ispower) {
		this.ispower = ispower;
	}
	public Integer getDd() {
		return dd;
	}
	public void setDd(Integer dd) {
		this.dd = dd;
	}
	public void setLoginnum(Integer loginnum) {
		this.loginnum = loginnum;
	}
	public String getNickname() {
		if (StringUtils.isBlank(nickname)) {
			return "昵称";
		}
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getAuthid() {
		return authid;
	}
	public void setAuthid(Integer authid) {
		this.authid = authid;
	}
	public Integer getAuthtype() {
		return authtype;
	}
	public void setAuthtype(Integer authtype) {
		this.authtype = authtype;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	
	
	public Integer getAvator() {
		return avator;
	}
	public void setAvator(Integer avator) {
		this.avator = avator;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTrades() {
		return trades;
	}
	public void setTrades(String trades) {
		this.trades = trades;
	}
	public Integer getEmotional() {
		return emotional;
	}
	public void setEmotional(Integer emotional) {
		this.emotional = emotional;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getConstellation() {
		return constellation;
	}
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	public Integer getVideo_pic() {
		return video_pic;
	}
	public void setVideo_pic(Integer video_pic) {
		this.video_pic = video_pic;
	}
	/*public String getVideopicpath() {
		return videopicpath;
	}
	public void setVideopicpath(String videopicpath) {
		this.videopicpath = videopicpath;
	}*/
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", phone=" + phone + ", loginTime=" + loginTime + ", quitTime=" + quitTime
				+ ", loginState=" + loginState + ", status=" + status + ", memberRegTime=" + memberRegTime
				+ ", memberLoginPass=" + memberLoginPass + ", deviceToken=" + deviceToken + ", deviceType=" + deviceType
				+ ", integral=" + integral + ", memberMoney=" + memberMoney + ", loginnum=" + loginnum
				+ ", memberGrade=" + memberGrade + ", authenticate=" + authenticate + ", ispower=" + ispower + ", dd="
				+ dd + ", authid=" + authid + ", authtype=" + authtype + ", regid=" + regid + ", nickname=" + nickname
				+ ", avator=" + avator + ", sex=" + sex + ", age=" + age + ", trades=" + trades + ", emotional="
				+ emotional + ", hometown=" + hometown + ", profession=" + profession + ", constellation="
				+ constellation + ", video_pic=" + video_pic + "]";
	}
	
}
