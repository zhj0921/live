package com.dongwei.kangbao.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: TimeUtils
 * @Company: http://www.dongwei.com/
 * @Description: 时间字符串
 * @author h
 * @date 2016年9月18日 上午8:55:35
 */
public class TimeUtils {
	
	
	

	/**
	 * 时间戳转换成日期格式字符串
	 * 
	 * @param utime
	 *            精确到秒的字符串
	 * @param formatStr
	 * @return
	 */
	public static String timeStamp2Date(Integer utime, String format) {
		if (utime == null || utime.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty())
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(utime + "000")));
	}
	
	/**
	 * 将时间戳转化为时分秒
	 * @param utime
	 * @param format
	 * @return
	 */
	/*public static String timeStamp3Date(Integer utime, String format) {
		if (utime == null || utime.equals("null")) {
			return "未知";
		}
		if(format == null || format.isEmpty())
			format = "HH:mm:ss";
			SimpleDateFormat formatter = new SimpleDateFormat(format);//初始化Formatter的转换格式。
			String hms = formatter.format(utime);
			return hms;
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(utime);
		SimpleDateFormat fmat=new SimpleDateFormat("HH:mm:ss");
		String time=fmat.format(calendar.getTime());
		return time;
	}*/
	
	/**
	 * 将时间戳转化为时分秒
	 * @Title: getDuration @Description: 将时间戳转换为时分秒 @param
	 * dataStamp @return @return String @throws
	 */
	public static String getDuration(Integer dataStamp) {
		if (dataStamp == null || dataStamp == 0) {
			return "0秒";
		} else if (dataStamp < 60) {
			return dataStamp + "秒";
		} else if (60 <= dataStamp && dataStamp < 3600) {
			int a = dataStamp / 60;
			int b = dataStamp % 60;
			if (b == 0) {
				return a + "分钟";
			} else {
				return a + "分钟" + b + "秒";
			}
		} else if (3600 <= dataStamp) {
			int a = dataStamp / 3600;
			int b = dataStamp % 3600;
			if (b < 60) {
				return a + "小时" + b + "秒";
			} else if (b >= 60) {
				int c = b / 60;
				int d = b % 60;
				if (d == 0) {
					return a + "小时" + c + "分";
				} else {
					return a + "小时" + c + "分" + d + "秒";
				}
			}

		}
		return null;

	}

	/**
	 * 日期格式字符串转换成时间戳
	 * 
	 * @param date
	 *            字符串日期
	 * @param format
	 *            如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Integer date2TimeStamp(String date_str, String format) {
		try {
			if (format == null || format.isEmpty())
				format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return Integer.valueOf((int) (sdf.parse(date_str).getTime() / 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: getCurentTime @Description: 获取当前时间 @return @return
	 *         Integer @throws
	 */
	public static String getCurentTime() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		return time;
	}
	/**
	 * 当前时间戳
	 */
	public static Integer getCurentTimeStamp() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		Integer date2TimeStamp = date2TimeStamp(time,null);
		return date2TimeStamp;
	}

	/**
	 * 当天的开始时间
	 * 
	 * @return
	 */
	public static Date startOfTodDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 当天的结束时间
	 * 
	 * @return
	 */
	public static Date endOfTodDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 
	 * @Title: date2Str
	 * @Description: 日期转换为字符串
	 * @param date
	 * @param format
	 * @return
	 * @return String
	 * @throws
	 */
	public static String date2Str(Date date,String format){
		if (format == null || format.isEmpty())
			format = "yyyy-MM-dd HH:mm:ss";
	    SimpleDateFormat sdf=new SimpleDateFormat(format);  
	    String str=sdf.format(date);
		return str;  
	}
	
	

	
	/**
	 * 获得本月开始时间戳
	 * @return
	 */
	public static Integer getMonthFirstDay() {  
	    Calendar calendar = Calendar.getInstance();// 获取当前日期  
	    calendar.add(Calendar.MONTH, 0);  
	    calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天  
	    calendar.set(Calendar.HOUR_OF_DAY, 0);  
	    calendar.set(Calendar.MINUTE, 0);  
	    calendar.set(Calendar.SECOND, 0);  
	    //System.out.println(calendar.getTimeInMillis());  
	  
	    int monthFirstDay = Integer.parseInt(String.valueOf(calendar.getTimeInMillis()).substring(0, 10));
	    
	    return monthFirstDay;  
	} 
	
	
	/**
     * 获取当年的第一天
     * @param year
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    /**
     * 获取当年开始的时间戳
     * 
     * 
     * @param year
     * @return
     */
    public static Integer getCurrYearFirstStamp(){
    	
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = f.format(getCurrYearFirst());
		Integer date2TimeStamp = TimeUtils.date2TimeStamp(sDate, null);
		return date2TimeStamp;

    }
    /**
     * 获取当年结束的时间戳
     * @param year
     * @return
     */
    public static Integer getCurrYearLastStamp(){
    	
    	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String sDate = f.format(getCurrYearLast());
    	Integer date2TimeStamp = TimeUtils.date2TimeStamp(sDate, null);
    	return date2TimeStamp;
    	
    }
     
    /**
     * 获取当年的最后一天
     * @param year
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();  
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }
     
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }
     
    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
         
        return currYearLast;
    }
    
    //获得本月第一天0点时间 
    public static int getTimesMonthmorning(){ 
    Calendar cal = Calendar.getInstance(); 
    cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0); 
    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH)); 
    return (int) (cal.getTimeInMillis()/1000); 
    } 
    //获得本月最后一天24点时间 
    public static int getTimesMonthnight(){ 
    Calendar cal = Calendar.getInstance(); 
    cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0,0); 
    cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH)); 
    cal.set(Calendar.HOUR_OF_DAY, 24); 
    return (int) (cal.getTimeInMillis()/1000); 
    }

	/**
	 * 
	 * @Title: getAssignStartStamp
	 * @Description: 获取指定日期的当天的开始时间戳
	 * @param date
	 * @param format
	 * @return
	 * @return Integer
	 * @throws
	 */
    public static Integer getAssignStartStamp(String date ,String format){
    	date+=" 0:0:0";
    	try {
			if (format == null || format.isEmpty())
				format = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return Integer.valueOf((int) (sdf.parse(date).getTime() / 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    	
    }
    
    /**
     * 
     * @Title: getAssignStartStamp
     * @Description: 获取指定日期的当天的结束时间戳
     * @param date
     * @param format
     * @return
     * @return Integer
     * @throws
     */
    public static Integer getAssignEndStamp(String date ,String format){
    	date+=" 23:59:59";
    	try {
    		if (format == null || format.isEmpty())
    			format = "yyyy-MM-dd HH:mm:ss";
    		SimpleDateFormat sdf = new SimpleDateFormat(format);
    		return Integer.valueOf((int) (sdf.parse(date).getTime() / 1000));
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
    
    
  //获得当天0点时间 
  	public static int getTimesmorning(){ 
  	Calendar cal = Calendar.getInstance(); 
  	cal.set(Calendar.HOUR_OF_DAY, 0); 
  	cal.set(Calendar.SECOND, 0); 
  	cal.set(Calendar.MINUTE, 0); 
  	cal.set(Calendar.MILLISECOND, 0); 
  	return (int) (cal.getTimeInMillis()/1000); 
  	} 
  	//获得当天24点时间 
  	public static int getTimesnight(){ 
  	Calendar cal = Calendar.getInstance(); 
  	cal.set(Calendar.HOUR_OF_DAY, 24); 
  	cal.set(Calendar.SECOND, 0); 
  	cal.set(Calendar.MINUTE, 0); 
  	cal.set(Calendar.MILLISECOND, 0); 
  	return (int) (cal.getTimeInMillis()/1000); 
  	} 
	
	
}
