package com.wcy.service.user;

import java.util.List;

import com.wcy.model.user.User;

public interface UserService {

	//新增
	public int insert(User user);

	//修改
	public int update(User user);

	//删除
	public int delete(String ids);

	//根据Id查询单条记录
	public User getById(String id);

	//分页查询列表
	public List<User> getList(User user);
	
	//分页查询数量
	public int getCount(User user);
	
}