package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entity.PublicInfo;
import com.utils.JsonUtil;

public class PermissionInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 调用Controller之前,返回true继续,返回false则不再继续controller及之后的调用(一般用来权限判断)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		String uri = request.getRequestURI();

		HttpSession session = request.getSession(false);
		PublicInfo publicInfo = new PublicInfo();

		try {
			String rank_id = uri.substring(uri.lastIndexOf("/") + 1,
					uri.lastIndexOf(".action"));
			logger.info("请求通过总控，RANK_ID为" + rank_id);
			if (checkPermission(session, rank_id)) {
				return true;
			} else {
				publicInfo.setCode("-1");
				publicInfo.setMsg("您无权进行此操作");
				JsonUtil.printJson(response, JsonUtil.objectToJson(publicInfo));
			}
		} catch (Exception e) {
			e.printStackTrace();
			publicInfo.setCode("-1");
			publicInfo.setMsg(e.getMessage());
			JsonUtil.printJson(response, JsonUtil.objectToJson(publicInfo));
		}
		return false;
	}

	/**
	 * 调用Controller之后，生成视图之前(一般用来在ModelAndView中放数据)
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {

	}

	/**
	 * 生成视图之后(一般用来释放资源)
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	private boolean checkPermission(HttpSession session, String rank_id) {
		// TODO 权限控制
		System.out.println("权限放开");
		return true;
	}

}
