package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.SysMapper;
import com.dongwei.kangbao.po.Androidversion;
import com.dongwei.kangbao.po.AndroidversionQuery;
import com.dongwei.kangbao.service.SysService;
import com.dongwei.kangbao.utils.page.Pagination;

@Service
public class SysServiceImpl implements SysService {

	@Resource
	private SysMapper sysMapper;
	/**
	 * 列表查询
	 */
	@Override
	public Pagination queryAndroidByAndroidQuery(Integer pageNo) {
		//创建UserQuery查询对象
		AndroidversionQuery androidQuery = new AndroidversionQuery();
		
		
		androidQuery.setPageSize(15);
		androidQuery.setPageNo(Pagination.cpn(pageNo));
		List <Androidversion> list =  sysMapper.queryAndroidByAndroidQuery(androidQuery);
		int totalCount = sysMapper.queryAndroidCountByAndroidQuery(androidQuery);
		Pagination pagination = new Pagination(androidQuery.getPageNo(),androidQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/system/list.do";
		pagination.pageView(url, null);
		return pagination;
	}
	
	/**
	 * 添加
	 */
	@Override
	public void addAndroid(Androidversion androidversion) {
		sysMapper.addAndroid(androidversion);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteAndroidById(Integer id) {
		sysMapper.deleteAndroidById(id);
	}
	
	

}
