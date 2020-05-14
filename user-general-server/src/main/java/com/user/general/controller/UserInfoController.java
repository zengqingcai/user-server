package com.user.general.controller;

import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.entity.domain.UserInfo;
import com.user.general.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:04
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/userInfo")
@Api(value = "普通用户-info", description = "普通用户-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-info")
    @ResponseBody
    public Object saveUserInfo(@RequestBody UserInfo userInfo){
        userInfo.setId(null);
        if(userInfo.getUserId()==null || userInfo.getUserId()==0)
            return CodeMsg.PARAM_ERROR;
        return userInfoService.saveUserInfo(userInfo);
    }


    @RequestMapping(value = "/loadUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-info")
    @ResponseBody
    public UserInfo loadUserInfo(@RequestBody Integer userInfoId){
        return userInfoService.loadUserInfo(userInfoId);
    }

    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户-info")
    @ResponseBody
    public Object updateUserInfo(@RequestBody UserInfo userInfo){
        if(userInfo.getId()==null || userInfo.getId()==0)
            return CodeMsg.PARAM_ERROR;
        if(userInfo.getUserId()==0){
            return CodeMsg.PARAM_ERROR;
        }
        return userInfoService.updateUserInfo(userInfo);
    }


}
