package com.dongwei.kangbao.service;

import java.util.List;

import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.utils.page.Pagination;

public interface RoleService {

	/**
	 * 
	 * @Title: queryRoleByRoleQuery
	 * @Description: 列表查询
	 * @param 
	 * @return
	 * @return 
	 * @throws
	 */
	public Pagination queryRoleByRoleQuery(Integer pageNo);

	/**
	 * 
	 * @Title: queryRoleById
	 * @Description: 根据id查询
	 * @param id
	 * @return
	 * @return Role
	 * @throws
	 */
	public Role queryRoleById(Integer id);

	/**
	 * 
	 * @Title: 
	 * @Description: 更新
	 * @param admin
	 * @return void
	 * @throws
	 */
	public void updateRole(Role role);

	/**
	 * 
	 * @Title: 
	 * @Description: 根据id删除
	 * @param id
	 * @return void
	 * @throws
	 */
	public void deleteRoleById(Integer id);

	/**
	 * 
	 * @Title: 
	 * @Description: 添加
	 * @param 
	 * @return void
	 * @throws
	 */
	public void addRole(Role role);
	

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查询所有角色
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Role> findAll();

}
