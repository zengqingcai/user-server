package com.user.base.remote;

import org.springframework.stereotype.Component;

import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.remote.entity.UserAccount;

//@Component
public class UserAccountFallback implements UserAccountFeignService{

	@Override
	public ResponseBean<UserAccount> findAccountById(RequestBean<Integer> requestBean) {
		System.out.println("============快速失败请求========");
		// TODO Auto-generated method stub
		return null;
	}

}
