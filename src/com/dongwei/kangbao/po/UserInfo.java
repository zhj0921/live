package com.dongwei.kangbao.po;

import java.io.Serializable;

/**
 * 用户信息表
 * @author 作者: Administrator
 * @version 创建时间：2016年12月7日 下午2:37:08
 */
public class UserInfo implements Serializable{

	
	private static final long serialVersionUID = 7043546364229713602L;

	private Integer id;
	private Integer uid;		//用户id
	private String nickname;	//用户昵称
	private Integer avator;		//用户头像id
	private Integer sex;		//性别  0没公开 1男 2女
	private Integer age;		//年龄
	private String trades;		//个性签名
	private Integer emotional;	//0未婚 1已婚 2保密
	private String hometown;	//家乡 比如  1，2，3
	private String profession;	//职业
	private String constellation;//星座
	private Integer video_pic;	//图片id
	private String videopicpath;	//图片id
	
	private String name;
	private String id_number;
	private String id_photo;
	private Double tmoney;
	private Integer login_num;
	private Integer watch_num;
	private Integer show_num;
	private Integer msg_num;
	private Integer give_num;
	private Integer follow_num;
	private Integer fans_num;
	
	
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getVideopicpath() {
		return videopicpath;
	}
	public void setVideopicpath(String videopicpath) {
		this.videopicpath = videopicpath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getId_photo() {
		return id_photo;
	}
	public void setId_photo(String id_photo) {
		this.id_photo = id_photo;
	}
	public Double getTmoney() {
		return tmoney;
	}
	public void setTmoney(Double tmoney) {
		this.tmoney = tmoney;
	}
	public Integer getLogin_num() {
		return login_num;
	}
	public void setLogin_num(Integer login_num) {
		this.login_num = login_num;
	}
	public Integer getWatch_num() {
		return watch_num;
	}
	public void setWatch_num(Integer watch_num) {
		this.watch_num = watch_num;
	}
	public Integer getShow_num() {
		return show_num;
	}
	public void setShow_num(Integer show_num) {
		this.show_num = show_num;
	}
	public Integer getMsg_num() {
		return msg_num;
	}
	public void setMsg_num(Integer msg_num) {
		this.msg_num = msg_num;
	}
	public Integer getGive_num() {
		return give_num;
	}
	public void setGive_num(Integer give_num) {
		this.give_num = give_num;
	}
	public Integer getFollow_num() {
		return follow_num;
	}
	public void setFollow_num(Integer follow_num) {
		this.follow_num = follow_num;
	}
	public Integer getFans_num() {
		return fans_num;
	}
	public void setFans_num(Integer fans_num) {
		this.fans_num = fans_num;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", uid=" + uid + ", nickname=" + nickname + ", avator=" + avator + ", sex=" + sex
				+ ", age=" + age + ", trades=" + trades + ", emotional=" + emotional + ", hometown=" + hometown
				+ ", profession=" + profession + ", constellation=" + constellation + ", video_pic=" + video_pic
				+ ", videopicpath=" + videopicpath + ", name=" + name + ", id_number=" + id_number + ", id_photo="
				+ id_photo + ", tmoney=" + tmoney + ", login_num=" + login_num + ", watch_num=" + watch_num
				+ ", show_num=" + show_num + ", msg_num=" + msg_num + ", give_num=" + give_num + ", follow_num="
				+ follow_num + ", fans_num=" + fans_num + "]";
	}
	
	
}
