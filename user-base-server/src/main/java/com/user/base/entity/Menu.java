package com.user.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/30 11:01
 * @Version: 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu {

    private String id;

    private String text;

    private String icon;//'fa fa-user-circle-o fa-fw' && 'fa fa-group fa-fw'

    private String url;

    private List<Menu> menus;

    public static List<Menu> initMenu(){
        //普通用户管理
        Menu menu11 = new Menu("11","用户列表","fa fa-group fa-fw","/app/user/userList",null);
        Menu menu12 = new Menu("12","用户注册","fa fa-group fa-fw","/emp/empAdd",null);
        List<Menu> list1 = Arrays.asList(menu11,menu12);
        Menu menu1 = new Menu("1","普通用户管理","fa fa-user-circle-o fa-fw","",list1);

        //平台用户管理
        Menu menu21 = new Menu("21","用户列表","fa fa-group fa-fw","/sys/user/userList",null);
        Menu menu22 = new Menu("22","用户注册","fa fa-group fa-fw","/emp/empAdd",null);
        List<Menu> list2 = Arrays.asList(menu21,menu22);
        Menu menu2 = new Menu("2","普通用户管理","fa fa-user-circle-o fa-fw","",list2);

        //医疗配置管理
        Menu menu31 = new Menu("11","医药分类","fa fa-group fa-fw","/medical/medicalCategoryList",null);
        Menu menu32 = new Menu("12","医药配置","fa fa-group fa-fw","/medicine/medicineBaseList",null);
        List<Menu> list3 = Arrays.asList(menu31,menu32);
        Menu menu3 = new Menu("1","医疗配置管理","fa fa-user-circle-o fa-fw","",list3);

        //医院配置管理
        Menu menu41 = new Menu("31","医院分类","fa fa-group fa-fw","/medical/medicalCategoryList",null);
        Menu menu42 = new Menu("32","医院管理","fa fa-group fa-fw","/hospital/findPage",null);
        List<Menu> list4 = Arrays.asList(menu41,menu42);
        Menu menu4 = new Menu("3","医院配置管理","fa fa-user-circle-o fa-fw","",list4);
        //医生配置管理4

        //




        List<Menu> result = new ArrayList<>();
        result.add(menu1);
        result.add(menu2);
        result.add(menu3);
        result.add(menu4);
        return result;
    }

}
