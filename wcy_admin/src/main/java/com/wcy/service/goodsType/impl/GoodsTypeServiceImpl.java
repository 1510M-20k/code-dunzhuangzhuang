package com.wcy.service.goodsType.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcy.model.goodsType.GoodsType;
import com.wcy.dao.goodsType.GoodsTypeDao;
import com.wcy.service.goodsType.GoodsTypeService;
import com.wcy.utils.Tools;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	/**
	 * 新增
	 */
	@Override
	public int insert(GoodsType goodsType) {
		return goodsTypeDao.insert(goodsType);
	}
	
	/**
	 * 修改
	 */
	@Override
	public int update(GoodsType goodsType) {
		return goodsTypeDao.update(goodsType);
	}
	
	/**
	 * 根据ID删除
	 */
	@Override
	public int delete(String ids) {
		if(Tools.notEmpty(ids)){
			String[] id =ids.split(",");
			for(int i=0;i<id.length;i++){
				goodsTypeDao.delete(id[i]);
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
	public GoodsType getById(String id) {
		return goodsTypeDao.getById(id);
	}
	
	/**
	 * 查询分页列表
	 */
	@Override
	public List<GoodsType> getList(GoodsType goodsType) {
		return goodsTypeDao.getList(goodsType);
	}
	
	//分页查询数量
	public int getCount(GoodsType goodsType){
		return goodsTypeDao.getCount(goodsType);
	}

}