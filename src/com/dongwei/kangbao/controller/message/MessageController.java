package com.dongwei.kangbao.controller.message;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.Message;
import com.dongwei.kangbao.service.MsgService;
import com.dongwei.kangbao.utils.page.Pagination;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource
	private MsgService msgService;
	
	/**
	 * 直播间列表
	 * @param name
	 * @param phone
	 * @param pageNo
	 * @param status
	 * @param model
	 * @return
	 */
	@RequestMapping("/list.do")
	public String list(String timeStart, String timeEnd, Integer pageNo, Model model){
		
		
		//通过条件查询消息列表
		Pagination pagination = msgService.queryMessageByMessageQuery(timeStart, timeEnd, pageNo);
		
		model.addAttribute("timeStart", timeStart);
		model.addAttribute("timeEnd", timeEnd);
		model.addAttribute("pageNo", pageNo);
		//将返回的数据添加到list集合中
		model.addAttribute("pagination", pagination);
		
		return "/message/list";
	}
	
	/**
	 * 查看消息详情
	 */
	@RequestMapping("/look.do")
	public String look(Integer id, Model model) {
		
		//通过消息id查询消息详情
		Message message = msgService.queryMessageById(id);
		
		model.addAttribute("message", message);
		
		return "/message/look";
	}
	
	
	/**
	 * @throws Exception 
	 * 
	 * @Title: send
	 * @Description: 发送消息
	 * @param message
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/send.do")
	@ResponseBody
	public String send(Message message) throws Exception{
		String send = msgService.send(message);
		return send;
	}
	
	/**
	 * @throws Exception 
	 * 
	 * @Title: send
	 * @Description: 发送消息
	 * @param message
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public String save(Message message) throws Exception{
		msgService.save(message);
		return "ok";
	}
	
}
