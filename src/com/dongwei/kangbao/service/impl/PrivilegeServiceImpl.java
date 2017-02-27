package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.PrivilegeMapper;
import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.po.PrivilegeQuery;
import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.service.PrivilegeService;
import com.dongwei.kangbao.utils.page.Pagination;



/** 
 * @ClassName: PrivilegeServiceImpl
 * @Company: http://www.dongwei.com/
 * @Description: 
 * @author h 
 * @date 2016年11月14日 上午11:41:03  
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Resource
	private PrivilegeMapper privilegeMapper;

	/**
	 * 查询所有权限
	 */
	@Override
	public List<Privilege> findAll() {
		List<Privilege> list = privilegeMapper.findAll();
		return list;
	}

	

	/**
	 * 根据用户名查询权限
	 */
	@Override
	public List<Privilege> findPrivilegeByAdminName(String name) {
		if("admin".equals(name)){
			//如果admin超级管理员,查询所有权限
			return privilegeMapper.findAll();
		} else {
			//如果是一般用户,根据用户名称查询权限
			return privilegeMapper.findByConditions( name);
		}
	}

	/**
	 * 列表的分页查询
	 */
	@Override
	public Pagination queryPrivilegeByPrivilegeQuery(Integer pageNo) {
		//创建Query查询对象
		PrivilegeQuery privilegeQuery = new PrivilegeQuery();
		//StringBuilder params = new StringBuilder();
		privilegeQuery.setPageSize(15);
		privilegeQuery.setPageNo(Pagination.cpn(pageNo));
		List <Privilege> list =  privilegeMapper.queryPrivilegeByPrivilegeQuery(privilegeQuery);
		
		for (Privilege privilege : list) {
			StringBuilder qtitle = new StringBuilder();
			if (privilege.getQxzId()!=null && !"".equals(privilege.getQxzId())) {
				//将ids变成数组
				String qxzId = privilege.getQxzId();
				System.out.println(qxzId);
				qxzId = qxzId.trim();
				if (qxzId!=null && !"".equals(qxzId)) {
					String[] ids =qxzId.split(",");//权限id数组
					if (ids!=null && ids.length>0) {
						for (String pid : ids) {
							pid = pid.trim();
							if (pid!=null || pid!="") {
							 String qtitle1 =  privilegeMapper.queryPrivilegeTitleById(Integer.valueOf(pid))+",";
							 qtitle.append(qtitle1);
							}
						}
					}
				}
				
				String ss = qtitle.toString();
				if (ss!=null && ss!="") {
					ss = ss.substring(0,ss.length()-1); 
				}
				privilege.setTitle(ss);
			}
		}
		
		
		int totalCount = privilegeMapper.queryPrivilegeCountByPrivilegeQuery(privilegeQuery);
		Pagination pagination = new Pagination(privilegeQuery.getPageNo(),privilegeQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/privilege/list.do";
		pagination.pageView(url, null);
		return pagination;
		
	}

	/**
	 * 根据id查询
	 */
	@Override
	public Role queryPrivilegeById(Integer id) {
		Role role = privilegeMapper.queryRoleById(id);
		return role;
	}

	/**
	 * 更新
	 */
	@Override
	public void updateRole(Role role) {
		privilegeMapper.updateRole(role);
		String[] ids = role.getQxid().split(",");//权限id数组
		privilegeMapper.deleRolePrivilegeByRoleId(role.getId());
		for(String id : ids){
			Privilege privilege = new Privilege();
			privilege.setId(Integer.valueOf(id));
			privilege.setRoleId(role.getId());
			privilegeMapper.addRolePrivilege(privilege);
			//privilegeMapper.addRolePrivilege(privilege);
		}
		
	}

	/**
	 * 根据id删除
	 */
	@Override
	public void deleteRoleById(Integer id) {
		privilegeMapper.deleteRoleById(id);
		privilegeMapper.deleteRPById(id);
	}

	

	/**
	 * 查询所有权限
	 */
	@Override
	public List<Privilege> findAllMenu(Integer classify) {
		List<Privilege> privilegeList = privilegeMapper.findAllMenu(classify);
		return privilegeList;
	}

	/**
	 * 根据帐号查询对应的权限
	 */
	@Override
	public List<Privilege> findMenuByAdminName(String name) {
		List<Privilege>privilegeList = privilegeMapper.findMenuByAdminName(name);
		return privilegeList;
	}
	
	
	@Override
	public List<Privilege> findMenuByAdminNameMenu(String name,Integer classify) {
		PrivilegeQuery pq = new PrivilegeQuery();
		pq.setName(name);
		pq.setClassify(classify);
		List<Privilege>privilegeList = privilegeMapper.findMenuByAdminNameMenu(pq);
		return privilegeList;
	}


	
	
	

	/**
	 * 增加权限组
	 */
	@Override
	public void addRole(Role role) {
		privilegeMapper.addRole(role);;//持久态
		Integer roleId = role.getId();
		//将ids变成数组
		String[] ids = role.getQxid().split(",");//权限id数组
		for(String id : ids){
			Privilege privilege = new Privilege();
			privilege.setId(Integer.valueOf(id));
			privilege.setRoleId(roleId);
			privilegeMapper.addRolePrivilege(privilege);
		}
	}



	/**
	 * 
	 * @Title: disablePrivilegeById
	 * @Description: 禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	@Override
	public void disablePrivilegeById(Integer id) {
		privilegeMapper.disableRoleById(id);
	}


	/**
	 * 
	 * @Title: enabledPrivilegeById
	 * @Description: 启用
	 * @param id
	 * @return void
	 * @throws
	 */
	@Override
	public void enabledPrivilegeById(Integer id) {
		privilegeMapper.enabledRoleById(id);
	}


	/**
	 * 
	 * @Title: queryPrivileges
	 * @Description: 查询所有权限
	 * @return
	 * @return List<Privilege>
	 * @throws
	 */
	@Override
	public List<Privilege> queryPrivileges() {
		List<Privilege> pList = privilegeMapper.queryPrivileges();
		return pList;
	}



	

	

	
	
	

}
