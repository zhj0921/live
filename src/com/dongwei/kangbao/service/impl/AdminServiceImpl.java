package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.AdminMapper;
import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.AdminQuery;
import com.dongwei.kangbao.service.AdminService;
import com.dongwei.kangbao.utils.MD5Utils;
import com.dongwei.kangbao.utils.TimeUtils;
import com.dongwei.kangbao.utils.page.Pagination;

@Service
public class AdminServiceImpl implements AdminService {

	@Resource
	private AdminMapper adminMapper;
	/**
	 * 用户列表查询
	 */
	@Override
	public Pagination queryAdminByAdminQuery(Integer pageNo){
		//创建UserQuery查询对象
		AdminQuery adminQuery = new AdminQuery();
		
		adminQuery.setPageSize(15);
		adminQuery.setPageNo(Pagination.cpn(pageNo));
		List <Admin> list =  adminMapper.queryAdminByAdminQuery(adminQuery);
		int totalCount = adminMapper.queryAdminCountByAdminQuery(adminQuery);
		Pagination pagination = new Pagination(adminQuery.getPageNo(),adminQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/admin/list.do";
		pagination.pageView(url, null);
		return pagination;
	}
	
	/*@Resource
	private RoleService roleService;
	//根据角色id查询角色
	public String getRoleName(){
		if(role_id !=null){
			Role role = roleService.queryRoleById(role_id);
			if(role !=null){
				return role.getName();
			}
		}
		return null;
	}*/
	
	/**
	 * 根据id查询
	 */
	@Override
	public Admin queryAdminById(Integer id) {
		Admin admin = adminMapper.queryAdminById(id);
		return admin;
	}
	
	/**
	 * 根据id删除
	 */
	@Override
	public void deleteAdminById(Integer id) {
		adminMapper.deleteAdminById(id);
	}
	/**
	 * 添加
	 */
	@Override
	public void addAdmin(Admin admin) {
		String password = admin.getPassword();
		password = MD5Utils.md5(password);
		admin.setPassword(password);
		
		Integer curentTimeStamp = TimeUtils.getCurentTimeStamp();
		admin.setLast_login_time(curentTimeStamp);
		adminMapper.insertAdmin(admin);
	}
	
	/**
	 * 根据用户名查询
	 */
	@Override
	public Admin queryAdminByName(String username) {
		Admin admin = adminMapper.queryAdminByName(username);
		return admin;
	}

	/**
	 * 更新
	 */
	@Override
	public void updateAdmin(Admin admin) {
		
		String password = admin.getPassword();
		password = MD5Utils.md5(password);
		admin.setPassword(password);
		adminMapper.updateAdmin(admin);
	}

	/**
	 * 禁用
	 */
	@Override
	public void disableAdminById(Integer id) {
		adminMapper.disableAdminById(id);
		
	}

	/**
	 * 启用
	 */
	@Override
	public void enabledAdminById(Integer id) {
		adminMapper.enabledAdminById(id);
	}

	/**
	 * 根据登录帐号查询
	 */
	@Override
	public List<Admin> queryLoginName(String loginname) {
		List<Admin> adminList = adminMapper.queryLoginName(loginname);
		return adminList;
	}

	
	/**
	 * 更新登录时间
	 */
	@Override
	public void updateLastLoginTime(Admin admin) {
		adminMapper.updateLastLoginTime(admin);
	}
	
	

}
