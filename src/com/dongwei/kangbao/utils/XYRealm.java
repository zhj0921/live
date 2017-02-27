package com.dongwei.kangbao.utils;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.dongwei.kangbao.mapper.AdminMapper;
import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.service.PrivilegeService;





public class XYRealm extends AuthorizingRealm{

	@Resource
	private AdminMapper adminMapper;
	@Resource
	private PrivilegeService privilegeService;
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalcollection) {
		//使用functionService,根据当前用户名称,查询当前用户的权限数据
		//获取当前登录用户对象
		SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
		Admin admin = (Admin) principalcollection.getPrimaryPrincipal();
		List<Privilege> list = privilegeService.findPrivilegeByAdminName(admin.getName());
		if(null != list && list.size() > 0){
			//查询到权限
			for(Privilege privilege : list){
				String code = privilege.getCode();
				if(null!=code){
					sai.addStringPermission(privilege.getCode());//授权
				}
			}
		}
		return sai;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationtoken)
			throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) authenticationtoken;
		//从令牌中获取用户名和密码
		String username = upt.getUsername();
		//char[] password = upt.getPassword();
		//根据用户名查询用户
		try {
			List<Admin> list = adminMapper.findByConditions(username);
			if(null != list && list.size() > 0){//如果根据用户名查询到一个用户,说明帐号正确
				//参数1:可以传入任意对象,该对象特点就是在任何地方都可以被获取到,一般放登录用户对象
				//参数2:需要认证的数据,一般放密码
				//参数3:当前Realm的类名
				AuthenticationInfo ai = new SimpleAuthenticationInfo(list.get(0), list.get(0).getPassword(), XYRealm.class.getSimpleName());
				return ai;//将认证信息对象返回给安全管理器,安全管理会对用户输入的密码和数据库查询的密码进行比较
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//查询不到用户,说明帐号错误,直接返回null
		return null;
	}


}
