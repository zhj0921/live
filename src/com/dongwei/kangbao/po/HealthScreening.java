package com.dongwei.kangbao.po;

import java.io.Serializable;
import com.dongwei.kangbao.utils.TimeUtils;

/** 
 * @ClassName: Health
 * @Company: http://www.dongwei.com/
 * @Description: 健康筛查实体类
 * @author h 
 * @date 2016年11月25日 下午1:22:05  
 */
public class HealthScreening implements Serializable{

	private static final long serialVersionUID = -5433543758302910575L;
	
	private Integer id;
	private String ordercode;
	private String name;//用户名
	private String phone;	//体检人手机号
	private Integer combo_id;//体检项目id
	private String combo_name;	//体检项目名称
	private Double combo_price;	//体检项目价格
	private String hospital_name;	//医院名称
	private String city_name;		//城市名称
	private Integer class_id;		//筛查类型id
	private String class_name;		//筛查类型名称
	private Integer addtime;		//下单时间
	private Integer paystatus;		//支付状态 0：未支付1:已支付	
	
	
	

	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCombo_id() {
		return combo_id;
	}
	public void setCombo_id(Integer combo_id) {
		this.combo_id = combo_id;
	}
	public String getCombo_name() {
		return combo_name;
	}
	public void setCombo_name(String combo_name) {
		this.combo_name = combo_name;
	}
	public Double getCombo_price() {
		return combo_price;
	}
	public void setCombo_price(Double combo_price) {
		this.combo_price = combo_price;
	}
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	public Integer getAddtime() {
		return addtime;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getAddtimeStr() {
		if (addtime!=null&&!"".equals(addtime)) {
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
	@Override
	public String toString() {
		return "HealthScreening [id=" + id + ", ordercode=" + ordercode + ", name=" + name + ", phone=" + phone
				+ ", combo_id=" + combo_id + ", combo_name=" + combo_name + ", combo_price=" + combo_price
				+ ", hospital_name=" + hospital_name + ", city_name=" + city_name + ", class_id=" + class_id
				+ ", class_name=" + class_name + ", addtime=" + addtime + ", paystatus=" + paystatus + "]";
	}
	
}
