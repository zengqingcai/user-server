package com.user.base.controller;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.comm.RequestBean;
import com.user.base.comm.ResponseBean;
import com.user.base.entity.model.User;
import com.user.base.service.UserService;
import com.user.common.exception.BuExceptionEnum;
import com.user.common.exception.BusinessException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表")
    @ResponseBody
    public ResponseBean<PageInfo<User>> findPage(@RequestBody RequestBean<User> requestBean){
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

    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户")
    @ResponseBody
    public ResponseBean<Integer> updateUser(@RequestBody @Valid User user){

        Integer integer = userService.updateBySelective(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

    @RequestMapping(value = "updateUserPass",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码")
    @ResponseBody
    public ResponseBean<Integer> updateUserPass(@RequestBody @Valid User user){

        Integer integer = userService.updateBySelective(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }


    @RequestMapping(value = "updateUserStatus",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户状态")
    @ResponseBody
    public ResponseBean<Integer> updateUserStatus(@RequestBody Map<String,Object> map){
        User user = new User();
        if(map.get("id") == null || map.get("status") ==null){
            throw new BusinessException(BuExceptionEnum.ILLEGAL_PARAMETERS);
        }
        user.setId(Integer.valueOf(map.get("id").toString()));
        user.setLocked(map.get("status").toString());
        Integer integer = userService.updateUserStatus(user);
        return ResponseBean.success(CodeMsg.SUCCESS,integer);

    }

}
