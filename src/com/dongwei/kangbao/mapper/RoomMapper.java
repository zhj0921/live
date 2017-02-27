package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.Comment;
import com.dongwei.kangbao.po.Gift;
import com.dongwei.kangbao.po.GiftQuery;
import com.dongwei.kangbao.po.GivingGifts;
import com.dongwei.kangbao.po.PlayBack;
import com.dongwei.kangbao.po.Room;
import com.dongwei.kangbao.po.RoomQuery;
import com.dongwei.kangbao.po.UserInfo;



/** 
 * 用户mapper
 */
public interface RoomMapper {

	
	/**
	 * 通过条件查询直播间列表并分页
	 */
	List<Room> queryRoomByRoomQuery(RoomQuery roomQuery);
	
	/**
	 * 通过条件查询用户列表的总条数
	 */
	int queryRoomCountByRoomQuery(RoomQuery roomQuer);
	
	/**
	 * 通过id修改直播间的回放状态--启用回放
	 */
	void updateRoomIsPlaybackstatusById(Integer id);
	
	/**
	 * 通过id修改直播间的回放状态--禁用回放
	 */
	void updateRoomNoPlaybackstatusById(Integer id);
	
	/**
	 * 通过直播间id查询送礼物列表
	 */
	List<GivingGifts> queryGiveGiftListById(RoomQuery roomQuery);
	
	/**
	 * 通过直播间id查询送礼物列表数量
	 */
	int queryGiveGiftCountById(RoomQuery roomQuery);
	
	/**
	 * 通过直播间id查询评论列表
	 */
	List<Comment> queryCommentListById(RoomQuery roomQuery);
	
	/**
	 * 通过直播间id查询评论数量
	 */
	int queryCommentCountById(RoomQuery roomQuery);
	
	/**
	 * 通过直播间id查询回放列表
	 */
	List<PlayBack> queryPlayBackListById(RoomQuery roomQuery);
	
	/**
	 * 通过直播间id查询回放列表的数量
	 */
	int queryPlayBackCountById(RoomQuery roomQuery);
	
	/**
	 * 通过条件查询礼物列表
	 */
	List<Gift> queryGiftListById(GiftQuery giftQuery);
	
	/**
	 * 通过条件查询礼物列表的个数
	 */
	int queryGiftCountById(GiftQuery giftQuery);
	
	/**
	 * 修改礼物状态为启用
	 */
	void updateGiftIsStatusById(Integer id);
	
	/**
	 * 修改礼物状态为启用
	 */
	void updateGiftNoStatusById(Integer id);
	
	/**
	 * 删除礼物
	 */
	void deleteGiftById(Integer id);
	
	/**
	 * 通过id查询礼物信息
	 */
	Gift queryGiftById(Integer id);
	
	/**
	 * 通过id更新礼物
	 */
	void updateGiftById(Gift gift);
	
	/**
	 * 添加礼物
	 */
	void insertGift(Gift gift);
	
	/**
	 * 通过用户id查询用户名称
	 */
	UserInfo queryUserInfoByUId(Integer id);
	
	
}
