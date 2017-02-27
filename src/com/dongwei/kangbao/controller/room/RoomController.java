package com.dongwei.kangbao.controller.room;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dongwei.kangbao.po.Gift;
import com.dongwei.kangbao.service.RoomService;
import com.dongwei.kangbao.utils.TimeUtils;
import com.dongwei.kangbao.utils.UploadFileUtils;
import com.dongwei.kangbao.utils.page.Pagination;

@Controller
@RequestMapping("/room")
public class RoomController {

	@Resource
	private RoomService roomService;
	
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
	public String list(String name, Integer playbackstatus, String timeStart, String timeEnd, Integer pageNo, Model model){
		
		
		//通过条件查询直播间列表
		Pagination pagination = roomService.queryRoomByRoomQuery(name, playbackstatus, timeStart, timeEnd, pageNo);
		
		
		model.addAttribute("name", name);
		model.addAttribute("playbackstatus", playbackstatus);
		model.addAttribute("timeStart", timeStart);
		model.addAttribute("timeEnd", timeEnd);
		model.addAttribute("pageNo", pageNo);
		//将返回的数据添加到list集合中
		model.addAttribute("pagination", pagination);
		
		return "/room/list";
	}
	
	/**
	 * 通过id修改启用状态--启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/isplaybackstatus.do")
	@ResponseBody
	public String isPlaybackstatus(Integer id) {
		
		//通过用户的id修改用户的启用状态
		roomService.updateRoomIsPlaybackstatusById(id);
		
		return "ok";
	}
	
	/**
	 * 通过id修改禁用状态--禁用
	 * @param id
	 * @return
	 */
	@RequestMapping("/noplaybackstatus.do")
	@ResponseBody
	public String noPlaybackstatus(Integer id) {
		
		//通过用户的id修改用户的启用状态
		roomService.updateRoomNoPlaybackstatusById(id);
		
		return "ok";
	}
	
	
	/**
	 * 查看直播间详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/look.do")
	public String look(Integer id, Integer pageNo, Model model) {
		
		//通过直播间id查询礼物列表
		Pagination giveGift = roomService.queryGiveGiftListById(id, pageNo);
		//通过直播间id查询评论列表
		Pagination comment = roomService.queryCommentListById(id, pageNo);
		//通过直播间id查询回放列表
		Pagination playBack = roomService.queryPlayBackListById(id, pageNo);
		
		model.addAttribute("pageNo", pageNo);
		//将返回的数据添加到list集合中
		model.addAttribute("giveGift", giveGift);
		model.addAttribute("comment", comment);
		model.addAttribute("playBack", playBack);
		
		return "/room/look";
	}
	
	
	/**
	 * 礼物列表
	 * @param specialeffects
	 * @param status
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("/giftList.do")
	public String giftList(Integer specialeffects, Integer status, Integer pageNo, Model model){
		
		//通过条件查询直播间列表
		Pagination pagination = roomService.queryGiftmByGiftQuery(specialeffects, status, pageNo);
		
		model.addAttribute("specialeffects", specialeffects);
		model.addAttribute("status", status);
		model.addAttribute("pageNo", pageNo);
		//将返回的数据添加到list集合中
		model.addAttribute("pagination", pagination);
		
		return "/gift/list";
	}
	
	/**
	 * 启用礼物
	 */
	@RequestMapping("/enabledGift.do")
	@ResponseBody
	public String enabledGift(Integer id) {
		//通过用户的id修改用户的启用状态
		roomService.updateGiftIsStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 禁用礼物
	 */
	@RequestMapping("/disableGift.do")
	@ResponseBody
	public String disableGift(Integer id) {
		//通过用户的id修改用户的启用状态
		roomService.updateGiftNoStatusById(id);
		
		return "ok";
	}
	
	/**
	 * 删除礼物
	 */
	@RequestMapping("/deleteGift.do")
	@ResponseBody
	public String deleteGift(Integer id) {
		//通过用户的id修改用户的启用状态
		roomService.deleteGiftById(id);
		
		return "ok";
	}
	
	/**
	 * 更新回显
	 * @param id
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/editGift.do")
	@ResponseBody
	public Gift editGift(Integer id, HttpServletResponse response, Model model){
		//通过id查询护理类型
		Gift gift = roomService.queryGiftById(id);
		return gift;
	}
	
	/**
	 * 更新礼物
	 */
	@RequestMapping("/editSaveGift.do")
	public String  editSaveGift(Gift gift,HttpServletRequest request) throws Exception{
		MultipartFile pic = gift.getPic();
		//通过id查询礼物信息
		Gift gift2 = roomService.queryGiftById(gift.getId());
		if(null == pic || pic.getSize()<=0) {
			gift.setGiftpicture(gift2.getGiftpicture());
		}else {
			String uploadFile = UploadFileUtils.uploadFile(pic, request);
			gift.setGiftpicture(uploadFile);
		}
		
		roomService.updateGiftById(gift);
		
		return "redirect:giftList.do";
	}
	
	/**
	 * 删除礼物
	 */
	@RequestMapping("/addGift.do")
	@ResponseBody
	public String addGift(Gift gift, HttpServletRequest request) throws Exception {
		MultipartFile pic = gift.getPic();
		String uploadFile = UploadFileUtils.uploadFile(pic, request);
		gift.setGiftpicture(uploadFile);
		gift.setAddtime(TimeUtils.getCurentTimeStamp());
		//添加礼物
		roomService.insertGift(gift);
		return "ok";
	}
	
	
	/**
	 * 通过id查询礼物详情
	 */
	@RequestMapping("/queryGift.do")
	@ResponseBody
	public String queryGift(Integer id) {
		return "gift";
	}
	
	
}
