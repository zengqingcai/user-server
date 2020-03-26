package com.user.general.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.general.dao.UserAccountMapper;
import com.user.general.entity.domain.UserAccount;
import com.user.general.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 11:22
 * @Version: 0.0.1
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public PageInfo<UserAccount> findPage(UserAccount userAccount) {
        PageHelper.startPage(userAccount.getCurrentPage(),userAccount.getPageSize());
        List<UserAccount> userAccountList = userAccountMapper.queryByParams(userAccount);
        PageInfo<UserAccount> pageInfo = new PageInfo(userAccountList);
        return pageInfo;
    }

    @Override
    public Integer saveUserAccount(UserAccount userAccount) {
        return userAccountMapper.insertSelective(userAccount);
    }

    @Override
    public UserAccount loadUserAccount(Integer userAccountId) {
        return userAccountMapper.queryByPrimary(userAccountId);
    }

    @Override
    public Integer updateUserAccount(UserAccount userAccount) {
        return userAccountMapper.updateBySelective(userAccount);
    }
}
