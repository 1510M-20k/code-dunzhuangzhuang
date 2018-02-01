package com.wcy.model.dianpu;

import com.wcy.model.BaseModel;
/**
 * 用户
 * @author Administrator
 */
public class Dianpu extends BaseModel{

	private String id;//主键id
	
	private String name;//店铺名称
	
	private String tjr;//推荐人
	
	private String wifi_name;//wifi账号
	
	private String wifi_pwd;//wifi密码
	
	private String phone;//店铺电话
	
	private String address;//店铺地址
	
	private String img;//店铺图片
	
	private String create_time;//创建时间
	
	private String creater;//创建人
	
	private String update_time;//最后修改时间
	
	private String updater;//最后修改人
	
	private String erwm;//二维码url
	
	private String all_money;//店铺总收入
	
	private String able_modey;//店铺余额
	
	private String today_money;//当日收入
	

	public void setId(String id){
		this.id=id;
	}

	public String getId(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}
	
	public void setTjr(String tjr){
		this.tjr=tjr;
	}

	public String getTjr(){
		return tjr;
	}
	
	public void setWifi_name(String wifi_name){
		this.wifi_name=wifi_name;
	}

	public String getWifi_name(){
		return wifi_name;
	}
	
	public void setWifi_pwd(String wifi_pwd){
		this.wifi_pwd=wifi_pwd;
	}

	public String getWifi_pwd(){
		return wifi_pwd;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}

	public String getPhone(){
		return phone;
	}
	
	public void setAddress(String address){
		this.address=address;
	}

	public String getAddress(){
		return address;
	}
	
	public void setImg(String img){
		this.img=img;
	}

	public String getImg(){
		return img;
	}
	
	public void setCreate_time(String create_time){
		this.create_time=create_time;
	}

	public String getCreate_time(){
		return create_time;
	}
	
	public void setCreater(String creater){
		this.creater=creater;
	}

	public String getCreater(){
		return creater;
	}
	
	public void setUpdate_time(String update_time){
		this.update_time=update_time;
	}

	public String getUpdate_time(){
		return update_time;
	}
	
	public void setUpdater(String updater){
		this.updater=updater;
	}

	public String getUpdater(){
		return updater;
	}
	
	public void setErwm(String erwm){
		this.erwm=erwm;
	}

	public String getErwm(){
		return erwm;
	}
	
	public void setAll_money(String all_money){
		this.all_money=all_money;
	}

	public String getAll_money(){
		return all_money;
	}
	
	public void setAble_modey(String able_modey){
		this.able_modey=able_modey;
	}

	public String getAble_modey(){
		return able_modey;
	}
	
	public void setToday_money(String today_money){
		this.today_money=today_money;
	}

	public String getToday_money(){
		return today_money;
	}
	
}
