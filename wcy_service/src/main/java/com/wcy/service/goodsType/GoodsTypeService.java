package com.wcy.service.goodsType;

import java.util.List;

import com.wcy.model.goodsType.GoodsType;

public interface GoodsTypeService {

	//新增
	public int insert(GoodsType goodsType);

	//修改
	public int update(GoodsType goodsType);

	//删除
	public int delete(String ids);

	//根据Id查询单条记录
	public GoodsType getById(String id);

	//分页查询列表
	public List<GoodsType> getList(GoodsType goodsType);
	
	//分页查询数量
	public int getCount(GoodsType goodsType);
	
}