package com.wcy.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController//Controller+ResponseBody
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("createStore")
//	@ResponseBody
	public Map<String,Object> createStore(String username,String storename){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.debug("username============="+username);
		logger.info("storename============="+storename);
		map.put("success", true);
		return map;
	}
}
