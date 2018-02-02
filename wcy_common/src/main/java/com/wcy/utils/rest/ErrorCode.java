package com.wcy.utils.rest;


/**
 * 枚举1.7大量推荐使用，效率高
 * 1男2女 1、常量类；枚举；（星期、状态）；3数据字典(数据库）
 * 业务类型
 */
public enum ErrorCode {
	SUCCESS("00000","成功"),
	ERROR1("00001","运行错误，请联系管理员"),
	ERROR2("00002","签名错误，请检查签名"),
	ERROR3("00003","参数错误，前仔细检查参数");
	
	public String name;
	public String value;

	ErrorCode(String name, String value) {
		this.value = value;
		this.name = name;
	}
	public static void main(String[] args) {
		System.out.println(ErrorCode.SUCCESS);
		System.out.println(ErrorCode.SUCCESS.name);
		System.out.println(ErrorCode.SUCCESS.value);
		ErrorCode[] values = ErrorCode.values();
		for(int i=0;i<values.length;i++){
			System.out.println(values[i].name);
		}
	}
}
