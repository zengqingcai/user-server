package com.user.general.controller;

import com.github.pagehelper.PageInfo;
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


    @RequestMapping(value = "/findPage",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户分页列表-info")
    @ResponseBody
    public PageInfo<UserInfo> findPage(@RequestBody UserInfo userInfo){
        return userInfoService.findPage(userInfo);
    }


    @RequestMapping(value = "/saveUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户-info")
    @ResponseBody
    public Integer saveUserInfo(@RequestBody UserInfo userInfo){
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
    public Integer updateUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }


    public static void main(String[] args) {
        int maxNumb = 80;//按订单最大800 拆分
        int numbLen = 1;//拆分成多少笔
        int rowCount = 170;//获得ResultSet的总行数
        System.out.println("订单 "+rowCount+" 条");

        if(rowCount>maxNumb ){
            numbLen = (int)Math.ceil((double)rowCount/(double)maxNumb);
            //向上取整
        }

        String str = "12,332,33,";
        System.out.println("value:"+str.substring(0,str.length()-1));

        Map map = new HashMap<>();
        map.put("mont",12.2);
        map.put("orderId","2018-55555");
        String orderIds = "";
        orderIds = orderIds+ (String)map.get("orderId")+",";
        System.out.println(orderIds);

        Double totalMont = 7.0;
        totalMont = totalMont + (Double)map.get("mont");
        System.out.println("order:"+orderIds+",totalMont:"+totalMont);
    }


}
