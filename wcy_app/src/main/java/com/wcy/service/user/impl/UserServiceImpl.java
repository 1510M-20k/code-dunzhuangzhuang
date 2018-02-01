package com.wcy.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcy.dao.user.UserDao;
import com.wcy.model.user.User;
import com.wcy.service.user.UserService;
import com.wcy.utils.Tools;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 新增
	 */
	public int insert(User user) {
		return userDao.insert(user);
	}
	
	/**
	 * 修改
	 */
	public int update(User user) {
		return userDao.update(user);
	}
	
	/**
	 * 根据ID删除
	 */
	public int delete(String ids) {
		if(Tools.notEmpty(ids)){
			String[] id =ids.split(",");
			for(int i=0;i<id.length;i++){
				userDao.delete(id[i]);
			}
			return id.length;
		} else{
			return 0;
		}
	}
	
	/**
	 * 根据ID查询单条详情
	 */
	public User getById(String id) {
		return userDao.getById(id);
	}
	
	/**
	 * 查询分页列表
	 */
	public List<User> getList(User user) {
		return userDao.getList(user);
	}
	
	//分页查询数量
	public int getCount(User user){
		return userDao.getCount(user);
	}

}