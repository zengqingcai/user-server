package com.user.base.dao;

import com.user.base.entity.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    Role queryByPrimaryKey(Integer id);

    Integer insert(Role role);

    Integer insertSelective(Role role);

    Integer updateSelective(Role role);


}