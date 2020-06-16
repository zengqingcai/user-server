package com.user.general.controller;

import com.github.pagehelper.PageInfo;
import com.user.common.model.CodeMsg;
import com.user.general.entity.domain.UserBase;
import com.user.general.entity.dto.response.UserInfoQueryRes;
import com.user.general.service.UserBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:17
 * @Version: 0.0.1
 */

@Controller
@RequestMapping("/userBase")
@Api(value = "普通用户-base", description = "普通用户-base")
public class UserBaseController {

    @Autowired
    private UserBaseService userBaseService;

    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表-base")
    @ResponseBody
    public PageInfo<UserBase> findPage(@RequestBody UserBase userBase){
        return userBaseService.findPage(userBase);
    }


    @RequestMapping(value = "/saveUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-base")
    @ResponseBody
    public CodeMsg saveUserBase(@RequestBody UserBase userBase)throws Exception{
        return userBaseService.saveUserBase(userBase);
    }

    @RequestMapping(value = "/updateUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户-base")
    @ResponseBody
    public CodeMsg updateUserBase(@RequestBody UserBase userBase){
        return userBaseService.updateUserBase(userBase);
    }


    @RequestMapping(value = "/loadUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-base")
    @ResponseBody
    public UserBase loadUserBase(@RequestBody Integer userBaseId){
        return userBaseService.loadUserBase(userBaseId);
    }


    @RequestMapping(value = "/queryUserInfoByParams",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户资料")
    @ResponseBody
    public PageInfo<UserInfoQueryRes> queryUserInfoByParams(@RequestBody Map<String,Object> params){
        return userBaseService.queryUserInfoByParams(params);
    }

}
