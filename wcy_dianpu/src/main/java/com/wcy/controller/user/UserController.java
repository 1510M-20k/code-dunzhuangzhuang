package com.wcy.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController//Controller+ResponseBody
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="createStore",method=RequestMethod.POST)
//	@ResponseBody
	public Map<String,Object> createStore(String username,String storename){
		Map<String,Object> map = new HashMap<String,Object>();
		logger.debug("username============="+username);
		logger.info("storename============="+storename);
		map.put("success", true);
		return map;
	}
	
	@RequestMapping(value="createStore",method=RequestMethod.GET)
	public Map<String,Object> createStore1(String username,String storename){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("success", true);
		return map;
	}
}
