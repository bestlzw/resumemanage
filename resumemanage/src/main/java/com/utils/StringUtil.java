package com.utils;

import org.apache.commons.lang3.StringUtils;
/**
 * @Title: StringUtil 
 * @Description: 字符串处理工具类
 * @author lzh
 * @date 2017-6-19 上午10:19:52
 */
public class StringUtil {
	/**
	 * @Title:  isNull
	 * @Description: TODO 判断字符串是否为空
	 * @Attention:
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author lzh
	 * @date 2017-2-23 上午09:34:25
	 */
	public static boolean isNull(String str){
		return null == str || str.length()<1 || "null".equals(str.trim()) ;
	}
	/**
	 * @Title:  replace
	 * @Description: TODO 字符串替换
	 * @Attention: 避免java.lang.String 中由正则表达式替换带来的麻烦
	 * @param 
	 * @return void
	 * @throws 
	 * @author lzh
	 * @date 2016-12-23 上午10:59:21
	 */
	public static String replace(String text,String searchString,String replacement){
		return StringUtils.replace(text, searchString, replacement);
	}
	/**
	 * @Title:  createStyle
	 * @Description: TODO 单个数字前拼接0
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2017-2-23 上午09:35:30
	 */
	public static String createStyle(int num){
		if(num<10){
			return "0"+num;
		}else{
			return num+"";
		}
	}

	/**
	 * 
	 * @Title: regexMatch
	 * @Description: TODO 判断字符串和正则表达式是否匹配
	 * @Attention:
	 * @param: regex 正则表达式，str 字符串
	 * @return: boolean
	 * @throws 
	 * @author ShiYuqun
	 * @date 2017-2-28 上午11:15:58
	 */
	public static boolean regexMatch(String regex,String str){
		try{
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
			java.util.regex.Matcher matcher=pattern.matcher(str);
			return matcher.matches();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * @Title:  split
	 * @Description: TODO 将一个字符串str用分隔符separatorChars来分割成数组
	 * @Attention: 不受正则表达式特殊字符的影响,JDK自带的split会受正则表达式中特殊字符的影响
	 * @param 
	 * @return String[]
	 * @throws 
	 * @author lzh
	 * @date 2016年11月11日 下午4:21:34
	 */
	public static String [] split(final String str,final String separatorChars){
		return StringUtils.split(str, separatorChars);
	}
	/**
	 * @Title:  contains
	 * @Description: TODO 字符串seq中是否有searchSeq
	 * @Attention:
	 * @param 
	 * @return boolean
	 * @throws 
	 * @author lzh
	 * @date 2017-4-5 下午04:24:22
	 */
	public static boolean contains(String seq,String searchSeq){
		return StringUtils.contains(seq, searchSeq);
	}
	
	
	
	
	
	
	
	
}
