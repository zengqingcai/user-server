package com.user.base.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.remote.entity.UserAccount;


@Profile("!mock")
@FeignClient(name = "user-account",fallback = UserAccountFallback.class)
@RequestMapping(value = "/user/account")
public interface UserAccountFeignService {
	
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
    ResponseBean<UserAccount> findAccountById(@RequestBody RequestBean<Integer> requestBean);

}
