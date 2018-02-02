package com.wcy.service.goods;

import java.util.List;

import com.wcy.model.goods.Goods;

public interface GoodsService {

	//新增
	public int insert(Goods goods);

	//修改
	public int update(Goods goods);

	//删除
	public int delete(String ids);

	//根据Id查询单条记录
	public Goods getById(String id);

	//分页查询列表
	public List<Goods> getList(Goods goods);
	
	//分页查询数量
	public int getCount(Goods goods);
	
}