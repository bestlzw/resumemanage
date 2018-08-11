package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @Title: TimeUtil 
 * @Description: 时间类型操作的工具类
 * @author lzh
 * @date 2016年11月17日 下午8:11:02
 */
public class TimeUtil {
	/**
	 * @Title:  getSysTime
	 * @Description: TODO 获取系统时间  格式  "yyyy-MM-dd HH:mm:ss"
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016年11月17日 下午8:12:22
	 */
	public static String getSysTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	/**
	 * @Title:  isRunYear
	 * @Description: TODO 判断一个年份是否是闰年
	 * @Attention: 公元纪年，年份可以是负数
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author lzh
	 * @date 2016年12月21日 上午10:48:25
	 */
	public static boolean isRunYear(String year){
		if(!year.startsWith("-")){
			if(!NumberUtils.isDigits(year)){
				return false;
			}
		}else{
			String year_pre = year.substring(1);
			if(!NumberUtils.isDigits(year_pre)){
				return false;
			}
		}
		Integer y = Integer.parseInt(year);
		if(y%4!=0){
			return false;
		}else{
			if(y%100==0){
				if(y%400!=0){
					return false;
				}else{
					return true;
				}
			}else{
				return true;
			}
		}
	}
	
	//public static void main(String[] args) {
	//	System.out.println(isRunYear("2017"));
	//}
}
