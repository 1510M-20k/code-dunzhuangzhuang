package com.wcy.utils.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.wcy.utils.DateUtil;
import com.wcy.utils.http.HttpClientUtils;

public class AppTest {
	
	
	@Test
	public void testlist1(){
		String res = HttpClientUtils.doPost("http://localhost:8080/wcy_app/app/user/list.action", null, null);
		System.out.println(res);
	}

	
	@Test
	public void testlist(){
		//准备参数
		Map<String, String> params = new HashMap<String, String>();
		params.put("token", "wangyue");
		params.put("timestamp", DateUtil.getDateTimeFormat(new Date()));
		params.put("name", "张三");
		//生成签名
		String sign = CheckUtils.createSign(params);
		//把签名，加到参数里边
		params.put("sign", sign);
		String res = HttpClientUtils.doPost("http://localhost:8080/wcy_app/app/user/list.action", params, null);
		System.out.println(res);
	}

}
