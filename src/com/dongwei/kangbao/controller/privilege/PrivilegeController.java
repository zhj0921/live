 package com.dongwei.kangbao.controller.privilege;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.service.PrivilegeService;
import com.dongwei.kangbao.utils.page.Pagination;


/** 
 * @ClassName: PrivilegeController
 * @Company: http://www.dongwei.com/
 * @Description: 
 * @author h 
 * @date 2016年9月26日 下午1:18:58  
 */
@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	
	@Resource
	private PrivilegeService privilegeService;
	
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: list
	 * @Description: 权限列表查询
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/list.do")
	public String list( Integer pageNo,Model model) throws UnsupportedEncodingException{
		//调用service执行查询
		Pagination pagination = privilegeService.queryPrivilegeByPrivilegeQuery(pageNo);
		model.addAttribute("pagination", pagination);
		return "/admin/qxz";
	}
	
	/**
	 * @throws IOException 
	 * @Title: edit
	 * @Description: 修改
	 * @param id
	 * @return
	 * @return 
	 * @throws
	 */
	@RequestMapping("/edit.do")
	public String edit(Integer id ,HttpServletResponse response,Integer pageNo ,Model model) throws IOException {
		Role role = privilegeService.queryPrivilegeById(id);
		List<Privilege> plist =  privilegeService.queryPrivileges();
		String qxid = role.getQxid();
		List<Object> qxList = new ArrayList<>();
		List<Integer> qxInt = new ArrayList<>();
		if (qxid!=null && !"".equals(qxid)) {
			String[] qxArray = qxid.split(",");
			for (String string : qxArray) {
				int parseInt = Integer.parseInt(string);
				qxInt.add(parseInt);
			}
			for (Privilege p : plist) {
				if (!qxInt.contains(p.getId())) {
					String pStr = "{id:"+p.getId()+",pId:"+p.getPid()+",name:\""+p.getTitle()+"\",open:true}";
					 String a = pStr.substring(0,pStr.length());
					qxList.add(a);
				}else{
					String pStr = "{id:"+p.getId()+",pId:"+p.getPid()+",name:\""+p.getTitle()+"\",checked:true,open:true}";
					 String a = pStr.substring(0,pStr.length());
					 qxList.add(a);
				}
			}
		}
		model.addAttribute("priList", qxList);
		model.addAttribute("qxInt", qxInt);
		model.addAttribute("role", role);
		return "/admin/editqxz";
	}
	
	
	
	
	/**
	 * 
	 * @Title: updateAdmin
	 * @Description: 更新
	 * @param id
	 * @return void
	 * @throws
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/updateRole.do")
	public  String updateRole(Role role ,HttpServletRequest request ){
		privilegeService.updateRole(role);
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		//String curentTime = TimeUtils.getCurentTime();
		//Integer operationTime = TimeUtils.date2TimeStamp(curentTime, null);
		//journalService.journalOperationLogs(admin.getId(),admin.getAdminname(),operationTime,"/privilege/updateRole.do","权限组更新操作！");
		return "redirect:list.do";
	}
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除操作
	 * @param customer
	 * @return
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(Integer id ,HttpServletRequest request){
		privilegeService.deleteRoleById(id);
		
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		//String curentTime = TimeUtils.getCurentTime();
		//Integer operationTime = TimeUtils.date2TimeStamp(curentTime, null);
		//journalService.journalOperationLogs(admin.getId(),admin.getAdminname(),operationTime,"/privilege/delete.do","权限组删除操作！");
		return "ok";
	}
	
	
	
	
	/**
	 * 
	 * @Title: addRole
	 * @Description: 添加操作
	 * @param request  role
	 * @return
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/addRole.do")
	public String addRole(Role role,HttpServletRequest request ){
		privilegeService.addRole(role);
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		//String curentTime = TimeUtils.getCurentTime();
		//Integer operationTime = TimeUtils.date2TimeStamp(curentTime, null);
		//journalService.journalOperationLogs(admin.getId(),admin.getAdminname(),operationTime,"/privilege/addRole.do","权限组添加操作！");
		return "redirect:list.do";
	}
	
	
	/**
	 * 
	 * @Title: disable
	 * @Description: 禁用
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/disable.do")
	@ResponseBody
	public String disable(Integer id){
		privilegeService.disablePrivilegeById(id);
		return "ok";
	}
	
	/**
	 * 
	 * @Title: enabled
	 * @Description: 启用
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/enabled.do")
	@ResponseBody
	public String enabled(Integer id){
		privilegeService.enabledPrivilegeById(id);
		return "ok";
	}
	
	/**
	 * @Title: toAdd
	 * @Description: 去往添加页面
	 * @param id
	 * @return
	 * @return 
	 * @throws
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Integer id ,HttpServletResponse response,Integer pageNo ,Model model){
		List<Privilege> plist =  privilegeService.queryPrivileges();
		List<Object> qxList = new ArrayList<>();
		for (Privilege p : plist) {
			String pStr = "{id:"+p.getId()+",pId:"+p.getPid()+",name:\""+p.getTitle()+"\",open:true}";
			String a = pStr.substring(0,pStr.length());
			qxList.add(a);
		}
		model.addAttribute("priList", qxList);
		return "/admin/addqxz";
	}
	
	
	
}
	

