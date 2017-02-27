package com.dongwei.kangbao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dongwei.kangbao.mapper.FeedBackMapper;
import com.dongwei.kangbao.po.FeedBack;
import com.dongwei.kangbao.po.FeedBackQuery;
import com.dongwei.kangbao.po.FeedBackType;
import com.dongwei.kangbao.service.FeedBackService;
import com.dongwei.kangbao.utils.TimeUtils;
import com.dongwei.kangbao.utils.page.Pagination;

/** 
 * @ClassName: FeedBackServiceImpl
 * @Company: http://www.dongwei.com/
 * @Description: 反馈service实现类
 * @author h 
 * @date 2016年12月14日 上午11:13:38  
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Resource
	private FeedBackMapper feedBackMapper;
	/**
	 * 用户反馈列表查询
	 */
	@Override
	public Pagination queryFeedBackUByFeedBackUQuery(String timeStartu, String timeEndu, Integer pageNou,
			Integer statusu) {
		//创建Query查询对象
		FeedBackQuery feedBackQuery = new FeedBackQuery();
		//添加条件
		StringBuilder params = new StringBuilder();
		if (timeStartu!=null && timeStartu !="") {
			Integer date2TimeStamp = TimeUtils.date2TimeStamp(timeStartu, null);
			feedBackQuery.setTimeStart(date2TimeStamp);
			params.append("timeStartu=").append(timeStartu);
		}
		if (timeEndu!=null && timeEndu !="") {
			Integer date2TimeStamp = TimeUtils.date2TimeStamp(timeEndu, null);
			feedBackQuery.setTimeEnd(date2TimeStamp);
			params.append("&timeEndu=").append(timeEndu);
		}
		if (statusu!=null && statusu!= 0) {
			feedBackQuery.setStatus(statusu);
			params.append("&statusu=").append(statusu);
		}
		
		feedBackQuery.setPageSize(15);
		feedBackQuery.setPageNo(Pagination.cpn(pageNou));
		List <FeedBack> list =  feedBackMapper.queryFeedBackUByFeedBackUQuery(feedBackQuery);
		int totalCount = feedBackMapper.queryFeedBackUCountByFeedBackUQuery(feedBackQuery);
		Pagination pagination = new Pagination(feedBackQuery.getPageNo(),feedBackQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/feedback/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	/**
	 * 商户反馈列表查询
	 */
	@Override
	public Pagination queryFeedBackSByFeedBackSQuery(String timeStarts, String timeEnds, Integer pageNos,
			Integer statuss) {
		//创建Query查询对象
		FeedBackQuery feedBackQuery = new FeedBackQuery();
		//添加条件
		StringBuilder params = new StringBuilder();
		if (timeStarts!=null && timeStarts !="") {
			Integer date2TimeStamp = TimeUtils.date2TimeStamp(timeStarts, null);
			feedBackQuery.setTimeStart(date2TimeStamp);
			params.append("timeStarts=").append(timeStarts);
		}
		if (timeEnds!=null && timeEnds !="") {
			Integer date2TimeStamp = TimeUtils.date2TimeStamp(timeEnds, null);
			feedBackQuery.setTimeEnd(date2TimeStamp);
			params.append("&timeEnds=").append(timeEnds);
		}
		if (statuss!=null && statuss!= 0) {
			feedBackQuery.setStatus(statuss);
			params.append("&statuss=").append(statuss);
		}
		feedBackQuery.setPageSize(15);
		feedBackQuery.setPageNo(Pagination.cpn(pageNos));
		List <FeedBack> list =  feedBackMapper.queryFeedBackSByFeedBackSQuery(feedBackQuery);
		int totalCount = feedBackMapper.queryFeedBackSCountByFeedBackSQuery(feedBackQuery);
		Pagination pagination = new Pagination(feedBackQuery.getPageNo(),feedBackQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/feedback/list.do";
		pagination.pageView(url, params.toString());
		return pagination;
	}
	
	/**
	 * 根据id删除
	 */
	@Override
	public void deleteFeedBackById(Integer id) {
		feedBackMapper.deleteFeedBackById(id);
	}
	/**
	 * 反馈确认处理操作
	 */
	@Override
	public void handleFeedBackById(Integer id) {
		feedBackMapper.handleFeedBackById(id);
		
	}
	
	/**
	 * 反馈类型类别查询
	 */
	@Override
	public Pagination queryFeedBackTypeByFeedBackTypeQuery(Integer pageNo) {
		//创建Query查询对象
		FeedBackQuery feedBackQuery = new FeedBackQuery();
		feedBackQuery.setPageSize(15);
		feedBackQuery.setPageNo(Pagination.cpn(pageNo));
		List <FeedBackType> list =  feedBackMapper.queryFeedBackTypeByFeedBackTypeQuery(feedBackQuery);
		int totalCount = feedBackMapper.queryFeedBackTypeCountByFeedBackTypeQuery(feedBackQuery);
		Pagination pagination = new Pagination(feedBackQuery.getPageNo(),feedBackQuery.getPageSize(),totalCount,list);
		//设置访问的url
		String url  = "/feedback/typelist.do";
		pagination.pageView(url, null);
		return pagination;
	}
	/**
	 * 反馈类别禁用
	 */
	@Override
	public void disableFeedBackTypeById(Integer id) {
		feedBackMapper.disableFeedBackTypeById(id);
	}
	/**
	 * 反馈类别启用
	 */
	@Override
	public void enabledFeedBackTypeById(Integer id) {
		feedBackMapper.enabledFeedBackTypeById(id);
		
	}
	/**
	 * 反馈类别删除
	 */
	@Override
	public void delFeedBackTypeById(Integer id) {
		feedBackMapper.delFeedBackTypeById(id);
		
	}
	/**
	 * 反馈类别添加
	 */
	@Override
	public void addFeedBackType(FeedBackType feedBackType) {
		feedBackType.setAddtime(TimeUtils.getCurentTimeStamp());
		feedBackMapper.addFeedBackType(feedBackType);
	}
	/**
	 * 反馈类别更新
	 */
	@Override
	public void updateFeedBackType(FeedBackType feedBackType) {
		feedBackMapper.updateFeedBackType(feedBackType);
		
	}
	/**
	 *  修改反馈类别
	 */
	@Override
	public FeedBackType findFeedBackTypeById(Integer id) {
		FeedBackType feedBackType = feedBackMapper.findFeedBackTypeById(id);
		return feedBackType;
	}
	
	
	
	

}
