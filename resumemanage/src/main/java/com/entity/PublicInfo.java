package com.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @Title: PublicInfo 
 * @Description: 用于Action对页面的返回
 * @author lzh
 * @date 2016-12-12 下午03:48:24
 */
public class PublicInfo{
	private String code; //001 成功   002 失败 003系统异常  004 入参不对 005 权限不足
	private String msg;
	private  List<Map<String, Object>> ls= new ArrayList<Map<String,Object>>();
	private String count ;//总记录数
	
	private String errcode;
	private String errMsg;

	
	private String data_json = null;//例如：“data”:{“enterpriseList”:[]……}
	
	private Object o;//其他信息
	
	
	
	public Object getO() {
		return o;
	}
	public void setO(Object o) {
		this.o = o;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public List<Map<String, Object>> getLs() {
		return ls;
	}
	public void setLs(List<Map<String, Object>> ls) {
		this.ls = ls;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getData_json() {
		return data_json;
	}
	public void setData_json(String data_json) {
		this.data_json = data_json;
	}
	
}
