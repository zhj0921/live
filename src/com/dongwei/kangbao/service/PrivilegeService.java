package com.dongwei.kangbao.service;


import java.util.List;

import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.utils.page.Pagination;
/** 
 * @ClassName: PrivilegeService
 * @Company: http://www.dongwei.com/
 * @Description: 权限接口
 * @author h 
 * @date 2016年9月7日 下午1:07:06  
 */
public interface PrivilegeService {

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查询所以权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findAll();

	

	/**
	 * 
	 * @Title: findFunctionsByUsername
	 * @Description: 根据用户名查询权限
	 * @param username
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findPrivilegeByAdminName(String name);

	/**
	 * 
	 * @Title: queryPrivilegeByPrivilegeQuery
	 * @Description: 权限组列表
	 * @param pageNo
	 * @return
	 * @return Pagination
	 * @throws
	 */
	Pagination queryPrivilegeByPrivilegeQuery(Integer pageNo);

	/**
	 * 
	 * @Title: queryPrivilegeById
	 * @Description: 根据id查询
	 * @param id
	 * @return
	 * @return Role
	 * @throws
	 */
	Role queryPrivilegeById(Integer id);


	/**
	 * 
	 * @Title: deleteRoleById
	 * @Description: 删除权限组
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleteRoleById(Integer id);

	
	/**
	 * 
	 * @Title: findAllMenu
	 * @Description: 查询所有权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findAllMenu(Integer classify);
	
	/**
	 * 
	 * @Title: findMenuByAdminName
	 * @Description: 根据用户名查询权限
	 * @param name
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findMenuByAdminName(String name);
	List<Privilege> findMenuByAdminNameMenu(String name,Integer classify);

	
	/**
	 * 
	 * @Title: addRoles
	 * @Description: 正增加权限组
	 * @param role
	 * @return void
	 * @throws
	 */
	void addRole(Role role);

	/**
	 * 
	 * @Title: updateRole
	 * @Description: 更新
	 * @param role
	 * @return void
	 * @throws
	 */
	void updateRole(Role role);


	/**
	 * 
	 * @Title: disablePrivilegeById
	 * @Description: 禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	void disablePrivilegeById(Integer id);


	/**
	 * 
	 * @Title: enabledPrivilegeById
	 * @Description: 启用
	 * @param id
	 * @return void
	 * @throws
	 */
	void enabledPrivilegeById(Integer id);


	/**
	 * 
	 * @Title: queryPrivileges
	 * @Description: 查询所有权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> queryPrivileges();

	
	
	
	
	
}
