package com.dongwei.kangbao.po;

import java.io.Serializable;

/**
 * 当天0点和24点的时间戳
 * @author 作者: Administrator
 * @version 创建时间：2016年12月14日 下午3:35:06
 */
public class Today implements Serializable{

	private static final long serialVersionUID = -1727643744319791252L;
	
	private Integer timesmorning;
	private Integer timesnight;
	
	public Integer getTimesmorning() {
		return timesmorning;
	}
	public void setTimesmorning(Integer timesmorning) {
		this.timesmorning = timesmorning;
	}
	public Integer getTimesnight() {
		return timesnight;
	}
	public void setTimesnight(Integer timesnight) {
		this.timesnight = timesnight;
	}
	@Override
	public String toString() {
		return "Today [timesmorning=" + timesmorning + ", timesnight=" + timesnight + "]";
	}
	
}
