package com.user.general.service;

import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.entity.domain.UserBase;
import com.user.general.entity.dto.response.UserInfoQueryRes;

import java.util.List;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 11:04
 * @Version: 0.0.1
 */
public interface UserBaseService {


    PageInfo<UserBase> findPage(UserBase userBase);

    List<UserBase> queryByParams(UserBase userBase);


    CodeMsg saveUserBase(UserBase userBase) throws Exception;


    UserBase loadUserBase(Integer userBaseId);


    CodeMsg updateUserBase(UserBase userBase);

    PageInfo<UserInfoQueryRes> queryUserInfoByParams(Map<String,Object> params);
}
