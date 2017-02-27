package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Androidversion;
import com.dongwei.kangbao.po.AndroidversionQuery;


public interface SysMapper {

	/**
	 * 
	 * @Title: queryAndroidByAndroidQuery
	 * @Description: 根据查询条件查询
	 * @param androidversionQuery
	 * @return
	 * @return List<Androidversion>
	 * @throws
	 */
	List<Androidversion> queryAndroidByAndroidQuery(AndroidversionQuery androidversionQuery);

	/**
	 * 
	 * @Title: queryAndroidCountByAndroidQuery
	 * @Description: 根据查询条件查询符合的
	 * @param androidversionQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryAndroidCountByAndroidQuery(AndroidversionQuery androidversionQuery);

	/**
	 * 
	 * @Title: add
	 * @Description: 添加
	 * @param androidversion
	 * @return void
	 * @throws
	 */
	void addAndroid(Androidversion androidversion);

	/**
	 * 
	 * @Title: deleteAndroidById
	 * @Description: 删除
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleteAndroidById(Integer id);

	

	

}
