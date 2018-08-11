package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.utils.WebUtil;
/**
 * @Title: MyServletRequestListener 
 * @Description: request监听器，在容器收到请求时最先被调用
 * @author lzh
 * @date 2016-12-16 上午09:53:54
 */
//@WebListener
public class MyServletRequestListener implements ServletRequestListener{
	
	Logger logger = Logger.getLogger(getClass());
	/**
	 * HttpServletRequest对象被销毁前的操作
	 */
	public void requestDestroyed(ServletRequestEvent e) {
		logger.info("MyServletRequestListener have been closed");
	}
	
	/**
	 * HttpServletRequest对象创建后的操作
	 */
	public void  requestInitialized(ServletRequestEvent e){
		HttpServletRequest req = (HttpServletRequest)e.getServletRequest();
		String IP = WebUtil.getBrowserIp(req);
		logger.info("收到来自"+IP+"的请求: "+req.getRequestURL()+"，开始处理");
	}

}
