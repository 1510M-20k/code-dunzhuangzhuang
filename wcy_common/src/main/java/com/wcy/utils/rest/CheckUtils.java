package com.wcy.utils.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.wcy.utils.DateUtil;
import com.wcy.utils.Tools;

public class CheckUtils {
	static String mytoken="wangyue";
	/**
	 * 验证签名
	 * @param request
	 * @return 1
	 */
	public static int checkSignature(HttpServletRequest request) {
		//获取签名
		String sign = request.getParameter("sign");
		if(Tools.isEmpty(sign)){
			return 1;//签名为空
		}
		//获取token
		String token = request.getParameter("token");
		if(Tools.isEmpty(token)){
			return 2;//token为空
		}
		if(!mytoken.equals(token)){
			return 5;//token错误
		}
		//获取时间戳
		String timestamp = request.getParameter("timestamp");
		if(Tools.notEmpty(timestamp)){
			int min = DateUtil.getChaMin(timestamp);
			if(min > 5){
				return 4;//url过期
			}
		} else{
			return 3;//timestamp为空
		}
		Enumeration<?> pNames =  request.getParameterNames();  
		Map<String, String> params = new HashMap<String, String>();
		while (pNames.hasMoreElements()) {  
		    String pName = (String) pNames.nextElement();  
		    if("sign".equals(pName))continue;  
		    Object pValue = request.getParameter(pName);  
		    params.put(pName,  String.valueOf(pValue));  
		} 
		String newsign = createSign(params);
		if(!sign.equals(newsign)){
			return 4;//签名过期
		} 
		return 0;
	}
	/**
	 * 生成签名
	 * 
	 * @param params
	 * @param encode
	 * @return
	 * @throws Exception
	 */
	public static String createSign(Map<String, String> params){
		//把所有参数排序
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		
		//把所有参数拼接成字符串
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			if (first) {
				first = false;
			} else {
				temp.append("&");
			}
			temp.append(key).append("=");
			Object value = params.get(key);
			String valueString = "";
			if (null != value) {
				valueString = String.valueOf(value);
			}
			try {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		//把拼接成的字符串Md5加密，生成签名
		return MD5Utils.encode(temp.toString()).toUpperCase();
	}
}
