package com.user.base.test;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * todo 标签：List<T> 根据属性分组
 */
@Data
public class PersonData {
    private String id;
    private String type;
    private String name;
    private int age;

    public static void main(String[] args){
        List<PersonData> list = new ArrayList<PersonData>();
        PersonData p1 = new PersonData();
        p1.setId("1");
        p1.setName("张三");
        p1.setType("管理员");
        p1.setAge(20);
        list.add(p1);

        PersonData p2 = new PersonData();
        p2.setId("2");
        p2.setName("李四");
        p2.setType("管理员");
        p2.setAge(30);
        list.add(p2);

        PersonData p3 = new PersonData();
        p3.setId("3");
        p3.setName("王五");
        p3.setType("用户");
        p3.setAge(40);
        list.add(p3);

        PersonData p4 = new PersonData();
        p4.setId("4");
        p4.setName("马六");
        p4.setType("访客");
        p4.setAge(50);
        list.add(p4);

        //跟据某个属性分组
        Map<String, List<PersonData>> collect = list.stream().collect(Collectors.groupingBy(PersonData::getType));
        System.out.println(collect);

        //根据某个属性分组，汇总某个属性
        Map<String, Integer> collect2 = list.stream().collect(Collectors.groupingBy(PersonData::getType,Collectors.summingInt(PersonData::getAge)));
        System.out.println(collect2);

        //根据某个属性添加条件过滤数据，
        list = list.stream().filter(u -> !u.getType().equals("访客")).collect(Collectors.toList());
        System.out.println(list);

        //判断一组对象里面有没有属性值是某个值
        boolean add = list.stream().anyMatch(m -> "王五".equals(m.getName()));
        System.out.println(add);

        //取出一组对象的某个属性组成一个新集合
        List<String> names=list.stream().map(PersonData::getName).collect(Collectors.toList());
        System.out.println(names);
    }
}
