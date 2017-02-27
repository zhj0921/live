package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.SiteConfiguration;
import com.dongwei.kangbao.po.SiteSettings;



/** 
 * 用户mapper
 */
public interface SiteMapper {

	
	/**
	 * 查询基本配置
	 */
	List<SiteSettings> querySiteSettings();
	
	/**
	 * 通过id修改基本配置状态--启用
	 */
	void updateSiteIsStatusById(Integer id);
	
	/**
	 * 通过id修改基本配置状态--禁用
	 */
	void updateSiteNoStatusById(Integer id);
	
	/**
	 * 通过id删除基本配置
	 */
	void delSiteSettingsById(Integer id);
	
	/**
	 * 通过id查询基本配置信息
	 */
	SiteSettings querySiteSettingsById(Integer id);
	
	/**
	 * 更新基本站点配置
	 */
	void updateSiteSettingsById(SiteSettings siteSettings);
	
	/**
	 * 添加基本站点配置
	 */
	void insertSiteSettings(SiteSettings siteSettings);
	
	
	/**
	 * 查询站点配置
	 */
	List<SiteConfiguration> querySiteConfiguration();
	
	/**
	 * 添加站点配置
	 */
	void insertSiteConfiguration(SiteConfiguration siteConfiguration);
	
	/**
	 * 通过id修改基本配置状态--启用
	 */
	void updateSiteCIsStatusById(Integer id);
	
	/**
	 * 通过id修改基本配置状态--禁用
	 */
	void updateSiteCNoStatusById(Integer id);
	
	/**
	 * 通过id删除基本配置
	 */
	void delSiteConfigurationById(Integer id);
	
	/**
	 * 通过id查询站点配置
	 */
	SiteConfiguration querySiteConfigurationById(Integer id);
	
	/**
	 * 更新站点配置
	 */
	void updateSiteConfigurationById(SiteConfiguration siteConfiguration);
	
}
