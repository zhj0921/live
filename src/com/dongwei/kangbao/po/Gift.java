package com.dongwei.kangbao.po;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.dongwei.kangbao.utils.TimeUtils;

/**
 * 礼物
 * @author 作者: Administrator
 * @version 创建时间：2017年1月13日 上午9:27:50
 */
public class Gift implements Serializable{

	private static final long serialVersionUID = -4720196789566659731L;

	private Integer id;
	private String name;				//礼物名称
	private String giftpicture;			//礼物图片
	private Integer voucher;			//兑换礼物所需要的东西
	private Integer specialeffects;		//0普通特效   1：特殊特效
	private Integer time;				//添加时间
	private Integer status;				//0：启用   1：禁用
	private Integer addtime;
	
	private MultipartFile pic;//图片
	
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
	public String getGiftpicture() {
		return giftpicture;
	}
	public void setGiftpicture(String giftpicture) {
		this.giftpicture = giftpicture;
	}
	public Integer getVoucher() {
		return voucher;
	}
	public void setVoucher(Integer voucher) {
		this.voucher = voucher;
	}
	public Integer getSpecialeffects() {
		return specialeffects;
	}
	public void setSpecialeffects(Integer specialeffects) {
		this.specialeffects = specialeffects;
	}
	public String getTime() {
		if (time==null) {
			return "未知";
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(time, null);
			return timeStamp2Date;
		}
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	public Integer getAddtime() {
		return addtime;
	}
	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}
	@Override
	public String toString() {
		return "Gift [id=" + id + ", name=" + name + ", giftpicture=" + giftpicture + ", voucher=" + voucher
				+ ", specialeffects=" + specialeffects + ", time=" + time + ", status=" + status + ", addtime="
				+ addtime + ", pic=" + pic + "]";
	}
	
}
