package com.user.base.dao;

import com.user.base.entity.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    Role queryByPrimaryKey(Integer id);

    List<Role> queryByParams(Role params);

    Integer insert(Role role);

    Integer insertSelective(Role role);

    Integer updateSelective(Role role);


}