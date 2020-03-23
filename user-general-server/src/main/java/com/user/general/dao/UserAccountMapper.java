package com.user.general.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.user.general.entity.domain.UserAccount;

import java.util.List;

/**
 * <p>
 * 用户账号信息表 Mapper 接口
 * </p>
 *
 * @author zeng
 * @since 2020-03-23
 */
public interface UserAccountMapper extends BaseMapper<UserAccount> {

    UserAccount queryByPrimary(Integer id);

    List<UserAccount> queryByParams(UserAccount userAccount);

    Integer insertSelective(UserAccount userAccount);

    Integer updateBySelective(UserAccount userAccount);

    Integer updateSetStatus(UserAccount userAccount);

}
