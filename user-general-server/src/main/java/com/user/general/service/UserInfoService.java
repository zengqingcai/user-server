package com.user.general.service;

import com.github.pagehelper.PageInfo;
import com.user.general.entity.domain.UserInfo;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:03
 * @Version: 0.0.1
 */
public interface UserInfoService {


    PageInfo<UserInfo> findPage(UserInfo userInfo);



    Integer saveUserInfo(UserInfo userInfo);



    UserInfo loadUserInfo(Integer userInfoId);


    Integer updateUserInfo(UserInfo userInfo);
}
