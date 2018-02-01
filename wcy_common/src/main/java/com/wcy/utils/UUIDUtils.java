package com.wcy.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 得到32位的uuid
	 * @return
	 */
	public static String get32UUID(){
		return UUID.randomUUID().toString().trim().replaceAll("-", "");
	}
}
