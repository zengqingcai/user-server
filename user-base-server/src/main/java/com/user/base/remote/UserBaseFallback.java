package com.user.base.remote;

import com.github.pagehelper.PageInfo;
import com.user.base.remote.entity.baseUser.response.UserInfoQueryRes;
import com.user.common.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserBaseFallback implements UserBaseFeignService{


	@Override
	public PageInfo<UserInfoQueryRes> queryUserInfoByParams(Map<String, Object> requestBean){
		System.out.println("快速失败");
		return null;
	}
}
