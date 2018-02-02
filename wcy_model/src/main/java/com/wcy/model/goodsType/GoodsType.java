package com.wcy.model.goodsType;

import com.wcy.model.BaseModel;
/**
 * 用户
 * @author Administrator
 */
public class GoodsType extends BaseModel{

	private String id;//主键
	
	private String name;//分类名称
	
	private String sort;//排序
	
	private String is_tj;//是否推荐
	
	private String is_fschf;//是否收取餐盒费
	
	private String img;//分类图片
	

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
	
	public void setSort(String sort){
		this.sort=sort;
	}

	public String getSort(){
		return sort;
	}
	
	public void setIs_tj(String is_tj){
		this.is_tj=is_tj;
	}

	public String getIs_tj(){
		return is_tj;
	}
	
	public void setIs_fschf(String is_fschf){
		this.is_fschf=is_fschf;
	}

	public String getIs_fschf(){
		return is_fschf;
	}
	
	public void setImg(String img){
		this.img=img;
	}

	public String getImg(){
		return img;
	}
	
}
