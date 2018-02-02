package com.wcy.dao.goodsType;

import java.util.List;

import com.wcy.model.goodsType.GoodsType;

public interface GoodsTypeDao {

	//新增
	public int insert(GoodsType goodsType);

	//修改
	public int update(GoodsType goodsType);

	//删除
	public int delete(String id);

	//根据Id查询单条记录
	public GoodsType getById(String id);

	//分页查询列表
	public List<GoodsType> getList(GoodsType goodsType);
	
	//分页查询数量
	public int getCount(GoodsType goodsType);
	
}