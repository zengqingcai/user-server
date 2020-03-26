package com.user.general.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.general.entity.domain.UserBase;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
