package com.dongwei.kangbao.controller.feedBack;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongwei.kangbao.po.FeedBackType;
import com.dongwei.kangbao.service.FeedBackService;
import com.dongwei.kangbao.utils.page.Pagination;

/** 
 * @ClassName: FeedBackController
 * @Company: http://www.dongwei.com/
 * @Description: 反馈Controller
 * @author h 
 * @date 2016年12月14日 上午11:09:44  
 */
@Controller
@RequestMapping("/feedback")
public class FeedBackController {

	
	@Resource
	private FeedBackService feedBackService;
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: list
	 * @Description: 列表查询
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/list.do")
	public String list(HttpServletRequest request,String timeStartu,String timeEndu,Integer pageNou,Integer statusu,
			String timeStarts,String timeEnds,Integer pageNos,Integer statuss,Model model) {
		//调用service执行查询
		//用户反馈
		Pagination paginationu = feedBackService.queryFeedBackUByFeedBackUQuery(timeStartu,timeEndu,pageNou,statusu);
		model.addAttribute("paginationu", paginationu);
		model.addAttribute("pageNou", pageNou);
		model.addAttribute("timeStartu", timeStartu);
		model.addAttribute("timeEndu", timeEndu);
		model.addAttribute("statusu", statusu);
		//商户反馈
		Pagination paginations = feedBackService.queryFeedBackSByFeedBackSQuery(timeStarts,timeEnds,pageNos,statuss);
		model.addAttribute("paginations", paginations);
		model.addAttribute("pageNos", pageNos);
		model.addAttribute("timeStarts", timeStarts);
		model.addAttribute("timeEnds", timeEnds);
		model.addAttribute("statuss", statuss);
		return "/feedback/list";
	}
	
	
	/**
	 * @Title: delete
	 * @Description: 删除操作
	 * @param 
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public String delete(Integer id ,HttpServletRequest request){
		feedBackService.deleteFeedBackById(id);
		return "ok";
	}
	
	/**
	 * 
	 * @Title: handle
	 * @Description: 反馈确认处理操作
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/handle.do")
	@ResponseBody
	public String handle(Integer id,HttpServletRequest request){
		feedBackService.handleFeedBackById(id);
		return "ok";
	}
	
	
	/**
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Title: list
	 * @Description: 列表查询
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/typelist.do")
	public String list(Integer pageNo, Model model) {
		//调用service执行查询
		Pagination pagination = feedBackService.queryFeedBackTypeByFeedBackTypeQuery(pageNo);
		
	    model.addAttribute("pageNo", pageNo);
		//将数据放入list中
	    model.addAttribute("pagination", pagination);
		
		return "/feedback/feedbacktype";
	}
	
	/**
	 * 
	 * @Title: disable
	 * @Description: 禁用
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/disable.do")
	@ResponseBody
	public String disable(Integer id){
		feedBackService.disableFeedBackTypeById(id);
		return "ok";
	}
	
	/**
	 * 
	 * @Title: enabled
	 * @Description: 启用
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/enabled.do")
	@ResponseBody
	public String enabled(Integer id){
		feedBackService.enabledFeedBackTypeById(id);
		return "ok";
	}
	/**
	 * 
	 * @Title: dele
	 * @Description: 删除
	 * @param id
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/dele.do")
	@ResponseBody
	public String dele(Integer id){
		feedBackService.delFeedBackTypeById(id);
		return "ok";
	}
	
	/**
	 * 
	 * @Title: add
	 * @Description: 添加成功
	 * @param invoice
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/add.do")
	public String add(FeedBackType feedBackType){
		feedBackService.addFeedBackType(feedBackType);
		return "redirect:typelist.do";
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: 保存
	 * @param invoice
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/update.do")
	public String update(FeedBackType feedBackType){
		feedBackService.updateFeedBackType(feedBackType);
		return "redirect:typelist.do";
	}
	
	/**
	 * 
	 * @Title: edit
	 * @Description: 修改
	 * @param id
	 * @param model
	 * @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/edit.do")
	public String edit(Integer id,Model model){
		FeedBackType feedBackType =  feedBackService.findFeedBackTypeById(id);
		model.addAttribute("feedBackType", feedBackType);
		return "/feedback/edit";
	}
	
	
	
	
}
