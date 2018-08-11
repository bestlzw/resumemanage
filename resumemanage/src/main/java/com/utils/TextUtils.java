package com.utils;

import java.text.NumberFormat;
import java.util.Random;

public class TextUtils {
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
	 * 判断字符串是否为空串或者null
	 * 
	 * @param str
	 *            the string to be examined
	 * @return true if str is null or zero length
	 */
	public static boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	/**
	 * 判断字符串a、b是否相等（包括同时为null）
	 * 
	 * @param a
	 *            first CharSequence to check
	 * @param b
	 *            second CharSequence to check
	 * @return true if a and b are equal
	 */
	public static boolean equals(CharSequence a, CharSequence b) {
		if (a == b)
			return true;
		int length;
		if (a != null && b != null && (length = a.length()) == b.length()) {
			if (a instanceof String && b instanceof String) {
				return a.equals(b);
			} else {
				for (int i = 0; i < length; i++) {
					if (a.charAt(i) != b.charAt(i))
						return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串是否只存在数字
	 * 
	 * @param str
	 *            the string to be examined * @return whether the given
	 * 
	 *            CharSequence contains only digits.
	 */
	public static boolean isDigitsOnly(CharSequence str) {
		final int len = str.length();
		for (int i = 0; i < len; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否只存在字母
	 * 
	 * @param str
	 *            the string to be examined
	 * 
	 * @return whether the given CharSequence contains only letters.
	 */
	public static boolean isLetterOnly(CharSequence str) {
		final int len = str.length();
		for (int i = 0; i < len; i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否只存在中文
	 * 
	 * @param str
	 *            the string to be examined
	 * 
	 * @return whether the given CharSequence contains only Chinese.
	 */
	public static boolean isChineseOnly(CharSequence str) {
		String regex = "[\u4E00-\u9FA5]+";
		if (str.toString().matches(regex)) {
			return true;
		}
		return false;
	}

	/**
	 * 随机生成一个小于max的整数
	 * 
	 * @param max
	 * @return random 0-max
	 */
	public static int randomInt(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}

	/**
	 * 随机生成一个0-1的小数
	 * 
	 * @param length
	 *            小数位数
	 * @return random 0-1
	 */
	public static double randomDouble(int length) {
		NumberFormat format = NumberFormat.getNumberInstance();
		format.setMaximumFractionDigits(length);
		Random random = new Random();
		return Double.parseDouble(format.format(random.nextDouble()));
	}

	/**
	 * 根据mode随机生成一个字母
	 * 
	 * @param mode
	 *            0:lowerCase; 1:upperCase; 2:both(default)
	 * @return random letter
	 */
	public static char randomLetter(int mode) {
		String chars;
		switch (mode) {
		case 0:
			chars = "abcdefghijklmnopqrstuvwxyz";
			break;
		case 1:
			chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		case 2:
		default:
			chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			break;
		}
		return chars.charAt((int) (Math.random() * chars.length()));
	}

	/**
	 * 随机生成一个汉字
	 * 
	 * @return
	 */
	public static char randomChinese() {
		Random random = new Random();
		int delta = 0x9fa5 - 0x4e00 + 1;
		return (char) (0x4e00 + random.nextInt(delta));
	}

	public static String numberCheck(Object num) {
		if (num == null) {
			return null;
		}
		if (TextUtils.isEmpty(num.toString())) {
			return null;
		}
		return num.toString();
	}

	public static boolean isNumber(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

}
