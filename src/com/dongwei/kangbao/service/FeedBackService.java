package com.dongwei.kangbao.service;

import com.dongwei.kangbao.po.FeedBackType;
import com.dongwei.kangbao.utils.page.Pagination;

/** 
 * @ClassName: FeedBackService
 * @Company: http://www.dongwei.com/
 * @Description: 反馈service
 * @author h 
 * @date 2016年12月14日 上午11:12:48  
 */
public interface FeedBackService {

	/**
	 * 
	 * @Title: queryFeedBackUByFeedBackUQuery
	 * @Description:  用户反馈列表查询
	 * @param timeStartu
	 * @param timeEndu
	 * @param pageNou
	 * @param statusu
	 * @return
	 * @return Pagination
	 * @throws
	 */
	Pagination queryFeedBackUByFeedBackUQuery(String timeStartu, String timeEndu, Integer pageNou, Integer statusu);

	/**
	 * 
	 * @Title: queryFeedBackSByFeedBackSQuery
	 * @Description: 商户反馈
	 * @param timeStarts
	 * @param timeEnds
	 * @param pageNos
	 * @param statuss
	 * @return
	 * @return Pagination
	 * @throws
	 */
	Pagination queryFeedBackSByFeedBackSQuery(String timeStarts, String timeEnds, Integer pageNos, Integer statuss);

	/**
	 * 
	 * @Title: deleteFeedBackById
	 * @Description: 根据id删除
	 * @param id
	 * @return void
	 * @throws
	 */
	void deleteFeedBackById(Integer id);

	/**
	 * 
	 * @Title: handleFeedBackById
	 * @Description: 反馈确认处理操作
	 * @param id
	 * @return void
	 * @throws
	 */
	void handleFeedBackById(Integer id);

	
	/**
	 * 
	 * @Title: queryFeedBackTypeByFeedBackTypeQuery
	 * @Description: 反馈类别查询
	 * @param pageNo
	 * @return
	 * @return Pagination
	 * @throws
	 */
	Pagination queryFeedBackTypeByFeedBackTypeQuery(Integer pageNo);

	/**
	 * 
	 * @Title: disableFeedBackTypeById
	 * @Description: 反馈类别禁用
	 * @param id
	 * @return void
	 * @throws
	 */
	void disableFeedBackTypeById(Integer id);

	/**
	 * 
	 * @Title: enabledFeedBackTypeById
	 * @Description:  反馈类别启用
	 * @param id
	 * @return void
	 * @throws
	 */
	void enabledFeedBackTypeById(Integer id);

	/**
	 * 
	 * @Title: delFeedBackTypeById
	 * @Description: 反馈类别删除
	 * @param id
	 * @return void
	 * @throws
	 */
	void delFeedBackTypeById(Integer id);

	/**
	 * 
	 * @Title: addFeedBackType
	 * @Description: 反馈类别添加
	 * @param feedBackType
	 * @return void
	 * @throws
	 */
	void addFeedBackType(FeedBackType feedBackType);

	/**
	 * 
	 * @Title: updateFeedBackType
	 * @Description: 反馈类别更新
	 * @param feedBackType
	 * @return void
	 * @throws
	 */
	void updateFeedBackType(FeedBackType feedBackType);

	/**
	 * 
	 * @Title: findFeedBackTypeById
	 * @Description: 修改反馈类别
	 * @param id
	 * @return
	 * @return FeedBackType
	 * @throws
	 */
	FeedBackType findFeedBackTypeById(Integer id);

	

}
