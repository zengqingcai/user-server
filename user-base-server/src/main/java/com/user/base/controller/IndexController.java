package com.user.base.controller;

import com.user.base.test.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex(ModelMap map) {
        return "index";
    }


    //加载权限数据
    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    @ResponseBody
    public Object index2() {
        List<Menu> list = new ArrayList<>();
        Menu menu1 = new Menu();
        list.add(menu1);
        menu1.setId("1");
        menu1.setText("普通用户管理");
        menu1.setIcon("fa fa-user-circle-o fa-fw");
        List<Menu> menuList1 = new ArrayList<>();
        menu1.setMenus(menuList1);
        Menu menu11 = new Menu();
        menuList1.add(menu11);
        menu11.setId("11");
        menu11.setText("用户列表");
        menu11.setIcon("fa fa-group fa-fw");
        menu11.setUrl("/app/user/userList");
        Menu menu12 = new Menu();
        menuList1.add(menu12);
        menu12.setId("12");
        menu12.setText("用户注册");
        menu12.setIcon("fa fa-group fa-fw");
        menu12.setUrl("/emp/empAdd");
        Menu menu2 = new Menu();
        list.add(menu2);
        menu2.setId("1");
        menu2.setText("平台用户管理");
        menu2.setIcon("fa fa-user-circle-o fa-fw");
        menu2.setUrl("/sys/user/userList");

        return list;
    }
}
