package com.wcy.service.impl.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcy.dao.test.TestDao;
import com.wcy.service.test.TestService;
import com.wcy.test.Test;
@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	public List<Test> getlist(){
		return testDao.getlist();
	}
}
