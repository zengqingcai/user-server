package com.user.general.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.dao.UserAccountMapper;
import com.user.general.entity.domain.UserAccount;
import com.user.general.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public CodeMsg saveUserAccount(UserAccount userAccount) {
        userAccount.setCt(new Date());
        userAccount.setCid(0l);
        userAccount.setUid(0l);
        userAccountMapper.insertSelective(userAccount);
        return new CodeMsg("0000","添加用户账户信息成功");
    }

    @Override
    public UserAccount loadUserAccount(Integer userAccountId) {
        return userAccountMapper.queryByPrimary(userAccountId);
    }

    @Override
    public CodeMsg updateUserAccount(UserAccount userAccount) {
        userAccountMapper.updateBySelective(userAccount);
        return new CodeMsg("0000","修改用户账户信息成功");
    }
}
