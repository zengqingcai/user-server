package com.web.back.service;

import com.user.account.entity.model.UserAccount;

import java.util.List;

public interface UserAccountService {
	
	UserAccount findById(Integer id);


	List<UserAccount> findPage(UserAccount userAccount);

}
