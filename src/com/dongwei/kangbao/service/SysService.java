package com.dongwei.kangbao.service;

import com.dongwei.kangbao.po.Androidversion;
import com.dongwei.kangbao.utils.page.Pagination;

public interface SysService {

	/**
	 * 
	 * @Title: queryAndroidByAndroidQuery
	 * @Description: 列表查询
	 * 
	 * @return
	 * @return List<>
	 * @throws
	 */
	public Pagination queryAndroidByAndroidQuery(Integer pageNo);
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加
	 * @param androidversion
	 * @return void
	 * @throws
	 */
	public void addAndroid(Androidversion androidversion);

	/**
	 * 
	 * @Title: deleteAndroidById
	 * @Description: 删除
	 * @param id
	 * @return void
	 * @throws
	 */
	public void deleteAndroidById(Integer id);

	
	
}
