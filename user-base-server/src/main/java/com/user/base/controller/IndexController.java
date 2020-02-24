package com.user.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex(ModelMap map) {
        map.put("imgSrc","http://img.citygopass.cn/images/20180716/b8c5992bb7a540909b6dec94662f1f8051.png");
        return "index2";
    }
}
