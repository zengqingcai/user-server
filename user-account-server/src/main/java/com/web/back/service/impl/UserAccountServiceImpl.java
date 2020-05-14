package com.web.back.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.back.dao.UserAccountDao;
import com.web.back.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.account.dao.UserAccountDao;
import com.user.account.entity.model.UserAccount;
import com.user.account.service.UserAccountService;

import java.util.List;


@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	
	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public UserAccount findById(Integer id) {
		return userAccountDao.findById(id);
	}

	@Override
	public List<UserAccount> findPage(UserAccount userAccount) {
		PageHelper.startPage(1, 2);
		List<UserAccount> list = userAccountDao.findPage(userAccount);
		PageInfo<UserAccount> pageInfo = new PageInfo<>(list);
		System.out.println("value:"+pageInfo.getPageNum());

		return null;
	}

}
