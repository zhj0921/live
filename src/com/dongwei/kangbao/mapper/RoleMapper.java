package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.AdminQuery;
import com.dongwei.kangbao.po.Role;

/** 
 * @ClassName: AdminMapper
 * @Company: http://www.dongwei.com/
 * @Description: 管理员mapper接口
 * @author h 
 * @date 2016年9月7日 下午1:28:19  
 */
public interface RoleMapper {

	List<Admin> findByConditions(String string, String username);

	/**
	 * 
	 * @Title: queryUserByUserQuery
	 * @Description: 查询符合条件的管理员
	 * @param userQuery
	 * @return
	 * @return List<Admin>
	 * @throws
	 */
	List<Admin> queryAdminByAdminQuery(AdminQuery adminQuery);

	/**
	 * 
	 * @Title: queryUserCountByAdminQuery
	 * @Description: 查询符合条件的总数
	 * @param adminQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryAdminCountByAdminQuery(AdminQuery adminQuery);

	/**
	 * 
	 * @Title: insertAdmin
	 * @Description: 添加
	 * @param admin
	 * @return void
	 * @throws
	 */
	void insertAdmin(Admin admin);

	/**
	 * 
	 * @Title: deleteAdminById
	 * @Description: 根据id删除
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleteAdminById(Integer id);


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
	 * @Title: queryAdminByName
	 * @Description: 根据用户名查询
	 * @param username
	 * @return
	 * @return Admin
	 * @throws
	 */
	Admin queryAdminByName(String username);

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查询所有
	 * @return
	 * @return List<Role>
	 * @throws
	 */
	List<Role> findAll();

	
}
