package com.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class SecretUtil {
	/**
	 * @Title:  md5Hex
	 * @Description: TODO 实现MD5加密
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016年11月11日 下午4:35:14
	 */
	public static String md5Hex(String data){
		return DigestUtils.md5Hex(data);
	}
	/**
	 * @Title:  sha1Hex
	 * @Description: TODO 实现sha1加密
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016年11月11日 下午4:35:14
	 */
	public static String sha1Hex(String data){
		return DigestUtils.sha1Hex(data);
	}
	/**
	 * @Title:  sha256Hex
	 * @Description: TODO 实现sha256加密
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016年11月11日 下午4:46:09
	 */
	public static String sha256Hex(String data){
		return DigestUtils.sha1Hex(data);
	}
	/**
	 * @Title:  sha512Hex
	 * @Description: TODO 实现sha512加密
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016年11月11日 下午4:45:13
	 */
	public static String sha512Hex(String data){
		return DigestUtils.sha512Hex(data);
	}
}