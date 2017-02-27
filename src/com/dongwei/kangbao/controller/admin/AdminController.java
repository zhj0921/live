package com.dongwei.kangbao.controller.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.Role;
import com.dongwei.kangbao.service.AdminService;
import com.dongwei.kangbao.service.PrivilegeService;
import com.dongwei.kangbao.service.RoleService;
import com.dongwei.kangbao.utils.page.Pagination;



/** 
 * @ClassName: AdminController
 * @Company: http://www.dongwei.com/
 * @Description: 
 * @author h 
 * @date 2016年9月7日 下午3:40:49  
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Resource
	private AdminService adminService;
	@Resource
	private RoleService roleService;
	

	@Resource
	private PrivilegeService privilegeService;

	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: list
	 * @Description: 管理员列表查询
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/list.do")
	public String list( Integer pageNo,Model model) throws UnsupportedEncodingException{
		//调用service执行查询
		Pagination pagination = adminService.queryAdminByAdminQuery(pageNo);
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageNo", pagination.getPageNo());
		return "/admin/gllist";
	}
	
	/**
	 * 
	 * @Title: edit
	 * @Description: 修改
	 * @param id
	 * @return
	 * @return Customer
	 * @throws
	 */
	@RequestMapping("/edit.do")
	public String edit(Integer id ,Integer pageNo ,Model model){
		Admin admin = adminService.queryAdminById(id);
		model.addAttribute("admin", admin);
		model.addAttribute("pageNo", pageNo);
		//初始化角色下拉框
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		return "/admin/edit";
	}
	/**
	 * 
	 * @Title: updateAdmin
	 * @Description: 更新
	 * @param id
	 * @return void
	 * @throws
	 */
	@RequestMapping("/update.do")
	public  String updateAdmin(Admin admin){
		adminService.updateAdmin(admin);
		return "redirect:list.do";
	}
	
	/**
	 * 
	 * @Title: queryAdminById
	 * @Description: 根据id查询
	 * @param id
	 * @return void
	 * @throws
	 */
	@RequestMapping("/query.do")
	public  void queryAdminById(Integer id){
		Admin admin = adminService.queryAdminById(id);
		 System.out.println(admin);
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
	public String delete(HttpServletRequest request, Integer id ,Model model){
		adminService.deleteAdminById(id);
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		
		//String curentTime = TimeUtils.getCurentTime();
		//Integer operationTime = TimeUtils.date2TimeStamp(curentTime, null);
		//journalService.journalOperationLogs(admin.getId(),admin.getAdminname(),operationTime,"/admin/delete.do","管理员删除操作！");
		return "ok";
	}
	
	/**
	 * 
	 * @Title: save
	 * @Description: 保存操作
	 * @param customer
	 * @return
	 * @return String
	 * @throws
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/save.do")
	public String save(HttpServletRequest request, Admin admin ){
		adminService.addAdmin(admin);
		Admin admin1 = (Admin) request.getSession().getAttribute("loginAdmin");
		
		//String curentTime = TimeUtils.getCurentTime();
		//Integer operationTime = TimeUtils.date2TimeStamp(curentTime, null);
		//journalService.journalOperationLogs(admin1.getId(),admin1.getAdminname(),operationTime,"/admin/save.do","管理员添加操作！");
		return "redirect:list.do";
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 跳转到添加页面操作
	 * @param customer
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/add.do")
	public String add(Model model){
		//初始化角色下拉框
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		
		return "/admin/add";
	}
	/**
	 * 
	 * @Title: add
	 * @Description: 跳转到添加页面操作
	 * @param customer
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/getAdminName.do")
	@ResponseBody
	public String getAdminName(HttpServletRequest request){
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		 String adminName = admin.getAdminname();
		return adminName;
	}
	
	
	/**
	 * 
	 * @Title: queryName
	 * @Description: 验证登录帐号
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/queryName.do")
	@ResponseBody
	public String queryName(String loginname){
		List <Admin> adminList = adminService.queryLoginName(loginname);
		if (adminList== null || adminList.size()==0) {
			return "ok";
		}else{
			return "no";
		}
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
		adminService.disableAdminById(id);
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
		adminService.enabledAdminById(id);
		return "ok";
	}
	
	
	
}
