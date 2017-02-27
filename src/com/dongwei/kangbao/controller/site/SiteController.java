package com.dongwei.kangbao.controller.site;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.SiteConfiguration;
import com.dongwei.kangbao.po.SiteSettings;
import com.dongwei.kangbao.service.SiteService;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Resource
	private SiteService siteService;
	
	/**
	 * 站点--基本设置
	 */
	@RequestMapping("/list.do")
	public String list( Model model){
		
		//查询站点列表
		List<SiteSettings> list = siteService.querySiteSettings();
		
		model.addAttribute("list", list);
		
		return "/site/list";
	}
	
	/**
	 * 通过id修改启用状态--启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/isstatus.do")
	@ResponseBody
	public String isStatus(Integer id) {
		
		//通过id修改基本配置的启用状态
		siteService.updateSiteIsStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改禁用状态--禁用
	 * @param id
	 * @return
	 */
	@RequestMapping("/nostatus.do")
	@ResponseBody
	public String noStatus(Integer id) {
		
		//通过id修改基本配置的启用状态
		siteService.updateSiteNoStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id删除基本设置
	 * @param id
	 * @return
	 */
	@RequestMapping("/del.do")
	@ResponseBody
	public String del(Integer id) {
		
		//通过id删除基本设置
		siteService.delSiteSettingsById(id);
		
		return "ok";
	}
	
	/**
	 * 站点--基本设置编辑显示
	 */
	@RequestMapping("/editSite.do")
	public String editSite(Integer id, Model model){
		
		//通过id查询站点列表
		SiteSettings siteSettings = siteService.querySiteSettingsById(id);
		
		model.addAttribute("siteSettings", siteSettings);
		
		return "/site/editSite";
	}
	
	/**
	 * 站点--基本设置编辑保存
	 */
	@RequestMapping("/updateSite.do")
	public String updateSite(Integer id, String name, String domain_name, String enterprise, Model model){
		//通过id查询站点列表
		SiteSettings siteSettings = siteService.querySiteSettingsById(id);
		//通过id更新基本配置
		SiteSettings site = new SiteSettings();
		site.setId(id);
		if(null == name || "".equals(name)) {
			site.setName(siteSettings.getName());
		}else {
			site.setName(name);
		}
		if(null == domain_name || "".equals(domain_name)) {
			site.setDomain_name(siteSettings.getDomain_name());
		}else {
			site.setDomain_name(domain_name);
		}
		if(null == enterprise || "".equals(enterprise)) {
			site.setEnterprise(siteSettings.getEnterprise());
		}else {
			site.setEnterprise(enterprise);
		}
		
		siteService.updateSiteSettingsById(site);
		
		return "redirect:list.do";
	}
	
	/**
	 * 站点--基本设置添加页面
	 */
	@RequestMapping("/addSite.do")
	public String addSite( Model model){
		return "/site/addSite";
	}
	
	/**
	 * 站点--基本设置编辑保存
	 */
	@RequestMapping("/insertSite.do")
	public String insertSite(String name, String domain_name, String enterprise, Model model){
		
		//通过id更新基本配置
		SiteSettings siteSettings = new SiteSettings();
		
		if(null != name && !"".equals(name)) {
			siteSettings.setName(name);
		}
		if(null != domain_name && !"".equals(domain_name)) {
			siteSettings.setDomain_name(domain_name);
		}
		if(null != enterprise && !"".equals(enterprise)) {
			siteSettings.setEnterprise(enterprise);
		}
		
		siteService.insertSiteSettings(siteSettings);
		
		return "redirect:list.do";
	}
	
	
	/**
	 * =======================================================================================
	 */
	
	
	/**
	 * 站点--站点配置
	 */
	@RequestMapping("/slist.do")
	public String sList( Model model){
		
		//查询站点配置列表
		List<SiteConfiguration> list = siteService.querySiteConfiguration();
		
		model.addAttribute("list", list);
		
		return "/site/slist";
	}
	
	/**
	 * 站点--基本设置添加页面
	 */
	@RequestMapping("/addSiteConfiguration.do")
	public String addSiteConfiguration( Model model){
		return "/site/addSiteC";
	}
	
	/**
	 * 站点--基本设置编辑保存
	 */
	@RequestMapping("/insertSiteConfiguration.do")
	public String insertSiteConfiguration(String title, String key_word, String describe, Model model){
		
		//通过id更新基本配置
		SiteConfiguration siteConfiguration = new SiteConfiguration();
		
		if(null != title && !"".equals(title)) {
			siteConfiguration.setTitle(title);
		}
		if(null != key_word && !"".equals(key_word)) {
			siteConfiguration.setKey_word(key_word);
		}
		if(null != describe && !"".equals(describe)) {
			siteConfiguration.setDescribe(describe);
		}
		
		siteService.insertSiteConfiguration(siteConfiguration);
		
		return "redirect:slist.do";
	}
	
	/**
	 * 通过id修改启用状态--启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/isstatusC.do")
	@ResponseBody
	public String isStatusC(Integer id) {
		
		//通过id修改站点配置的启用状态
		siteService.updateSiteCIsStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改禁用状态--禁用
	 * @param id
	 * @return
	 */
	@RequestMapping("/nostatusC.do")
	@ResponseBody
	public String noStatusC(Integer id) {
		
		//通过id修改站点配置的启用状态
		siteService.updateSiteCNoStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id删除基本设置
	 * @param id
	 * @return
	 */
	@RequestMapping("/delC.do")
	@ResponseBody
	public String delC(Integer id) {
		
		//通过id删除基本设置
		siteService.delSiteConfigurationById(id);
		
		return "ok";
	}
	
	/**
	 * 站点--站点设置编辑显示
	 */
	@RequestMapping("/editSiteC.do")
	public String editSiteC(Integer id, Model model){
		
		//通过id查询站点列表
		SiteConfiguration siteConfiguration = siteService.querySiteConfigurationById(id);
		
		model.addAttribute("siteConfiguration", siteConfiguration);
		
		return "/site/editSiteC";
	}
	
	/**
	 * 站点--站点设置编辑保存
	 */
	@RequestMapping("/updateSiteC.do")
	public String updateSiteC(Integer id, String title, String key_word, String describe, Model model){
		//通过id查询站点列表
		SiteConfiguration siteConfiguration = siteService.querySiteConfigurationById(id);
		//通过id更新基本配置
		SiteConfiguration siteC = new SiteConfiguration();
		siteC.setId(id);
		if(null == title || "".equals(title)) {
			siteC.setTitle(siteConfiguration.getTitle());
		}else {
			siteC.setTitle(title);
		}
		if(null == key_word || "".equals(key_word)) {
			siteC.setKey_word(siteConfiguration.getKey_word());
		}else {
			siteC.setKey_word(key_word);
		}
		if(null == describe || "".equals(describe)) {
			siteC.setDescribe(siteConfiguration.getDescribe());
		}else {
			siteC.setDescribe(describe);
		}
		
		siteService.updateSiteConfigurationById(siteC);
		
		return "redirect:slist.do";
	}
	
	
	
}
