package com.user.base.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.base.dao.UserMapper;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findPage(User user) {
		System.out.println();
		PageHelper.startPage(1, 10);
		List<User> list = userMapper.findPage(user);
		return list;
	}

	@Override
	public Integer saveUser(User user) {
		return userMapper.insertSelective(user);
	}

}
