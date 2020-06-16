package com.user.general.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.general.entity.domain.UserBase;
import com.user.general.entity.dto.response.UserInfoQueryRes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户基础表 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@Repository
public interface UserBaseMapper extends BaseMapper<UserBase> {

    UserBase queryByPrimary(Integer id);

    UserBase queryByCode(UserBase userBase);

    List<UserBase> queryByParams(UserBase userAccount);

    Integer insertSelective(UserBase userAccount);

    Integer updateBySelective(UserBase userAccount);

    Integer updateSetStatus(UserBase userAccount);

    List<UserInfoQueryRes> queryUserInfoByParams(Map<String,Object> params);

}
