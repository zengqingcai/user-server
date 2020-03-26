package com.user.general.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.general.entity.domain.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo queryByPrimary(Integer id);

    List<UserInfo> queryByParams(UserInfo userAccount);

    Integer insertSelective(UserInfo userAccount);

    Integer updateBySelective(UserInfo userAccount);

    Integer updateSetStatus(UserInfo userAccount);

}
