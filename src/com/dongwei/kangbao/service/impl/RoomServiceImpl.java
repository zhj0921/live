package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.RoomMapper;
import com.dongwei.kangbao.po.Comment;
import com.dongwei.kangbao.po.Gift;
import com.dongwei.kangbao.po.GiftQuery;
import com.dongwei.kangbao.po.GivingGifts;
import com.dongwei.kangbao.po.PlayBack;
import com.dongwei.kangbao.po.Room;
import com.dongwei.kangbao.po.RoomQuery;
import com.dongwei.kangbao.po.UserInfo;
import com.dongwei.kangbao.service.RoomService;
import com.dongwei.kangbao.utils.TimeUtils;
import com.dongwei.kangbao.utils.page.Pagination;

@Service
public class RoomServiceImpl implements RoomService {

	@Resource
	private RoomMapper roomMapper;
	
	/**
	 * 通过条件查询直播间列表
	 * @param userQuery
	 * @return
	 */
	public Pagination queryRoomByRoomQuery(String name, 
			Integer playbackstatus, String timeStart, String timeEnd, Integer pageNo) {
		
		// 创建OrderQuery查询对象
		RoomQuery roomQuery = new RoomQuery();

		StringBuilder params = new StringBuilder();
		// 添加条件
		if (name != null && name != "") {
			roomQuery.setUserName(name);
			params.append("name=").append(name);
		}
		if (playbackstatus != null && playbackstatus != 2) {
			roomQuery.setPlaybackstatus(playbackstatus);
			params.append("&playbackstatus=").append(playbackstatus);
		}
		if(timeStart != null && timeStart != "") {
			roomQuery.setTimeStart(TimeUtils.date2TimeStamp(timeStart, "yyyy-MM-dd HH:mm:ss"));
			params.append("&timeStart=").append(timeStart);
		}
		if(timeEnd != null && timeEnd != "") {
			roomQuery.setTimeEnd(TimeUtils.date2TimeStamp(timeEnd, "yyyy-MM-dd HH:mm:ss"));
			params.append("&timeEnd=").append(timeEnd);
		}

		roomQuery.setPageSize(15);
		roomQuery.setPageNo(Pagination.cpn(pageNo));

		List<Room> list = roomMapper.queryRoomByRoomQuery(roomQuery);
		//通过用户id查询用户名称
		for (Room room : list) {
			UserInfo userInfo = roomMapper.queryUserInfoByUId(room.getId());
			room.setUserName(userInfo.getNickname());
		}
		int totalCount = roomMapper.queryRoomCountByRoomQuery(roomQuery);
		Pagination pagination = new Pagination(roomQuery.getPageNo(), roomQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/room/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
		
	}
	
	/**
	 * 通过id修改直播间的回放状态--启用回放
	 */
	public void updateRoomIsPlaybackstatusById(Integer id) {
		roomMapper.updateRoomIsPlaybackstatusById(id);
	}
	
	/**
	 * 通过id修改直播间的回放状态--禁用回放
	 */
	public void updateRoomNoPlaybackstatusById(Integer id) {
		roomMapper.updateRoomNoPlaybackstatusById(id);
	}
	
	/**
	 * 通过直播间id查询送礼物列表
	 */
	public Pagination queryGiveGiftListById(Integer id, Integer pageNo) {
		// 创建OrderQuery查询对象
		RoomQuery roomQuery = new RoomQuery();
		StringBuilder params = new StringBuilder();
		// 添加条件
		if (id != null && id != 0) {
			roomQuery.setId(id);
			params.append("id=").append(id);
		}
		roomQuery.setPageSize(15);
		roomQuery.setPageNo(Pagination.cpn(pageNo));

		List<GivingGifts> list = roomMapper.queryGiveGiftListById(roomQuery);
		int totalCount = roomMapper.queryGiveGiftCountById(roomQuery);
		Pagination pagination = new Pagination(roomQuery.getPageNo(), roomQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/room/look.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	/**
	 * 通过直播间id查询评论列表
	 */
	public Pagination queryCommentListById(Integer id, Integer pageNo) {
		// 创建OrderQuery查询对象
		RoomQuery roomQuery = new RoomQuery();
		StringBuilder params = new StringBuilder();
		// 添加条件
		if (id != null && id != 0) {
			roomQuery.setId(id);
			params.append("id=").append(id);
		}
		roomQuery.setPageSize(15);
		roomQuery.setPageNo(Pagination.cpn(pageNo));

		List<Comment> list = roomMapper.queryCommentListById(roomQuery);
		int totalCount = roomMapper.queryCommentCountById(roomQuery);
		Pagination pagination = new Pagination(roomQuery.getPageNo(), roomQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/room/look.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	/**
	 * 通过直播间id查询回放列表
	 */
	public Pagination queryPlayBackListById(Integer id, Integer pageNo) {
		// 创建OrderQuery查询对象
		RoomQuery roomQuery = new RoomQuery();
		StringBuilder params = new StringBuilder();
		// 添加条件
		if (id != null && id != 0) {
			roomQuery.setId(id);
			params.append("id=").append(id);
		}
		roomQuery.setPageSize(15);
		roomQuery.setPageNo(Pagination.cpn(pageNo));

		List<PlayBack> list = roomMapper.queryPlayBackListById(roomQuery);
		int totalCount = roomMapper.queryPlayBackCountById(roomQuery);
		Pagination pagination = new Pagination(roomQuery.getPageNo(), roomQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/room/look.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	/**
	 * 礼物列表
	 */
	public Pagination queryGiftmByGiftQuery(Integer specialeffects, Integer status, Integer pageNo) {
		// 创建OrderQuery查询对象
		GiftQuery giftQuery = new GiftQuery();
		StringBuilder params = new StringBuilder();
		// 添加条件
		if (specialeffects != null && specialeffects != 2) {
			giftQuery.setSpecialeffects(specialeffects);
			params.append("specialeffects=").append(specialeffects);
		}
		if (status != null && status != 2) {
			giftQuery.setStatus(status);
			params.append("&status=").append(status);
		}
		giftQuery.setPageSize(15);
		giftQuery.setPageNo(Pagination.cpn(pageNo));
		
		List<Gift> list = roomMapper.queryGiftListById(giftQuery);
		int totalCount = roomMapper.queryGiftCountById(giftQuery);
		Pagination pagination = new Pagination(giftQuery.getPageNo(), giftQuery.getPageSize(), totalCount, list);
		// 设置访问的url
		String url = "/gift/look.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	/**
	 * 修改礼物状态为启用
	 */
	public void updateGiftIsStatusById(Integer id) {
		roomMapper.updateGiftIsStatusById(id);
	}
	
	/**
	 * 修改礼物状态为启用
	 */
	public void updateGiftNoStatusById(Integer id) {
		roomMapper.updateGiftNoStatusById(id);
	}
	
	/**
	 * 删除礼物
	 */
	public void deleteGiftById(Integer id) {
		roomMapper.deleteGiftById(id);
	}
	
	/**
	 * 通过id查询礼物信息
	 */
	public Gift queryGiftById(Integer id) {
		return roomMapper.queryGiftById(id);
	}
	
	/**
	 * 通过id更新礼物
	 */
	public void updateGiftById(Gift gift) {
		roomMapper.updateGiftById(gift);
	}
	
	/**
	 * 添加礼物
	 */
	public void insertGift(Gift gift) {
		roomMapper.insertGift(gift);
	}
		
}
