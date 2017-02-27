package com.dongwei.kangbao.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.User;
import com.dongwei.kangbao.po.UserDetails;
import com.dongwei.kangbao.po.UserQuery;
import com.dongwei.kangbao.service.UserService;
import com.dongwei.kangbao.utils.JsonUtil;
import com.dongwei.kangbao.utils.page.Pagination;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	/**
	 * 用户列表
	 */
	@RequestMapping("/list.do")
	public String list(String name, String phone, Integer ispower, Integer pageNo, Integer status, Model model){
		
		UserQuery userQuery = new UserQuery();
		if(null != name && !"".equals(name)) {
			userQuery.setNickname(name);
		}
		if(null != phone && !"".equals(phone)) {
			userQuery.setPhone(phone);
		}
		if(null != status && status!=0) {
			userQuery.setStatus(status);
		}
		if(null != ispower && ispower!=0) {
			userQuery.setIspower(ispower);
		}
		
		//调用service查询用户的列表
		Pagination pagination = userService.queryUserByUserQuery(userQuery);
		
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("ispower", ispower);
		model.addAttribute("status", status);
		model.addAttribute("pageNo", pageNo);
		//将返回的数据添加到list集合中
		model.addAttribute("pagination", pagination);
		
		
		return "/user/userList";
	}
	
	
	/**
	 * 通过id修改状态为启用
	 */
	@RequestMapping("/isstatus.do")
	@ResponseBody
	public String isstatus(Integer id) {
		
		//通过用户id修改用户的状态为启用
		userService.updateUserIsStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改状态为禁用
	 */
	@RequestMapping("/nostatus.do")
	@ResponseBody
	public String nostatus(Integer id) {
		
		//通过用户id修改用户的状态为启用
		userService.updateUserNoStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改直播状态为启用
	 */
	@RequestMapping("/isispower.do")
	@ResponseBody
	public String isIspower(Integer id) {
		
		//通过用户id修改用户的状态为启用
		userService.updateUserIsIspowerById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改直播状态为禁用
	 */
	@RequestMapping("/noispower.do")
	@ResponseBody
	public String noIspower(Integer id) {
		
		//通过用户id修改用户的状态为启用
		userService.updateUserNoIspowerById(id);
		
		return "ok";
	}
	
	/**
	 * 查看用户详情
	 */
	@RequestMapping("/look.do")
	public  String look(Integer id,Model model){
		
		//通过id查询用户详情
		UserDetails userDetails = userService.queryUserDetailsById(id);
		
		model.addAttribute("userDetails", userDetails);
		return "/user/look";
	}
	


	
	
	/**
	 * 用户列表
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list1.do",  produces = "text/html;charset=UTF-8",method={RequestMethod.POST})
	public String list1(HttpServletRequest request, HttpServletResponse response){
		
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		UserQuery userQuery = new UserQuery();
		if(null != name && !"".equals(name)) {
			userQuery.setNickname(name);
		}
		if(null != phone && !"".equals(phone)) {
			userQuery.setPhone(phone);
		}
		
		//调用service查询用户的列表
		List<User> list = userService.queryUserByUserQuery1(userQuery);
		
		
		String jsonStr = JsonUtil.objToJsonStr(list);
		
		System.out.println(jsonStr);
		
		return jsonStr;
		
		
	}
	
	
	/**
	 * 查看用户详情
	 */
	@RequestMapping(value = "/look1.do",  produces = "text/html;charset=UTF-8",method={RequestMethod.GET})
	public  String look1(Integer id){
		
		//通过id查询用户详情
		UserDetails userDetails = userService.queryUserDetailsById(id);
		
		String jsonStr = JsonUtil.objToJsonStr(userDetails);
		
		System.out.println(jsonStr);
		
		return jsonStr;
	}
	
	
}
