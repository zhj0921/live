package com.dongwei.kangbao.service;

import java.util.List;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.utils.page.Pagination;

public interface AdminService {

	/**
	 * 
	 * @Title: queryCustomerList
	 * @Description: 管理员列表查询
	 * @param queryVo
	 * @return
	 * @return List<Customer>
	 * @throws
	 */
	public Pagination queryAdminByAdminQuery( Integer pageNo);

	/**
	 * 
	 * @Title: queryAdminById
	 * @Description: 根据id查询
	 * @param id
	 * @return
	 * @return Admin
	 * @throws
	 */
	public Admin queryAdminById(Integer id);

	
	/**
	 * 
	 * @Title: deleteAdminById
	 * @Description: 根据id删除
	 * @param id
	 * @return void
	 * @throws
	 */
	public void deleteAdminById(Integer id);

	/**
	 * 
	 * @Title: addAdmin
	 * @Description: 添加管理员
	 * @param admin
	 * @return void
	 * @throws
	 */
	public void addAdmin(Admin admin);

	public Admin queryAdminByName(String username);

	public void updateAdmin(Admin admin);

	
	/**
	 * 
	 * @Title: disableAdminById
	 * @Description: 禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	public void disableAdminById(Integer id);

	
	/**
	 * 
	 * @Title: enabledAdminById
	 * @Description: 启用
	 * @param id
	 * @return void
	 * @throws
	 */
	public void enabledAdminById(Integer id);

	
	/**
	 * 
	 * @Title: queryLoginName
	 * @Description: 根据登录帐号查询
	 * @param loginname
	 * @return
	 * @return List<Admin>
	 * @throws
	 */
	public List<Admin> queryLoginName(String loginname);

	
	/**
	 * 
	 * @Title: updateLastLoginTime
	 * @Description: 更新最后登录时间
	 * @param admin
	 * @return void
	 * @throws
	 */
	public void updateLastLoginTime(Admin admin);
	
	
}
