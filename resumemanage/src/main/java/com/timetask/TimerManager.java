package com.timetask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


/**
 * @Title: TimerManager 
 * @Description: 线程管理器，负责定时任务
 * @author lzh
 * @date 2017-1-11 上午10:50:08
 */
public class TimerManager {
	//时间间隔1天
	private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;
	
	public TimerManager() {
		Calendar calendar = Calendar.getInstance(); 
		 calendar.set(Calendar.HOUR_OF_DAY, 1);
		 calendar.set(Calendar.MINUTE, 0);
		 calendar.set(Calendar.SECOND, 0);
		 calendar.add(Calendar.DATE, 1);
	  
		 Date date=calendar.getTime(); //第一次执行定时任务的时间
		Timer timer = new Timer();
//		 DayOverTask dayOverTask = new DayOverTask();
//		 OrderTimeoutTask orderBatchTask = new OrderTimeoutTask();
//		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
//		 timer.schedule(dayOverTask,date,PERIOD_DAY);//每日定期执行
//		 timer.schedule(orderBatchTask, new Date(), InitConstants.ORDER_TIMEOUT_PERIOD);//间隔多少时间执行一次
		

	}
}