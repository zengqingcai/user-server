package com.user.base.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * todo 标签： List<String>去重
 * 集合工具类
 */
public class CollectionUtils {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("b");
        list.add("a");

        Set<String> set = new HashSet<String>(list);
        System.out.println("helr");

        List<String> unique = list.stream().distinct().collect(Collectors.toList());


    }


}
