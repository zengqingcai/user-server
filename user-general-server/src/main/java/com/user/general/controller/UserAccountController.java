package com.user.general.controller;

import com.user.common.model.CodeMsg;
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



    @RequestMapping(value = "/saveUserAccount",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-account")
    @ResponseBody
    public Object saveUserAccount(@RequestBody UserAccount userAccount){
        userAccount.setId(null);
        if(userAccount.getUserId()==null || userAccount.getUserId()==0)
            return CodeMsg.PARAM_ERROR;
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
    public Object updateUserAccount(@RequestBody UserAccount userAccount){
        if(userAccount.getId()==null || userAccount.getId()==0)
            return CodeMsg.PARAM_ERROR;
        if(userAccount.getUserId()==0)
            return CodeMsg.PARAM_ERROR;
        return userAccountService.updateUserAccount(userAccount);
    }
}
