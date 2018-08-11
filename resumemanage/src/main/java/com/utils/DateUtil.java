package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	/**
	 * 日期字符串转换Date对象
	 */
	public static Date formatDateString(String date, String format)
			throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(date);
	}

	/**
	 * "yyyy-MM"格式的日期字符串转换Date对象
	 */
	public static Date formatMonthString(String month) throws ParseException {
		return formatDateString(month, "yyyy-MM");
	}

	/**
	 * Date对象转换日期字符串
	 */
	public static String getFormatDateString(Date d, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(d);
	}

	/**
	 * Date对象转换"yyyy-MM-dd HH:mm:ss"格式日期字符串
	 */
	public static String getTimeString(Date d) {
		return getFormatDateString(d, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * "yyyy-MM"格式的字符串转换为"yyyy-MM-dd HH:mm:ss"格式字符串
	 */
	public static String formatTimeString(String month) throws ParseException {
		return getTimeString(formatMonthString(month));
	}

	public static String getTimeFromMonthObject(Object month) {
		if (month == null) {
			return null;
		}
		String time = month.toString();
		if (TextUtils.isEmpty(time)) {
			return null;
		}
		return time + "-01";
	}

	/**
	 * 获取当前准确系统时间
	 *
	 * @param format
	 *            格式化的时间格式
	 * @return 格式化后的时间String
	 */
	public static String getExtraTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
		return sdf.format(date);
	}

	/**
	 * 计算两个日期相差(date2-date1)月数
	 * 
	 * @param date1
	 *            startDate
	 * @param date2
	 *            endDate
	 * @param sdf
	 * @return
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2, String format)
			throws ParseException {

		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));

		result = 12 * (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR))
				+ c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH) + 1;

		return result;

	}

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("2016-11-02".substring(5, 7)));

		try {
			System.out.println(getMonthSpace("2016-01-01", "2016-11-01",
					"yyyy-MM-dd"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
