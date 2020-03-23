package com.user.general.controller;

import com.github.pagehelper.PageInfo;
import com.user.general.entity.domain.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:04
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/userInfo")
@Api(value = "普通用户-info", description = "普通用户-info")
public class UserInfoController {


    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表-info")
    @ResponseBody
    public PageInfo<UserInfo> findPage(@RequestBody UserInfo UserInfo){
        return null;
    }


    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-info")
    @ResponseBody
    public Integer saveUserInfo(@RequestBody UserInfo UserInfo){
        return null;
    }


    @RequestMapping(value = "/loadUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-info")
    @ResponseBody
    public UserInfo loadUserInfo(@RequestBody Integer UserInfoId){
        return null;
    }

    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户-info")
    @ResponseBody
    public Integer updateUserInfo(@RequestBody UserInfo UserInfo){
        return null;
    }


}
