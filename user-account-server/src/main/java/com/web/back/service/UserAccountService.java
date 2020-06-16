package com.web.back.service;

import com.web.back.entity.model.UserAccount;

import java.util.List;

public interface UserAccountService {
	
	UserAccount findById(Integer id);


	List<UserAccount> findPage(UserAccount userAccount);

}
