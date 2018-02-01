package com.wcy.controller;


import java.util.UUID;



public class BaseController {
	
	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID(){
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
	
	
}
