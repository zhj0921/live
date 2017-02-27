package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Message;
import com.dongwei.kangbao.po.MessageQuery;



/** 
 * 用户mapper
 */
public interface MsgMapper {

	
	/**
	 * 通过条件查询消息列表并分页
	 */
	List<Message> queryMessageByMessageQuery(MessageQuery messageQuery);
	
	/**
	 * 通过条件查询消息列表的总条数
	 */
	int queryMessageCountByMessageQuery(MessageQuery messageQuery);
	
	/**
	 * 通过消息id查询消息详情
	 */
	Message queryMessageById(Integer id);
	
	/**
	 * 保存消息
	 */
	void save(Message message);
	
	
}
