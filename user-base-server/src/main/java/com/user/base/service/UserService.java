package com.user.base.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.entity.model.User;

public interface UserService {

	PageInfo<User> findPage(User user);

	Integer saveUser(User user);

	User queryByPrimary(String id);

	List<User> queryUserByParams(User user);

	User queryUserByUserCode(String usercode);

	int insertSelective(User user);

	int insert(User user);

	int updateBySelective(User user);


	//注册
	Integer saveUser(Map<String,Object> map);


	Integer updateUserStatus(User user);

}
