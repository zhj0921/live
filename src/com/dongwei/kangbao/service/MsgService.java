package com.dongwei.kangbao.service;

import com.dongwei.kangbao.po.Message;
import com.dongwei.kangbao.utils.page.Pagination;

public interface MsgService {

	/**
	 * 通过条件查询直播间列表
	 * @param userQuery
	 * @return
	 */
	public Pagination queryMessageByMessageQuery(String timeStart, String timeEnd, Integer pageNo);
	
	/**
	 * 通过消息id查询消息详情
	 */
	public Message queryMessageById(Integer id);
	
	/**
	 * @Title: send
	 * @Description: 发送消息
	 */
	public String send(Message message) throws Exception;

	/**
	 * @Description: 保存消息
	 */
	public void save(Message message);

	
}
