package com.user.base;

import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserBaseApplicationTest1 {

    @Autowired
    private UserService userService;

    @Value("${test.name}")
    private String testName;

    @Value("${mail.user}")
    private String mailUser;


    @Test
    public void test1(){
        User user = new User();

        //List<User> list = userService.findPage(user);
        //System.out.println("size:"+list.size()+",mail.user:"+testName);
    }

}
