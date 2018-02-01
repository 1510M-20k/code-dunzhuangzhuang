package com.wcy.service.dianpu;

import java.util.List;

import com.wcy.model.dianpu.Dianpu;

public interface DianpuService {

	//新增
	public int insert(Dianpu dianpu);

	//修改
	public int update(Dianpu dianpu);

	//删除
	public int delete(String ids);

	//根据Id查询单条记录
	public Dianpu getById(String id);

	//分页查询列表
	public List<Dianpu> getList(Dianpu dianpu);
	
	//分页查询数量
	public int getCount(Dianpu dianpu);
	
}