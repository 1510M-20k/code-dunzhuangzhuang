package com.wcy.utils.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.wcy.utils.DateUtil;
import com.wcy.utils.http.HttpClientUtils;

public class AppTest {
	
	@Test
	public void testlist(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("token", "wangyue");
		params.put("timestamp", DateUtil.getDateTimeFormat(new Date()));
		params.put("name", "张三");
		String sign = CheckUtils.createSign(params);
		params.put("sign", sign);
		String res = HttpClientUtils.doPost("http://localhost:8080/wcy_app/app/user/list.action", params, null);
		System.out.println(res);
	}

}
