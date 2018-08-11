package com.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
/**
 * @Title: BeanUtil 
 * @Description: Bean和其他对象之间的转换
 * @author lzh
 * @date 2017年7月25日 上午9:21:22
 */
public class BeanUtil {
	/**
	 * @Title:  reqTransToObject
	 * @Description: TODO 将request中的参数转换成一个具体的Bean,
	 * @Attention: 转换失败返回null
	 * @param 
	 * @return void
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws 
	 * @author lzh
	 * @date 2017-7-14 上午07:01:01
	 */
	@SuppressWarnings("unchecked")
	public static <T> T reqTransToBean(HttpServletRequest request,Class <T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		//创建javaBean对象    
		Object obj = clazz.newInstance();
		//得到请求中的每个参数
	    Enumeration<String> enu = request.getParameterNames();
	    while(enu.hasMoreElements()){
	    	//获得参数名
	    	String name = enu.nextElement();
	    	//获得参数值
	    	String value = request.getParameter(name);
	    	//然后把参数拷贝到javaBean对象中
	    	BeanUtils.setProperty(obj, name, value);
	    
	    	return (T)obj;	
	    }
	    return null;
	}
	/**
	 * @Title:  map2Bean
	 * @Description: TODO 将map转换成一个bean
	 * @Attention: 转换失败返回null
	 * @param 
	 * @return T
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws 
	 * @author lzh
	 * @date 2017-7-14 上午07:38:07
	 */
	public static <T> T map2Bean(Map<String,Object> map,Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		T bean = clazz.newInstance();
		BeanUtils.populate(bean, map);
		return bean;
	}
	/**
	 * @Title:  listMapToListBean
	 * @Description: TODO List<Map>对象 转换为List<T>对象，T表示bean的类型
	 * @Attention: 转换失败返回null
	 * @param 
	 * @return List<T>
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws 
	 * @author lzh
	 * @date 2017-7-14 上午07:57:12
	 */
	public static <T> List<T> listMapToListBean(List<Map<String,Object>> ls,Class <T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		List<T> list = new ArrayList<T>();
		for(int i=0;i<ls.size();i++){
			Map<String,Object> map = ls.get(i);
			T bean = map2Bean(map,clazz);
			list.add(bean);
		}
		return list;
	}
}
