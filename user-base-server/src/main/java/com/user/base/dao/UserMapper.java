package com.user.base.dao;

import com.user.base.entity.model.User;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    
   User queryByPrimary(String id);
    
   List<User> queryUserByParams(User user);

   User queryUserByUserCode(String usercode);
   
   int insertSelective(User user);
   
   int insert(User user);
    
   int updateBySelective(User user);
}