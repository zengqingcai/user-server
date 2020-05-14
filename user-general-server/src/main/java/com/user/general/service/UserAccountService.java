package com.user.general.service;

import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.entity.domain.UserAccount;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 11:05
 * @Version: 0.0.1
 */
public interface UserAccountService {

    PageInfo<UserAccount> findPage(UserAccount userAccount);



    CodeMsg saveUserAccount(UserAccount userAccount);



    UserAccount loadUserAccount(Integer userAccountId);


    CodeMsg updateUserAccount(UserAccount userAccount);
}
