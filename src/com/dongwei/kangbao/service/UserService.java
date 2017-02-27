package com.dongwei.kangbao.service;

import java.util.List;

import com.dongwei.kangbao.po.User;
import com.dongwei.kangbao.po.UserDetails;
import com.dongwei.kangbao.po.UserQuery;
import com.dongwei.kangbao.utils.page.Pagination;

public interface UserService {

	public Pagination queryUserByUserQuery(UserQuery userQuery);
	
	
	/**
	 * 通过用户的id修改用户的状态为启用
	 */
	public void updateUserIsStatusById(Integer id);
	
	/**
	 * 通过用户id修改用户的状态为禁用
	 */
	public void updateUserNoStatusById(Integer id);
	
	/**
	 * 通过用户的id修改用户的直播状态为启用
	 */
	public void updateUserIsIspowerById(Integer id);
	
	/**
	 * 通过用户id修改用户的直播状态为禁用
	 */
	public void updateUserNoIspowerById(Integer id);
	
	/**
	 * 通过id查询用户详情
	 */
	public UserDetails queryUserDetailsById(Integer id);
	
	
	/**
	 * 通过条件查询用户列表
	 */
	public List<User> queryUserByUserQuery1(UserQuery userQuery);
	
}
