package com.wcy.model.goods;

import com.wcy.model.BaseModel;
/**
 * 商品
 * @author Administrator
 */
public class Goods extends BaseModel{

	private String id;//主键id
	
	private String name;//商品名称
	
	private String type_id;//商品分类
	
	private String price;//商品价格
	
	private String proxy_price;//代理价格
	
	private String unite;//计量单位
	
	private String num;//库存
	
	private String tag;//标签
	
	private String is_wm;//支持外卖
	
	private String is_sj;//支持上架
	
	private String is_yhj;//支持优惠券
	
	private String is_hyk;//支持会员卡
	
	private String img;//图片
	
	private String content;//简介
	
	private String create_time;//创建时间
	
	private String update_time;//最后修改时间
	
	private String creater;//创建人
	
	private String updater;//最后修改人
	

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
	
	public void setType_id(String type_id){
		this.type_id=type_id;
	}

	public String getType_id(){
		return type_id;
	}
	
	public void setPrice(String price){
		this.price=price;
	}

	public String getPrice(){
		return price;
	}
	
	public void setProxy_price(String proxy_price){
		this.proxy_price=proxy_price;
	}

	public String getProxy_price(){
		return proxy_price;
	}
	
	public void setUnite(String unite){
		this.unite=unite;
	}

	public String getUnite(){
		return unite;
	}
	
	public void setNum(String num){
		this.num=num;
	}

	public String getNum(){
		return num;
	}
	
	public void setTag(String tag){
		this.tag=tag;
	}

	public String getTag(){
		return tag;
	}
	
	public void setIs_wm(String is_wm){
		this.is_wm=is_wm;
	}

	public String getIs_wm(){
		return is_wm;
	}
	
	public void setIs_sj(String is_sj){
		this.is_sj=is_sj;
	}

	public String getIs_sj(){
		return is_sj;
	}
	
	public void setIs_yhj(String is_yhj){
		this.is_yhj=is_yhj;
	}

	public String getIs_yhj(){
		return is_yhj;
	}
	
	public void setIs_hyk(String is_hyk){
		this.is_hyk=is_hyk;
	}

	public String getIs_hyk(){
		return is_hyk;
	}
	
	public void setImg(String img){
		this.img=img;
	}

	public String getImg(){
		return img;
	}
	
	public void setContent(String content){
		this.content=content;
	}

	public String getContent(){
		return content;
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
