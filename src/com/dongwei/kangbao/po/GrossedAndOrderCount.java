package com.dongwei.kangbao.po;

import java.io.Serializable;

/**
 * 总收入和订单总数量
 * @author 作者: Administrator
 * @version 创建时间：2016年12月14日 下午4:16:02
 */
public class GrossedAndOrderCount implements Serializable{

	private static final long serialVersionUID = 1024517204592557039L;

	private Double grossed;		//总收入
	private Integer orderCount;	//总订单数
	public Double getGrossed() {
		return grossed;
	}
	public void setGrossed(Double grossed) {
		this.grossed = grossed;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	@Override
	public String toString() {
		return "GrossedAndOrderCount [grossed=" + grossed + ", orderCount=" + orderCount + "]";
	}
	
}
