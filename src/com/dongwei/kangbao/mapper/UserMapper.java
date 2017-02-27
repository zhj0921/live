package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.User;
import com.dongwei.kangbao.po.UserDetails;
import com.dongwei.kangbao.po.UserQuery;

/** 
 * 用户mapper
 */
public interface UserMapper {

	
	/**
	 * 通过条件查询用户列表
	 */
	List<User> queryUserByUserQuery(UserQuery userQuery);
	
	/**
	 * 通过条件查询用户个数
	 */
	int queryUserCountByUserQuery(UserQuery userQuery);
	
	/**
	 * 通过用户的id修改用户的状态为启用
	 */
	void updateUserIsStatusById(Integer id);
	
	/**
	 * 通过用户id修改用户的状态为禁用
	 */
	void updateUserNoStatusById(Integer id);
	
	/**
	 * 通过用户的id修改用户的直播状态为启用
	 */
	void updateUserIsIspowerById(Integer id);
	
	/**
	 * 通过用户id修改用户的直播状态为禁用
	 */
	void updateUserNoIspowerById(Integer id);
	
	/**
	 * 通过id查询用户详情
	 */
	UserDetails queryUserDetailsById(Integer id);
	
	
	/**
	 * 通过条件查询用户列表
	 */
	List<User> queryUserByUserQuery1(UserQuery userQuery);
	
}
