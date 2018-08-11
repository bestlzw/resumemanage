package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**
 * @Title: MyServletContextListener 
 * @Description: ServletContext对象的监听器,容器启动时被调用
 * @author lzh
 * @date 2016-11-29 上午11:31:19
 */
public class MyServletContextListener implements ServletContextListener{

	Logger logger = Logger.getLogger(getClass());
	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent event) {

		ServletContext servletCtx = event.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx);
		logger.info("线程启动前空闲内存"+Runtime.getRuntime().freeMemory()/1024/1024+"MB");
		//初始化定时任务
		//new TimerManager();
		System.out.println(1111111);
	}

}
