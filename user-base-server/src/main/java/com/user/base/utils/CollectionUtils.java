package com.user.base.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
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
