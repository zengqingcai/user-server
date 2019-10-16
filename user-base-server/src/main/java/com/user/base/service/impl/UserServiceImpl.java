package com.user.base.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.user.base.annotation.TestAccess;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.base.dao.UserMapper;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@TestAccess(value = "1111")
	@Override
	public List<User> findPage(User user) {
		System.out.println();
		PageHelper.startPage(1, 10);
		List<User> list = userMapper.queryUserByParams(user);
		return list;
	}

	@Override
	public Integer saveUser(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public User queryByPrimary(String id) {
		return userMapper.queryByPrimary(id);
	}

	@Override
	public List<User> queryUserByParams(User user) {
		return userMapper.queryUserByParams(user);
	}

	@Override
	public User queryUserByUserCode(String usercode) {
		return userMapper.queryUserByUserCode(usercode);
	}

	@Override
	public int insertSelective(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateBySelective(User user) {
		return userMapper.updateBySelective(user);
	}

}
