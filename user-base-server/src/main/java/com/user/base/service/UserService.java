package com.user.base.service;

import java.util.List;

import com.user.base.entity.model.User;

public interface UserService {

	
	List<User> findPage(User user);


	Integer saveUser(User user);

}
