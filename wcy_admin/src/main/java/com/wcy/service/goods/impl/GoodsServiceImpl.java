package com.wcy.service.goods.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcy.model.goods.Goods;
import com.wcy.dao.goods.GoodsDao;
import com.wcy.service.goods.GoodsService;
import com.wcy.utils.Tools;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 新增
	 */
	@Override
	public int insert(Goods goods) {
		return goodsDao.insert(goods);
	}
	
	/**
	 * 修改
	 */
	@Override
	public int update(Goods goods) {
		return goodsDao.update(goods);
	}
	
	/**
	 * 根据ID删除
	 */
	@Override
	public int delete(String ids) {
		if(Tools.notEmpty(ids)){
			String[] id =ids.split(",");
			for(int i=0;i<id.length;i++){
				goodsDao.delete(id[i]);
			}
			return id.length;
		} else{
			return 0;
		}
	}
	
	/**
	 * 根据ID查询单条详情
	 */
	@Override
	public Goods getById(String id) {
		return goodsDao.getById(id);
	}
	
	/**
	 * 查询分页列表
	 */
	@Override
	public List<Goods> getList(Goods goods) {
		return goodsDao.getList(goods);
	}
	
	//分页查询数量
	public int getCount(Goods goods){
		return goodsDao.getCount(goods);
	}

}