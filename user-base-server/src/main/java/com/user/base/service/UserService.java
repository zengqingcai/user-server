package com.user.base.service;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.user.base.entity.model.User;

public interface UserService {

	List<User> findPage(User user);

	Integer saveUser(User user);

	User queryByPrimary(String id);

	List<User> queryUserByParams(User user);

	User queryUserByUserCode(String usercode);

	int insertSelective(User user);

	int insert(User user);

	int updateBySelective(User user);

}
