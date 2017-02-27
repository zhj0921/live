package com.dongwei.kangbao.service;

import java.util.List;

import com.dongwei.kangbao.po.SiteConfiguration;
import com.dongwei.kangbao.po.SiteSettings;

public interface SiteService {

	/**
	 * 通过条件查询直播间列表并分页
	 */
	public List<SiteSettings> querySiteSettings();
	
	/**
	 * 通过id修改基本配置状态--启用
	 */
	public void updateSiteIsStatusById(Integer id);
	
	/**
	 * 通过id修改基本配置状态--禁用
	 */
	public void updateSiteNoStatusById(Integer id);
	
	/**
	 * 通过id删除基本配置
	 */
	public void delSiteSettingsById(Integer id);
	
	/**
	 * 通过id查询基本配置信息
	 */
	public SiteSettings querySiteSettingsById(Integer id);
	
	/**
	 * 更新基本站点配置
	 */
	public void updateSiteSettingsById(SiteSettings siteSettings);
	
	/**
	 * 添加基本站点配置
	 */
	public void insertSiteSettings(SiteSettings siteSettings);
	
	/**
	 * 查询站点配置
	 */
	public List<SiteConfiguration> querySiteConfiguration();
	
	/**
	 * 添加站点配置
	 */
	public void insertSiteConfiguration(SiteConfiguration siteConfiguration);
	
	/**
	 * 通过id修改站点配置状态--启用
	 */
	public void updateSiteCIsStatusById(Integer id);
	
	/**
	 * 通过id修改站点配置状态--禁用
	 */
	public void updateSiteCNoStatusById(Integer id);
	
	/**
	 * 通过id删除站点配置
	 */
	public void delSiteConfigurationById(Integer id);
	
	/**
	 * 通过id查询站点配置
	 */
	public SiteConfiguration querySiteConfigurationById(Integer id);
	
	/**
	 * 更新站点配置
	 */
	public void updateSiteConfigurationById(SiteConfiguration siteConfiguration);
	
	
}
