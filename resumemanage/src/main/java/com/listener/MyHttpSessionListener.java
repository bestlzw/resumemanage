package com.listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * @Title: MyHttpSessionListener 
 * @Description: HttpSession的监听器，在session被创建后和销毁前被调用
 * @author lzh
 * @date 2016-11-29 上午11:21:37
 */
public class MyHttpSessionListener implements HttpSessionListener{

	Logger logger = Logger.getLogger(getClass());
	public static int sessionCount = 0;
	/**
	 * 当一个HttpSession被创建后的操作
	 */
	public synchronized void sessionCreated(HttpSessionEvent e) {
		sessionCount++;
		System.out.println("HttpSession新增，当前数量"+sessionCount);
	}
	/**
	 * 当一个HttpSession被摧毁前的操作
	 */
	public synchronized void sessionDestroyed(HttpSessionEvent e) {
		HttpSession ses = e.getSession();
		Long time = ses.getCreationTime();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("该session的创建时间:"+sdf.format(date));
		sessionCount--;
		System.out.println("HttpSession销毁，当前数量"+sessionCount);
	}

}
