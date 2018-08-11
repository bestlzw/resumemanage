package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * @Title: RegexUtil 
 * @Description: 正则表达式的工具类
 * @author lzh
 * @date 2016年11月17日 下午8:10:45
 */
public class RegexUtil {
	/**
	 * @Title:  isExistChn
	 * @Description: TODO 检查是否存在中文字符
	 * @Attention:
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author lzh
	 * @date 2016年11月17日 下午8:36:07
	 */
	/*
	 * 方法错误
	public static boolean isExistChn(String str){
		return match(str,"[\u4E00-\u9FA5]+");
	}
	*/
	
	
	
	
	
	
	
	/**
	 * @Title:  match
	 * @Description: TODO 验证一个字符串是否匹配一个正则表达式
	 * @Attention:
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author lzh
	 * @date 2016年11月17日 下午8:29:02
	 */
	public static boolean match(String str,String regex){
		 //创建正则表达式的模式对象 
		Pattern pattern = Pattern.compile(regex);
		//通过模式对象创建一个匹配对象 
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * @Title:  validTimeString
	 * @Description: TODO 验证一个字符串是否是  "yyyy-MM-dd"格式的字符串
	 * @Attention: 年必须是4位数的，实际中很少用到少于4位或多于4位的年数,且必须1开头或者2开头
	 * @param 
	 * @return void
	 * @throws 
	 * @author lzh
	 * @date 2016年12月21日 上午10:25:58
	 */
	public static boolean validTimeString(String time){
		if(StringUtil.isNull(time)){
			return false;
		}
		String regex1 = "^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}";//先验证是否符合基本格式
		boolean b = match(time,regex1);
		if(!b){
			return false;
		}
		//System.out.println("基本格式校验正确");
		
		String year = time.substring(0, 4);
		if(!year.startsWith("1") && !year.startsWith("2")){
			return false;
		}
		//System.out.println("年份基本校验正确");
		
		
		String month = time.substring(time.indexOf("-")+1, time.lastIndexOf("-"));
		int m = Integer.parseInt(month);
		if(m<0 || m>12){
			return false;
		}
		//System.out.println("月份基本校验正确");
		
		String date = time.substring(time.lastIndexOf("-")+1);
		int d = Integer.parseInt(date);
		
		if(d<0 || d>31){
			return false;
		}
		//System.out.println("月份基本校验正确");
		
		if(m==1 ||m==3||m==5||m==7||m==8||m==10||m==12){
			
		}else{
			if(d>30){
				return false;
			}
		}
		//System.out.println("月份天数基本校验正确");
		
		
		if(!TimeUtil.isRunYear(year)){//不是闰年
			if(m==2 && d>28){
				return false;
			}
		}
		//System.out.println("闰年基本校验正确");
		
		return true;
	}
	
	/**
	 * @Title:  validTimeString
	 * @Description: TODO 验证一个字符串是否是  "yyyy-MM-dd HH:mm:ss"格式的字符串
	 * @Attention: 年必须是4位数的，实际中很少用到少于4位或多于4位的年数,且必须1开头或者2开头
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author ShiYuqun
	 * @date 2017年1月19日 上午10:25:58
	 */
	public static boolean validTimeString2(String time){
		if(StringUtils.isEmpty(time)){
			return false;
		}
		String regex1 = "^[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}[\\s]{1,}[\\d]{1,2}:[\\d]{1,2}:[\\d]{1,2}";//先验证是否符合基本格式
		boolean b = match(time,regex1);
		if(!b){
			return false;
		}
		//System.out.println("基本格式校验正确");
		
		String year = time.substring(0, 4);
		if(!year.startsWith("1") && !year.startsWith("2")){
			return false;
		}
		//System.out.println("年份基本校验正确");
		
		
		String month = time.substring(time.indexOf("-")+1, time.lastIndexOf("-"));
		int m = Integer.parseInt(month);
		if(m<0 || m>12){
			return false;
		}
		//System.out.println("月份基本校验正确");
		
		String day = time.substring(time.lastIndexOf("-")+1,time.indexOf(" "));
		int d = Integer.parseInt(day);
		
		if(d<0 || d>31){
			return false;
		}
		//System.out.println("月份基本校验正确");
		
		if(m==1 ||m==3||m==5||m==7||m==8||m==10||m==12){
			
		}else{
			if(d>30){
				return false;
			}
		}
		//System.out.println("月份天数基本校验正确");
		
		
		if(!TimeUtil.isRunYear(year)){//不是闰年
			if(m==2 && d>28){
				return false;
			}
		}
		//System.out.println("闰年基本校验正确");
		
		String hour=time.substring(time.lastIndexOf(" ")+1,time.indexOf(":"));	//时
		int hh=Integer.parseInt(hour);
		String min=time.substring(time.indexOf(":")+1,time.lastIndexOf(":"));	//分
		int mm=Integer.parseInt(min);
		String second=time.substring(time.lastIndexOf(":")+1);	//秒
		int ss=Integer.parseInt(second);
		
		if(hh<0||hh>23){
			return false;
		}
		if(mm<0||mm>59){
			return false;
		}
		if(ss<0||ss>59){
			return false;
		}
		return true;
	}
	
	
	/**
	 * @Title:  checkCellphone
	 * @Description: TODO 验证一个字符串是否是电话号码
	 * @Attention: 验证手机号码 ，必须是11位，以1开头
	 *            移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
	 *            联通号码段:130、131、132、136、185、186、145
	 *            电信号码段:133、153、180、189
	 * @param  cellphone
	 * @return boolean
	 * @throws 
	 * @author wy
	 * @date 2017年8月3日16:50:29
	 */	
	public static boolean checkCellphone(String cellphone) {
		if(cellphone.length()!=11){
			
			return false;
		}
		else{
			
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"; 
		
		return match(cellphone, regex);
		
		}
	}

	
//	public static void main(String[] args) {
//		String regex = "^[1-2]{1}[09]{1}[1-9]{2}-((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12)-()$";
//		System.out.println(validTimeString2("2015-02-28	23:00:59"));
//		System.out.println(checkCellphone("12222222222"));
//	}
}
