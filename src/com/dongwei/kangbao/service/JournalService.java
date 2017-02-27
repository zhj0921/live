package com.dongwei.kangbao.service;

import com.dongwei.kangbao.utils.page.Pagination;

public interface JournalService {

	
	/**
	 * 
	 * @Title: delMessageById
	 * @Description: 删除
	 * @param id
	 * @return void
	 * @throws
	 */
	public void delJournalById(Integer id);


	/**
	 * 
	 * @Title: journalLoginLogs
	 * @Description: 添加登录日志
	 * @param loginTime
	 * @param id
	 * @param adminname
	 * @return void
	 * @throws
	 */
	public void journalLoginLogs(Integer loginTime,  Integer id, String adminName);

	/**
	 * 
	 * @Title: journalLogs
	 * @Description: 添加操作日志
	 * @param id
	 * @param adminname
	 * @param valueOf
	 * @param string
	 * @param string2
	 * @return void
	 * @throws
	 */
	public void journalOperationLogs(Integer adminId, String adminName, Integer operationTime, String operationPath, String operationExplain);

	/**
	 * 
	 * @Title: queryOperationJournalByJournalQuery
	 * @Description: 查询操作日志列表
	 * @param pageNo
	 * @return
	 * @return Pagination
	 * @throws
	 */
	public Pagination queryOperationJournalByJournalQuery(Integer pageNo);

	/**
	 * 
	 * @Title: queryLoginJournalByJournalQuery
	 * @Description: 查询登录日志列表
	 * @param pageNo
	 * @return
	 * @return Pagination
	 * @throws
	 */
	public Pagination queryLoginJournalByJournalQuery(Integer pageNo);


	/**
	 * 
	 * @Title: deleteJournals
	 * @Description: 登录日志批量删除
	 * @param ids
	 * @return void
	 * @throws
	 */
	public void deleteJournals(Integer[] ids);

	
	
}
