package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.po.PrivilegeQuery;
import com.dongwei.kangbao.po.Role;



public interface PrivilegeMapper {

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查询所有权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findAll();
	List<Privilege> findAllMenu(Integer classify);

	
	/**
	 * 
	 * @Title: findPrivilegeByUsername
	 * @Description: 根据用户名查询对应的权限
	 * @param username
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findMenuByAdminName(String name);
	List<Privilege> findMenuByAdminNameMenu(PrivilegeQuery privilegeQuery);


	/**
	 * 
	 * @Title: findByConditions
	 * @Description: 根据用户名查询权限
	 * @param name
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> findByConditions(String name);

	
	/**
	 * 
	 * @Title: addRole
	 * @Description: 添加权限组
	 * @param role
	 * @return void
	 * @throws
	 */
	void addRole(Role role);

	/**
	 * 
	 * @Title: addRolePrivilege
	 * @Description: 增加权限组
	 * @param privilege
	 * @return void
	 * @throws
	 */
	void addRolePrivilege(Privilege privilege);

	/**
	 * 
	 * @Title: queryPrivilegeByPrivilegeQuery
	 * @Description: 列表数据
	 * @param privilegeQuery
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> queryPrivilegeByPrivilegeQuery(PrivilegeQuery privilegeQuery);

	/**
	 * 
	 * @Title: queryPrivilegeCountByPrivilegeQuery
	 * @Description: 分页总数
	 * @param privilegeQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryPrivilegeCountByPrivilegeQuery(PrivilegeQuery privilegeQuery);

	
	/**
	 * 
	 * @Title: queryPrivilegeTitleById
	 * @Description: 根据id查询title
	 * @param pid
	 * @return
	 * @return String
	 * @throws
	 */
	String queryPrivilegeTitleById(Integer id);

	/**
	 * 
	 * @Title: queryRoleById
	 * @Description: 根据id查询
	 * @param id
	 * @return
	 * @return Role
	 * @throws
	 */
	Role queryRoleById(Integer id);

	/**
	 * 
	 * @Title: updateRole
	 * @Description: 更新权限组
	 * @return void
	 * @throws
	 */
	void updateRole(Role role);


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
	 * @Title: deleteRPById
	 * @Description: 删除权限组对应的权限
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleteRPById(Integer id);

	/**
	 * 
	 * @Title: disableRoleById
	 * @Description: 禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	void disableRoleById(Integer id);

	/**
	 * 
	 * @Title: enabledRoleById
	 * @Description: 启用
	 * @param id
	 * @return void
	 * @throws
	 */
	void enabledRoleById(Integer id);


	/**
	 * 
	 * @Title: queryPrivileges
	 * @Description: 查询所有权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	List<Privilege> queryPrivileges();


	/**
	 * 
	 * @Title: deleRolePrivilegeByRoleId
	 * @Description: 删除角色对应的权限
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleRolePrivilegeByRoleId(Integer id);

	

}
