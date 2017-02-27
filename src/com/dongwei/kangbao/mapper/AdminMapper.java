package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.AdminQuery;



/** 
 * @ClassName: AdminMapper
 * @Company: http://www.dongwei.com/
 * @Description: 管理员mapper接口
 * @author h 
 * @date 2016年9月7日 下午1:28:19  
 */
public interface AdminMapper {

	
	
	/**
	 * 
	 * @Title: findByConditions
	 * @Description: 根据用户名查询管理员
	 * @param string
	 * @return
	 * @return List<Admin>
	 * @throws
	 */
	List<Admin> findByConditions(String username);

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
	 * @Title: queryAdminById
	 * @Description: 根据id查询
	 * @param id
	 * @return
	 * @return Admin
	 * @throws
	 */
	Admin queryAdminById(Integer id);

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
	 * @Title: disableAdminById
	 * @Description: 禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	void disableAdminById(Integer id);

	
	/**
	 * 
	 * @Title: enabledAdminById
	 * @Description: 启用
	 * @param id
	 * @return void
	 * @throws
	 */
	void enabledAdminById(Integer id);

	/**
	 * 
	 * @Title: updateAdmin
	 * @Description: 更新
	 * @param admin
	 * @return void
	 * @throws
	 */
	void updateAdmin(Admin admin);

	
	/**
	 * 
	 * @Title: queryLoginName
	 * @Description: 根据登录帐号查询
	 * @param loginname
	 * @return
	 * @return List<Admin>
	 * @throws
	 */
	List<Admin> queryLoginName(String loginname);

	
	/**
	 * 
	 * @Title: updateLastLoginTime
	 * @Description: 更新登录时间
	 * @param admin
	 * @return void
	 * @throws
	 */
	void updateLastLoginTime(Admin admin);

	
}
