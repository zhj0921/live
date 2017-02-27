package com.dongwei.kangbao.service;

import com.dongwei.kangbao.po.Gift;
import com.dongwei.kangbao.utils.page.Pagination;

public interface RoomService {

	/**
	 * 通过条件查询直播间列表
	 * @param userQuery
	 * @return
	 */
	public Pagination queryRoomByRoomQuery(String name, 
			Integer playbackstatus, String timeStart, String timeEnd, Integer pageNo);
	
	/**
	 * 通过id修改直播间的回放状态--启用回放
	 */
	public void updateRoomIsPlaybackstatusById(Integer id);
	
	/**
	 * 通过id修改直播间的回放状态--禁用回放
	 */
	public void updateRoomNoPlaybackstatusById(Integer id);
	
	/**
	 * 通过直播间id查询送礼物列表
	 */
	public Pagination queryGiveGiftListById(Integer id, Integer pageNo);
	
	
	/**
	 * 通过直播间id查询评论列表
	 */
	public Pagination queryCommentListById(Integer id, Integer pageNo);
	
	/**
	 * 通过直播间id查询回放列表
	 */
	public Pagination queryPlayBackListById(Integer id, Integer pageNo);
	
	/**
	 * 礼物列表
	 */
	public Pagination queryGiftmByGiftQuery(Integer specialeffects, Integer status, Integer pageNo);
	
	/**
	 * 修改礼物状态为启用
	 */
	public void updateGiftIsStatusById(Integer id);
	
	/**
	 * 修改礼物状态为启用
	 */
	public void updateGiftNoStatusById(Integer id);
	
	/**
	 * 删除礼物
	 */
	public void deleteGiftById(Integer id);
	
	/**
	 * 通过id查询礼物信息
	 */
	public Gift queryGiftById(Integer id);
	
	/**
	 * 通过id更新礼物
	 */
	public void updateGiftById(Gift gift);
	
	/**
	 * 添加礼物
	 */
	public void insertGift(Gift gift);
	
}
