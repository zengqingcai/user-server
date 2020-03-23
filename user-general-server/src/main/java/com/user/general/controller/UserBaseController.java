package com.user.general.controller;

import com.github.pagehelper.PageInfo;
import com.user.general.entity.domain.UserBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 9:17
 * @Version: 0.0.1
 */

@Controller
@RequestMapping("/userBase")
@Api(value = "普通用户-base", description = "普通用户-base")
public class UserBaseController {

    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表-base")
    @ResponseBody
    public PageInfo<UserBase> findPage(@RequestBody UserBase userBase){
        return null;
    }


    @RequestMapping(value = "/saveUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-base")
    @ResponseBody
    public Integer saveUserBase(@RequestBody UserBase userBase){
        return null;
    }


    @RequestMapping(value = "/loadUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-base")
    @ResponseBody
    public UserBase loadUserBase(@RequestBody Integer userBaseId){
        return null;
    }

    @RequestMapping(value = "/updateUserBase",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户-base")
    @ResponseBody
    public Integer updateUserBase(@RequestBody UserBase userBase){
        return null;
    }
}
