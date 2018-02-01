package com.wcy.model.user;

import com.wcy.model.BaseModel;
/**
 * 用户
 * @author Administrator
 */
public class User extends BaseModel{

	private String id;//注解id
	
	private String phone;//手机号
	
	private String name;//中文姓名
	
	private String create_time;//创建时间
	
	private String update_time;//最后修改时间
	
	private String creater;//
	
	private String updater;//
	

	public void setId(String id){
		this.id=id;
	}

	public String getId(){
		return id;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}
	
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}

	public String getCreate_time(){
		return create_time;
	}
	
	public void setUpdate_time(String update_time){
		this.update_time=update_time;
	}

	public String getUpdate_time(){
		return update_time;
	}
	
	public void setCreater(String creater){
		this.creater=creater;
	}

	public String getCreater(){
		return creater;
	}
	
	public void setUpdater(String updater){
		this.updater=updater;
	}

	public String getUpdater(){
		return updater;
	}
	
}
