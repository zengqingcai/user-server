package com.user.base.remote;

import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
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
