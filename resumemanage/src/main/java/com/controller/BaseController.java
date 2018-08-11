package com.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.config.Constant;
import com.google.gson.Gson;

public class BaseController {

	public final Logger logger = Logger.getLogger(getClass());
	public Gson gson = new Gson();

	/**
	 * 判断登录是否超时
	 * 
	 * @param session
	 */
	protected boolean isLoginTimeOut(HttpSession session) {
		Object u_id = session.getAttribute(Constant.SessionInfo.U_ID);
		return u_id == null;
	}

}
