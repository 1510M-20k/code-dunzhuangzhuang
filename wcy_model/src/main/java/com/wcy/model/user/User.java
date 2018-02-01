package com.wcy.model.user;

import com.wcy.BaseModel;

/**
 * 用户
 * @author Administrator
 */
public class User extends BaseModel{

	private String id;//主键id
	
	private String user_name;//用户名
	
	private String password;//密码
	
	private String name;//姓名
	
	private String phone;//手机
	
	private String email;//邮箱
	
	private String create_time;//创建时间
	
	private String update_time;//最后修改时间
	

	public void setId(String id){
		this.id=id;
	}

	public String getId(){
		return id;
	}
	
	public void setUser_name(String user_name){
		this.user_name=user_name;
	}

	public String getUser_name(){
		return user_name;
	}
	
	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}
	
	public void setEmail(String email){
		this.email=email;
	}

	public String getEmail(){
		return email;
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
	
}
