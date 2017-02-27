package com.dongwei.kangbao.po;

import java.io.Serializable;

import com.dongwei.kangbao.utils.TimeUtils;






/** 
 * @ClassName: Admin
 * @Company: http://www.dongwei.com/
 * @Description: 管理员实体类
 * @author zhj 
 * @date 2016年9月7日 上午11:21:01  
 */
public class Admin implements Serializable{

	private static final long serialVersionUID = 7672477103921164769L;
	
	private Integer id;
	private String name;//帐号
	private String adminname;//管理员名称
	private String password;//密码
	private String telphone;//手机号
	private Integer states =1;//是否启用
	private Integer last_login_time;//最后登录时间
	private Integer role_id; //角色id
	
	private String roleName;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public Integer getStates() {
		return states;
	}
	public void setStates(Integer states) {
		this.states = states;
	}
	public Integer getLast_login_time() {
		return last_login_time;
	}
	public String getLastLoginTime() {
		if (last_login_time==null) {
			return TimeUtils.getCurentTime();
		}else{
			String timeStamp2Date = TimeUtils.timeStamp2Date(last_login_time, null);
			return timeStamp2Date;
		}
		
	}
	public void setLast_login_time(Integer last_login_time) {
		this.last_login_time = last_login_time;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", adminname=" + adminname + ", password=" + password
				+ ", telphone=" + telphone + ", states=" + states + ", last_login_time=" + last_login_time
				+ ", role_id=" + role_id + ", roleName=" + roleName + "]";
	}

}
