package com.user.general.controller;

import com.github.pagehelper.PageInfo;
import com.user.general.entity.domain.UserAccount;
import com.user.general.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Authod:zeng
 * @Date: 2020/3/23 10:43
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/userAccount")
@Api(value = "普通用户-account", description = "普通用户-account")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表-account")
    @ResponseBody
    public PageInfo<UserAccount> findPage(@RequestBody UserAccount userAccount){
        return userAccountService.findPage(userAccount);
    }


    @RequestMapping(value = "/saveUserAccount",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-account")
    @ResponseBody
    public Integer saveUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.saveUserAccount(userAccount);
    }


    @RequestMapping(value = "/loadUserAccount",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-account")
    @ResponseBody
    public UserAccount loadUserAccount(@RequestBody Integer userAccountId){
        return userAccountService.loadUserAccount(userAccountId);
    }

    @RequestMapping(value = "/updateUserAccount",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户-account")
    @ResponseBody
    public Integer updateUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.updateUserAccount(userAccount);
    }
}
