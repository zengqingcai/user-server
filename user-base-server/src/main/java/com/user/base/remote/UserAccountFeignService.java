package com.user.base.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.base.common.RequestBean;
import com.user.base.common.ResponseBean;
import com.user.base.remote.entity.UserAccount;


@Profile("!mock")
@FeignClient(name = "user-account",fallback = UserAccountFallback.class)
@RequestMapping(value = "/userBase")
public interface UserAccountFeignService {
	
	@RequestMapping(value = "/saveUserBase", method = RequestMethod.POST)
    ResponseBean<UserAccount> findAccountById(@RequestBody RequestBean<Integer> requestBean);

}
