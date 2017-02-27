package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.RoleMapper;
import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.service.RoleService;
import com.dongwei.kangbao.utils.page.Pagination;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public Pagination queryRoleByRoleQuery(Integer pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role queryRoleById(Integer id) {
		Role role = roleMapper.queryRoleById(id);
		return role;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoleById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<Role> findAll() {
		List<Role> list = roleMapper.findAll();
		return list;
	}

	
	

}
