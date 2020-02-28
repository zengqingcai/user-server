package com.user.base.controller;

import com.user.base.comm.CodeMsg;
import com.user.base.entity.model.Permission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 专门用于git使用测试用的代码
 */
@RequestMapping(value = "/api/notneedlogin")
@Controller
public class GitTestController {


    @RequestMapping(value = "doTest114",method = RequestMethod.GET)
    @ResponseBody
    public CodeMsg doUploadPermission14(@RequestBody Permission permission){
        if(permission == null)
            return null;
        System.out.println("========doTest14,name:"+permission.getName());
        CodeMsg codeMsg = new CodeMsg("2002222","修改成功12345");
        return codeMsg;
    }
}
