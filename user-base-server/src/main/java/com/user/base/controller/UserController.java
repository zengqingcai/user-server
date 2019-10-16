package com.user.base.controller;

import com.user.base.comm.CodeMsg;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表")
    @ResponseBody
    public ResponseBean<List<User>> findPage(@RequestBody RequestBean<User> requestBean){
        User user = requestBean.getData();
        return ResponseBean.success(userService.findPage(user));

    }


    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户")
    @ResponseBody
    public ResponseBean<Integer> saveUser(@RequestBody @Valid User user){

        Integer integer = userService.saveUser(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

}
