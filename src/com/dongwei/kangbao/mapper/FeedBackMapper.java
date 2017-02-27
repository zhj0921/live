package com.dongwei.kangbao.mapper;

import java.util.List;

import com.dongwei.kangbao.po.FeedBack;
import com.dongwei.kangbao.po.FeedBackQuery;
import com.dongwei.kangbao.po.FeedBackType;

/** 
 * @ClassName: FeedBackMapper
 * @Company: http://www.dongwei.com/
 * @Description: 反馈mapper接口
 * @author h 
 * @date 2016年12月14日 上午11:50:11  
 */
public interface FeedBackMapper {

	/**
	 * 
	 * @Title: queryFeedBackUByFeedBackUQuery
	 * @Description: 用户反馈列表查询数据
	 * @param feedBackQuery
	 * @return
	 * @return List<FeedBack>
	 * @throws
	 */
	List<FeedBack> queryFeedBackUByFeedBackUQuery(FeedBackQuery feedBackQuery);

	/**
	 * 
	 * @Title: queryFeedBackUCountByFeedBackUQuery
	 * @Description: 用户反馈查询总数
	 * @param feedBackQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryFeedBackUCountByFeedBackUQuery(FeedBackQuery feedBackQuery);

	/**
	 * 
	 * @Title: queryFeedBackSByFeedBackSQuery
	 * @Description: 商户反馈列表查询
	 * @param feedBackQuery
	 * @return
	 * @return List<FeedBack>
	 * @throws
	 */
	List<FeedBack> queryFeedBackSByFeedBackSQuery(FeedBackQuery feedBackQuery);

	/**
	 * 
	 * @Title: queryFeedBackSCountByFeedBackSQuery
	 * @Description: 商户反馈查询总数
	 * @param feedBackQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryFeedBackSCountByFeedBackSQuery(FeedBackQuery feedBackQuery);

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
	 * @Description: 反馈类型列表查询数据
	 * @param feedBackQuery
	 * @return
	 * @return List<FeedBack>
	 * @throws
	 */
	List<FeedBackType> queryFeedBackTypeByFeedBackTypeQuery(FeedBackQuery feedBackQuery);

	/**
	 * 
	 * @Title: queryFeedBackTypeCountByFeedBackTypeQuery
	 * @Description: 反馈类型列表查询数据总数
	 * @param feedBackQuery
	 * @return
	 * @return int
	 * @throws
	 */
	int queryFeedBackTypeCountByFeedBackTypeQuery(FeedBackQuery feedBackQuery);

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
	 * @Description: 反馈类别启用
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
