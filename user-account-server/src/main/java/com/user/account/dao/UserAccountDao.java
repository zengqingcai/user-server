package com.user.account.dao;

import org.springframework.stereotype.Repository;

import com.user.account.entity.model.UserAccount;

import java.util.List;

@Repository
public interface UserAccountDao {
	
	UserAccount findById(Integer id);

	List<UserAccount> findPage(UserAccount userAccount);

}
