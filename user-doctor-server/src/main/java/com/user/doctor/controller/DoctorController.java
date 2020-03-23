package com.user.doctor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/3 11:05
 * @Version: 0.0.1
 */
@Controller
@RequestMapping("/doctor")
@Api(value = "医务人员管理", description = "医务人员管理接口")
public class DoctorController {

    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    @ApiOperation(value = "添加角色")
    @ResponseBody
    public Integer saveRole(@RequestBody Map<String,Object> map){
        return 1;
    }

}
