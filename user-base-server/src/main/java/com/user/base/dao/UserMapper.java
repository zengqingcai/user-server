package com.user.base.dao;

import com.user.base.entity.model.User;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
    
   User queryByPrimary(Integer id);
    
   List<User> queryUserByParams(User user);

   User queryUserByUserCode(String usercode);

   User queryUserByUserCodeWithoutId(User params);
   
   int insertSelective(User user);
   
   int insert(User user);
    
   int updateBySelective(User user);

   int updateSetStatus(User user);
}