package com.user.base.service.impl;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.user.base.annotation.TestAccess;
import com.user.common.exception.BuExceptionEnum;
import com.user.common.exception.BusinessException;
import com.user.common.utils.codec.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.base.dao.UserMapper;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@TestAccess(value = "1111")
	@Override
	public PageInfo<User> findPage(User user) {
		//todo 暂时写死的
		PageHelper.startPage(1, 10);
		List<User> list = userMapper.queryUserByParams(user);
		PageInfo<User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public Integer saveUser(User user) {

		if(userMapper.queryUserByUserCode(user.getUsercode())!=null){
			throw new BusinessException(BuExceptionEnum.ACCOUNT_AGAINT);
		}
		String password = MD5Util.md5(user.getPassword());
		user.setPassword(password);
		return userMapper.insertSelective(user);
	}

	@Override
	public User queryByPrimary(String id) {
		return userMapper.queryByPrimary(id);
	}

	@Override
	public List<User> queryUserByParams(User user) {
		return userMapper.queryUserByParams(user);
	}

	@Override
	public User queryUserByUserCode(String usercode) {
		return userMapper.queryUserByUserCode(usercode);
	}

	@Override
	public int insertSelective(User user) {
		return userMapper.insertSelective(user);
	}

	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int updateBySelective(User user) {

		if(user.getId()==null||user.getId()==0) {
			throw new BusinessException(BuExceptionEnum.ID_MUST);
		}
		if(userMapper.queryUserByUserCodeWithoutId(user)!=null){
			throw new BusinessException(BuExceptionEnum.ACCOUNT_AGAINT);
		}
		if(StringUtils.isNotBlank(user.getPassword())){
            user.setPassword(MD5Util.md5(user.getPassword()));
        }
		return userMapper.updateBySelective(user);
	}

	@Override
	public Integer saveUser(Map<String, Object> map) {


		return null;
	}

    @Override
	public Integer updateUserStatus(User user){
        return userMapper.updateSetStatus(user);
    }

}
