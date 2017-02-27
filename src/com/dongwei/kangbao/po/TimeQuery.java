package com.dongwei.kangbao.po;

import java.io.Serializable;
import java.util.Date;

import com.dongwei.kangbao.utils.TimeUtils;

public class TimeQuery implements Serializable {

	// Fields

	private static final long serialVersionUID = -2166247896685081548L;
	
	Integer startTimeStamp;//当天开始的时间戳
	Integer endTimeStamp;//当天结束的时间戳
	Integer startYearTimeStamp;//当年开始的时间戳
	Integer endYearTimeStamp;//当年结束的时间戳
	Integer timesMonthnight ;//当月结束的时间戳
	Integer timesMonthmorning ;//当月开始的时间戳
	
	private Integer timeStart ;
	private Integer timeEnd ;
	
	
	
	
	public Integer getStartYearTimeStamp() {
		Integer currYearFirstStamp = TimeUtils.getCurrYearFirstStamp();
		return currYearFirstStamp;
	}
	public Integer getTimesMonthnight() {
		int timesMonthnight2 = TimeUtils.getTimesMonthnight();
		return timesMonthnight2;
	}
	public void setTimesMonthnight(Integer timesMonthnight) {
		this.timesMonthnight = timesMonthnight;
	}
	public Integer getTimesMonthmorning() {
		int timesMonthmorning2 = TimeUtils.getTimesMonthmorning();
		return timesMonthmorning2;
	}
	public void setTimesMonthmorning(Integer timesMonthmorning) {
		this.timesMonthmorning = timesMonthmorning;
	}
	public void setStartYearTimeStamp(Integer startYearTimeStamp) {
		this.startYearTimeStamp = startYearTimeStamp;
	}
	public Integer getEndYearTimeStamp() {
		Integer currYearLastStamp = TimeUtils.getCurrYearLastStamp();
		return currYearLastStamp;
	}
	public void setEndYearTimeStamp(Integer endYearTimeStamp) {
		this.endYearTimeStamp = endYearTimeStamp;
	}
	public Integer getStartTimeStamp() {
		//今日 零点
		Date startDate = TimeUtils.startOfTodDay();
		String date2Str = TimeUtils.date2Str(startDate, null);
		startTimeStamp = TimeUtils.date2TimeStamp(date2Str, null);
		return startTimeStamp;
	}
	public void setStartTimeStamp(Integer startTimeStamp) {
		this.startTimeStamp = startTimeStamp;
	}
	public Integer getEndTimeStamp() {
		//今日结束时间
		Date endOfTodDay = TimeUtils.endOfTodDay();
		String date2Str2 = TimeUtils.date2Str(endOfTodDay, null);
		endTimeStamp = TimeUtils.date2TimeStamp(date2Str2, null);
		return endTimeStamp;
	}
	public void setEndTimeStamp(Integer endTimeStamp) {
		this.endTimeStamp = endTimeStamp;
	}
	public Integer getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Integer timeStart) {
		this.timeStart = timeStart;
	}
	public Integer getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Integer timeEnd) {
		this.timeEnd = timeEnd;
	}
	@Override
	public String toString() {
		return "TimeQuery [startTimeStamp=" + startTimeStamp + ", endTimeStamp=" + endTimeStamp
				+ ", startYearTimeStamp=" + startYearTimeStamp + ", endYearTimeStamp=" + endYearTimeStamp
				+ ", timesMonthnight=" + timesMonthnight + ", timesMonthmorning=" + timesMonthmorning + ", timeStart="
				+ timeStart + ", timeEnd=" + timeEnd + "]";
	}
	
}
