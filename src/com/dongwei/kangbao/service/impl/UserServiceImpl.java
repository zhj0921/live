package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.UserMapper;
import com.dongwei.kangbao.po.User;
import com.dongwei.kangbao.po.UserDetails;
import com.dongwei.kangbao.po.UserQuery;
import com.dongwei.kangbao.service.UserService;
import com.dongwei.kangbao.utils.page.Pagination;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	public Pagination queryUserByUserQuery(UserQuery userQuery) {
		
		// 创建OrderQuery查询对象
		UserQuery uq = new UserQuery();

		StringBuilder params = new StringBuilder();
		// 添加条件
		if (userQuery.getNickname() != null && userQuery.getNickname() != "") {
			uq.setNickname(userQuery.getNickname());
			params.append("name=").append(userQuery.getNickname());
		}
		if (userQuery.getStatus() != null && userQuery.getStatus() != 0) {
			uq.setStatus(userQuery.getStatus());
			params.append("&status=").append(userQuery.getStatus());
		}
		if (userQuery.getIspower() != null && userQuery.getIspower() != 0) {
			uq.setIspower(userQuery.getIspower());
			params.append("&ispower=").append(userQuery.getIspower());
		}

		uq.setPageSize(15);
		uq.setPageNo(Pagination.cpn(userQuery.getPageNo()));

		List<User> list = userMapper.queryUserByUserQuery(uq);
		int totalCount = userMapper.queryUserCountByUserQuery(uq);
		Pagination pagination = new Pagination(uq.getPageNo(), uq.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/user/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
		
	}
	
	
	/**
	 * 通过用户的id修改用户的状态为启用
	 */
	public void updateUserIsStatusById(Integer id) {
		userMapper.updateUserIsStatusById(id);
	}
	
	/**
	 * 通过用户id修改用户的状态为禁用
	 */
	public void updateUserNoStatusById(Integer id) {
		userMapper.updateUserNoStatusById(id);
	}
	
	/**
	 * 通过用户的id修改用户的直播状态为启用
	 */
	public void updateUserIsIspowerById(Integer id) {
		userMapper.updateUserIsIspowerById(id);
	}
	
	/**
	 * 通过用户id修改用户的直播状态为禁用
	 */
	public void updateUserNoIspowerById(Integer id) {
		userMapper.updateUserNoIspowerById(id);
	}
	
	/**
	 * 通过id查询用户详情
	 */
	public UserDetails queryUserDetailsById(Integer id) {
		return userMapper.queryUserDetailsById(id);
	}
	
	
	/**
	 * 通过条件查询用户列表
	 */
	public List<User> queryUserByUserQuery1(UserQuery userQuery) {
		return userMapper.queryUserByUserQuery1(userQuery);
	}
		
}
