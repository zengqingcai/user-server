package com.user.general.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.general.dao.UserInfoMapper;
import com.user.general.entity.domain.UserInfo;
import com.user.general.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:03
 * @Version: 0.0.1
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<UserInfo> findPage(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getCurrentPage(),userInfo.getPageSize());
        List<UserInfo> userInfoList = userInfoMapper.queryByParams(userInfo);
        PageInfo<UserInfo> pageInfo = new PageInfo(userInfoList);
        return pageInfo;
    }

    @Override
    public Integer saveUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public UserInfo loadUserInfo(Integer userInfoId) {
        return userInfoMapper.queryByPrimary(userInfoId);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateBySelective(userInfo);
    }
}
