package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.MsgMapper;
import com.dongwei.kangbao.mapper.UserMapper;
import com.dongwei.kangbao.po.Message;
import com.dongwei.kangbao.po.MessageQuery;
import com.dongwei.kangbao.po.UserDetails;
import com.dongwei.kangbao.service.MsgService;
import com.dongwei.kangbao.utils.TimeUtils;
import com.dongwei.kangbao.utils.page.Pagination;
import com.dongwei.kangbao.utils.send.AndroidBroadcast;
import com.dongwei.kangbao.utils.send.AndroidNotification;
import com.dongwei.kangbao.utils.send.PushClient;

@Service
public class MsgServiceImpl implements MsgService {

	@Resource
	private MsgMapper msgMapper;
	@Resource
	private UserMapper userMapper;
	
	/**
	 * 通过条件查询直播间列表
	 * @param userQuery
	 * @return
	 */
	public Pagination queryMessageByMessageQuery(String timeStart, String timeEnd, Integer pageNo) {
		
		// 创建OrderQuery查询对象
		MessageQuery messageQuery = new MessageQuery();

		StringBuilder params = new StringBuilder();
		// 添加条件
		if(timeStart != null && timeStart != "") {
			messageQuery.setTimeStart(TimeUtils.date2TimeStamp(timeStart, "yyyy-MM-dd HH:mm:ss"));
			params.append("timeStart=").append(timeStart);
		}
		if(timeEnd != null && timeEnd != "") {
			messageQuery.setTimeEnd(TimeUtils.date2TimeStamp(timeEnd, "yyyy-MM-dd HH:mm:ss"));
			params.append("&timeEnd=").append(timeEnd);
		}

		messageQuery.setPageSize(15);
		messageQuery.setPageNo(Pagination.cpn(pageNo));

		List<Message> list = msgMapper.queryMessageByMessageQuery(messageQuery);
		
		for (Message message : list) {
			if(null != message.getUid() && message.getUid()!=0) {
				//通过用户id查询用户名称
				UserDetails userDetails = userMapper.queryUserDetailsById(message.getUid());
				message.setUserName(userDetails.getNickname());
			}
		}
		
		int totalCount = msgMapper.queryMessageCountByMessageQuery(messageQuery);
		Pagination pagination = new Pagination(messageQuery.getPageNo(), messageQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/message/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
		
	}
	
	/**
	 * 通过消息id查询消息详情
	 */
	public Message queryMessageById(Integer id) {
		
		 Message message = msgMapper.queryMessageById(id);
		 
		 if(null != message.getUid() && message.getUid()!=0) {
				//通过用户id查询用户名称
				UserDetails userDetails = userMapper.queryUserDetailsById(message.getUid());
				message.setUserName(userDetails.getNickname());
			}
		 
		 return message;
		 
	}
	
	
	/**
	 * 发送消息
	 * @throws Exception 
	 */
	@Override
	public String send(Message message) throws Exception {
		
		
		PushClient client = new PushClient();
		Integer shopOrUser = message.getUtype();
		AndroidBroadcast broadcast = new AndroidBroadcast("57e8fa3667e58e8237003b29","eqa9hr0njse9veyoyjwtl4luhn4h1xik");
		//List<String> userList = userMapper.findUserToken();
		//List<String> shopList = shopMapper.findShopToken();
		String send = null;
		if(shopOrUser==1){//用户
			broadcast.setTicker( "消息");
			broadcast.setTitle(message.getTitle());//中文的title
			broadcast.setText(message.getContent());//广播的内容
			broadcast.goAppAfterOpen();//在打开app之后
			broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);//显示类型
			broadcast.setProductionMode();//产生模式 正式模式
			// Set customized fields
			broadcast.setExtraField("test", "helloworld");
			//broadcast.customized("test", "helloworld");
			send = client.send(broadcast);
			
		}else if(shopOrUser==2){//商户
			broadcast.setTicker( "消息");
			broadcast.setTitle(message.getTitle());//中文的title
			broadcast.setText(message.getContent());//广播的内容
			broadcast.goAppAfterOpen();//在打开app之后
			broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);//显示类型
			broadcast.setTestMode();//测试模式
			// Set customized fields
			broadcast.setExtraField("test", "helloworld");
			send = client.send(broadcast);	
		}
		return send;
		
		
	}

	/**
	 * 保存消息
	 */
	@Override
	public void save(Message message) {
		String curentTime = TimeUtils.getCurentTime();
		Integer date2TimeStamp = TimeUtils.date2TimeStamp(curentTime, null);
		message.setAddtime(date2TimeStamp);
		msgMapper.save(message);
	}
	
	
}
