package com.dongwei.kangbao.controller.xyindex;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.Admin;
import com.dongwei.kangbao.po.Privilege;
import com.dongwei.kangbao.po.Today;
import com.dongwei.kangbao.service.HomePageService;
import com.dongwei.kangbao.service.PrivilegeService;
import com.dongwei.kangbao.utils.MD5Utils;
import com.dongwei.kangbao.utils.TimeUtils;

/**
 * @ClassName: HomePageController
 * @Company: http://www.dongwei.com/
 * @Description: 登录首页
 * @author h
 * @date 2016年9月26日 下午1:16:51
 */
@Controller
@RequestMapping("/homepage")
public class HomePageController {

	@Resource
	private HomePageService homePageService;
	@Resource
	private PrivilegeService privilegeService;

	/**
	 * 
	 * @Title: login @Description: 登录 @param request @param username @param
	 * password @param model @return @return String @throws
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, String userName, String password, Model model) {

		// 获取用户名和密码
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			// 使用md5加密密码
			password = MD5Utils.md5(password);
			// 获取到Subject对象
			Subject subject = SecurityUtils.getSubject();// 未认证状态
			// 通过捕获异常信息,知道认证是成功还是失败
			AuthenticationToken authenticationToken = new UsernamePasswordToken(userName, password);
			try {
				subject.login(authenticationToken);// 调用subject的认证方法：login
			} catch (AuthenticationException e) {
				model.addAttribute("error", "用户名或密码错误！！");

				return "/login"; // 登录失败,跳转登录界面
			}
			Admin admin = (Admin) subject.getPrincipal();
			request.getSession().setAttribute("loginAdmin", admin);
			// Object object = request.getSession().getAttribute("loginAdmin");

			return "redirect:/homepage/findData.do";// 登录成功跳转到
		} else {
			// 登录失败，提示用户名或密码错误
			model.addAttribute("error", "用户名或密码错误！！");
			return "/login";
		}
	}

	/**
	 * 登出方法
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		// Object object = request.getSession().getAttribute("loginAdmin");
		HttpSession session = request.getSession();
		if (session != null) {
			// 销毁session中用户
			Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
			request.getSession().setAttribute("loginAdmin", null);
		}
		return "redirect:/login.jsp";
	}

	/**
	 * 左侧列表
	 * @Title: findData @Description: 功能模块加载 @param request @param
	 * model @return @return String @throws
	 */
	@RequestMapping("/findData.do")
	public String findData(HttpServletRequest request, Integer classify, Model model) {
		// 功能菜单
		List<Privilege> list;
		// 获取当前登录用户
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		if (admin != null) {
			if ("admin".equals(admin.getName())) {
				list = privilegeService.findAllMenu(classify);
			} else {
				list = privilegeService.findMenuByAdminNameMenu(admin.getName(),classify);
			}
		} else {
			return "redirect:/login.jsp";
		}
		ArrayList<Privilege> plist = new ArrayList<>();
		for (Privilege privilege : list) {
			if (privilege.getPid() == 0) {
				plist.add(privilege);
			}
		}
		for (Privilege privilege : list) {
			for (int i = 0; i < plist.size(); i++) {
				if (privilege.getPid() == plist.get(i).getId()) {
					plist.get(i).getChildren().add(privilege);
				}
			}
		}
		model.addAttribute("plist", plist);
		model.addAttribute("menuList", list);
		model.addAttribute("classify", classify);
		if(null != classify && classify==1) {
			return "/manageblog";
		} else if(null != classify && classify==2) {
			return "/userlog";
		} else if(null != classify && classify==3) {
			return "/roomlog";
		} else if(null != classify && classify==4) {
			return "/dashboard";
		} else {
			return "/dashboard";
		} 
	}

	/**
	 * 
	 * @Title: findData1 @Description: 为首页准备数据 @param request @param
	 * model @return @return String @throws
	 */
	@RequestMapping("/main.do")
	public String findData1(HttpServletRequest request, Model model) {

		//查询总收入和订单总数量
		//GrossedAndOrderCount grossedAndOrderCount = homePageService.queryGrossedAndOrderCount();
		/*double grossed;
		if(null==grossedAndOrderCount.getGrossed()) {
			grossed = 0.00;
		}else {
			grossed = grossedAndOrderCount.getGrossed();
		}
		
		model.addAttribute("grossed", grossed);
		
		//查询订单总数
		model.addAttribute("orderCount", grossedAndOrderCount.getOrderCount());
		*/
		//创建当天时间戳对象
		Today today = new Today();
		today.setTimesmorning(TimeUtils.getTimesmorning());
		today.setTimesnight(TimeUtils.getTimesnight());
		
		/*//今日订单
		Integer orderCountByToday = homePageService.queryOrderCountByToday(today);
		model.addAttribute("orderCountByToday", orderCountByToday);
		
		//今日的新用户
		Integer userByToday = homePageService.queryUserByToday(today);
		model.addAttribute("userByToday", userByToday);*/
		
		/*//查询20条订单
		List<Order> twentyOrder = homePageService.queryOrderByTwenty();
		model.addAttribute("twentyOrder", twentyOrder);*/
		
		/*// 查询所有未发货的订单
		int untreatedOrder = homePageService.findUntreatedOrder();
		model.addAttribute("untreatedOrder", untreatedOrder);
		// 查询所有商品数量
		int goodsNum = homePageService.findGoodsNum();
		model.addAttribute("goodsNum", goodsNum);
		// 查询所有会员
		int userNum = homePageService.findUserNum();
		model.addAttribute("userNum", userNum);
		// 查询所有订单
		int orderNum = homePageService.findOrderNum();
		model.addAttribute("orderNum", orderNum);
		// 查询今日订单
		int todayOrderNum = homePageService.findTodayOrderNum();
		model.addAttribute("todayOrderNum", todayOrderNum);
		// 查询今日用户新增
		int todayUserNum = homePageService.findTodayUserNum();
		model.addAttribute("todayUserNum", todayUserNum);
		// 查询今日商品新增
		int todayGoodsNum = homePageService.findTodayGoodsNum();
		model.addAttribute("todayGoodsNum", todayGoodsNum);
		// 查询今日访问
		int todayUserVisitNum = homePageService.findTodayUserVisitNum();
		model.addAttribute("todayUserVisitNum", todayUserVisitNum);

		Properties props = System.getProperties(); // 系统属性
		String property = props.getProperty("java.version");// Java的运行环境版本
		model.addAttribute("property", property);
		String property2 = props.getProperty("os.name");// 操作系统的名称
		model.addAttribute("property2", property2);*/
		
		return "/main";

	}

	/**
	 * 
	 * @Title: findMenu @Description: 加载菜单 @param request @param
	 * model @return @return String @throws
	 */
	/*@RequestMapping("/findMenu.do")
	@ResponseBody
	public List<String> findMenu(HttpServletRequest request, Model model) {
		// 功能菜单
		List<Privilege> list;
		// 获取当前登录用户
		HealthScreening admin = (HealthScreening) request.getSession().getAttribute("loginAdmin");
		if (admin != null) {
			if ("admin".equals(admin.getName())) {
				list = privilegeService.findAllMenu();
			} else {
				list = privilegeService.findMenuByAdminName(admin.getName());
			}
		} else {
			return null;
		}
		ArrayList<Privilege> plist = new ArrayList<>();
		for (Privilege privilege : list) {
			if (privilege.getPid() == 0) {
				plist.add(privilege);
			}
		}
		for (Privilege privilege : list) {
			for (int i = 0; i < plist.size(); i++) {
				if (privilege.getPid() == plist.get(i).getId()) {
					plist.get(i).getChildren().add(privilege);
				}
			}
		}

		model.addAttribute("plist", plist);
		model.addAttribute("menuList", list);

		ArrayList<String> menuList = new ArrayList<>();
		for (Privilege pPrivilege : plist) {
			StringBuilder params = new StringBuilder();
			for (Privilege sPrivilege : pPrivilege.getChildren()) {
				params.append("<li><a href=" + sPrivilege.getUrl() + ">" + sPrivilege.getTitle() + "</a></li>");
			}
			String b = params.toString();
			String a = "<li class='menu-list'><a href=" + "" + "><i class='fa fa-laptop'></i><span>"
					+ pPrivilege.getTitle() + "</span></a><ul class='sub-menu-list'>" + b + "</ul></li>";
			menuList.add(a);
		}
		System.out.println(menuList.toString());
		return menuList;

	}
*/
	/**
	 * 
	 * @Title: getAdmin @Description: 获取登录帐号 @param request @return @return
	 * String @throws
	 */
	@RequestMapping("/getAdmin.do")
	@ResponseBody
	public String getAdmin(HttpServletRequest request) {
		// 获取管理员登录帐号
		Admin admin = (Admin) request.getSession().getAttribute("loginAdmin");
		if(admin!=null ){
			String loginName = admin.getName();
			if(StringUtils.isNotBlank(loginName)){
				return loginName;
			}
		}
		return "nologin";
		
	}
	

}
