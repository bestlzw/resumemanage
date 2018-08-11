package com.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: MyUtil 
 * @Description: 自定义的满足该项目的工具类，可能没有普适性
 * @author lzh
 * @date 2016-11-18 下午04:48:45
 */
public class WebUtil {
	/**
	 * @Title:  getBrowserIp
	 * @Description: TODO 获取客户端(B端)的IP地址
	 * @Attention:
	 * @param 
	 * @return String
	 * @throws 
	 * @author lzh
	 * @date 2016-12-14 上午10:59:52
	 */
	public static String getBrowserIp(HttpServletRequest request){
		//获取客户端IP地址
		String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return  ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	/**
	 * @Title:  sendStringToClient
	 * @Description: TODO 将对象转成字符串传向前台
	 * @Attention:
	 * @param 
	 * @return void
	 * @throws IOException 
	 * @author lzh
	 * @date 2017-8-2 下午01:34:47
	 */
	public static void sendStringToClient(HttpServletRequest req,HttpServletResponse resp,Object o) throws IOException{
		resp.setHeader("Cache-Control", "no-cache");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		PrintWriter pw =  resp.getWriter();
		String json = JsonUtil.objectToJson(o);
		pw.print(json);
		pw.flush();
		pw.close();
	}
}
