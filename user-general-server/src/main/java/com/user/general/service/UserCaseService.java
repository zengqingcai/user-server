package com.user.general.service;

import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.entity.domain.UserCase;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 11:04
 * @Version: 0.0.1
 */
public interface UserCaseService {


    PageInfo<UserCase> findPage(UserCase userCase);

    List<UserCase> queryByParams(UserCase userCase);


    CodeMsg saveUserCase(UserCase userCase) throws Exception;


    UserCase loadUserCase(Integer userCaseId);


    CodeMsg updateUserCase(UserCase userCase);
}
