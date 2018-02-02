package com.wcy.utils.rest;

public class ResultObj {
	//错误编码
	private String code=ErrorCode.SUCCESS.name;
	//返回对象
	private Object obj;
	//编码说明
	private String msg=ErrorCode.SUCCESS.value;
	
	public void setError(ErrorCode error) {
		this.code = error.name;
		this.msg = error.value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
