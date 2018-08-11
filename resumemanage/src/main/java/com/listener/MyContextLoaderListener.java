package com.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;


 
/**
 * @Title: MyContextLoaderListener 
 * @Description: 继承自spring的监听器，容器启动时被调用
 * @author lzh
 * @date 2016-12-16 上午09:52:04
 */
public class MyContextLoaderListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
	   ServletContext servletCtx = event.getServletContext();
	   WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx);
//	   
//	   //初始化Ctx类，加载spring-bean.xml定义的类
//		Ctx.setCtx(WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx));
	}
}

