package com.wcy.service.dianpu.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcy.model.dianpu.Dianpu;
import com.wcy.dao.dianpu.DianpuDao;
import com.wcy.service.dianpu.DianpuService;
import com.wcy.utils.Tools;

@Service
public class DianpuServiceImpl implements DianpuService {

	@Autowired
	private DianpuDao dianpuDao;
	
	/**
	 * 新增
	 */
	@Override
	public int insert(Dianpu dianpu) {
		return dianpuDao.insert(dianpu);
	}
	
	/**
	 * 修改
	 */
	@Override
	public int update(Dianpu dianpu) {
		return dianpuDao.update(dianpu);
	}
	
	/**
	 * 根据ID删除
	 */
	@Override
	public int delete(String ids) {
		if(Tools.notEmpty(ids)){
			String[] id =ids.split(",");
			for(int i=0;i<id.length;i++){
				dianpuDao.delete(id[i]);
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
	public Dianpu getById(String id) {
		return dianpuDao.getById(id);
	}
	
	/**
	 * 查询分页列表
	 */
	@Override
	public List<Dianpu> getList(Dianpu dianpu) {
		return dianpuDao.getList(dianpu);
	}
	
	//分页查询数量
	public int getCount(Dianpu dianpu){
		return dianpuDao.getCount(dianpu);
	}

}