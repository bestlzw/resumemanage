package com.utils;

import java.text.ParseException;

public class Tools {

	/**
	 * 获取当年未逾期月份占总月份的比例
	 * 
	 * @param start_month
	 * @param end_month
	 * @throws ParseException
	 */
	public static double getMonthRate(String start_time, String current_year,
			String end_time) throws ParseException {
		// 总月数
		int totalMonth = DateUtil.getMonthSpace(start_time, end_time,
				"yyyy-MM-dd");

		String start_year = start_time.substring(0, 4);
		String end_year = end_time.substring(0, 4);
		int startYearDiff = DateUtil.getMonthSpace(start_year, current_year,
				"yyyy");
		if (startYearDiff < 0) {
			// 尚未开始
			return 0d;
		}

		// 判断当年是否超出截止时间的年
		int endYearDiff = DateUtil
				.getMonthSpace(current_year, end_year, "yyyy");
		if (endYearDiff < 0) {
			// 超出不计
			return 0d;
		}

		// 有效的起始日期
		String validStartTime;
		// 有效的截止日期
		String validEndTime;

		if (TextUtils.equals(current_year, start_year)) {
			// 当年为开始年 有效起始日期为项目开始日期
			validStartTime = start_time;
		} else {
			// 当年非开始年 有效起始日期为当年1月1日
			validStartTime = current_year + "-01-01";
		}

		if (TextUtils.equals(current_year, end_year)) {
			// 当年为结束年 有效起始日期为项目结束日期
			validEndTime = end_time;
		} else {
			// 当年非结束年 有效结束日期为当年12月31日
			validEndTime = current_year + "-12-31";
		}
		int validTime = DateUtil.getMonthSpace(validStartTime, validEndTime,
				"yyyy-MM-dd");

		return validTime * 1.0 / totalMonth;
	}

//	public static void main(String[] args) {
//		try {
//			System.out.println(getMonthRate("2017-01-01", "2016-06-02"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
