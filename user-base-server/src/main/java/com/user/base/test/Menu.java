package com.user.base.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/2 10:08
 * @Version: 0.0.1
 */
@Data
public class Menu {

    private String id;

    private String text;

    private String icon;

    private String url = "";

    private List<Menu> menus = new ArrayList<>();

}
