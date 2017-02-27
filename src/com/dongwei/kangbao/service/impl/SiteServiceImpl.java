package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.SiteMapper;
import com.dongwei.kangbao.po.SiteConfiguration;
import com.dongwei.kangbao.po.SiteSettings;
import com.dongwei.kangbao.service.SiteService;

@Service
public class SiteServiceImpl implements SiteService {

	@Resource
	private SiteMapper siteMapper;

	/**
	 * 通过条件查询直播间列表并分页
	 */
	@Override
	public List<SiteSettings> querySiteSettings() {
		return siteMapper.querySiteSettings();
	}
	
	/**
	 * 通过id修改基本配置状态--启用
	 */
	public void updateSiteIsStatusById(Integer id) {
		siteMapper.updateSiteIsStatusById(id);
	}
	
	/**
	 * 通过id修改基本配置状态--禁用
	 */
	public void updateSiteNoStatusById(Integer id) {
		siteMapper.updateSiteNoStatusById(id);
	}
	
	/**
	 * 通过id删除基本配置
	 */
	public void delSiteSettingsById(Integer id) {
		siteMapper.delSiteSettingsById(id);
	}
	
	/**
	 * 通过id查询基本配置信息
	 */
	public SiteSettings querySiteSettingsById(Integer id) {
		return siteMapper.querySiteSettingsById(id);
	}
	
	/**
	 * 更新基本站点配置
	 */
	public void updateSiteSettingsById(SiteSettings siteSettings) {
		siteMapper.updateSiteSettingsById(siteSettings);
	}
	
	/**
	 * 添加基本站点配置
	 */
	public void insertSiteSettings(SiteSettings siteSettings) {
		siteMapper.insertSiteSettings(siteSettings);
	}
	
	
	/**
	 * 查询站点配置
	 */
	public List<SiteConfiguration> querySiteConfiguration() {
		return siteMapper.querySiteConfiguration();
	}
	
	/**
	 * 添加站点配置
	 */
	public void insertSiteConfiguration(SiteConfiguration siteConfiguration) {
		siteMapper.insertSiteConfiguration(siteConfiguration);
	}
	
	/**
	 * 通过id修改站点配置状态--启用
	 */
	public void updateSiteCIsStatusById(Integer id) {
		siteMapper.updateSiteCIsStatusById(id);
	}
	
	/**
	 * 通过id修改站点配置状态--禁用
	 */
	public void updateSiteCNoStatusById(Integer id) {
		siteMapper.updateSiteCNoStatusById(id);
	}
	
	/**
	 * 通过id删除站点配置
	 */
	public void delSiteConfigurationById(Integer id) {
		siteMapper.delSiteConfigurationById(id);
	}
	
	/**
	 * 通过id查询站点配置
	 */
	public SiteConfiguration querySiteConfigurationById(Integer id) {
		return siteMapper.querySiteConfigurationById(id);
	}
	
	/**
	 * 更新站点配置
	 */
	public void updateSiteConfigurationById(SiteConfiguration siteConfiguration) {
		siteMapper.updateSiteConfigurationById(siteConfiguration);
	}
	
		
}
