package com.user.base.test;

import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * todo 标签：List根据对象属性排序 List根据对象属性去重
 * List<T>集合根据某个属性排序
 * 根据某个重复的属性去重
 */
@Data
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(){}

    //todo 排序
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1, "Mahesh", 12));
        list.add(new Student(2, "Suresh", 15));
        list.add(new Student(3, "Nilesh", 10));
        list.add(new Student(4, "Nilesh", 14));

        System.out.println("---Natural Sorting by Name---");
        List<Student> slist = list.stream().sorted().collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Natural Sorting by Name in reverse order---");
        slist = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Sorting using Comparator by Age---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Sorting using Comparator by Age with reverse order---");
        slist = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));


        System.out.println("---Sorting using Comparator by Id---");
        slist = list.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));

        System.out.println("---Sorting using Comparator by Id with reverse order---");
        slist = list.stream().sorted(Comparator.comparing(Student::getId).reversed()).collect(Collectors.toList());
        slist.forEach(e -> System.out.println("Id:"+ e.getId()+", Name: "+e.getName()+", Age:"+e.getAge()));


        List<String> list1 = Arrays.asList("azc","abc","aac","bbc","eax");
        //Collections.sort(list1);
        //Collections.reverse(list1);
        Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);

        List<Integer> list2 = Arrays.asList(1,23,442,11,10);

        //Collections.sort(list2);
        Collections.sort(list2,Collections.reverseOrder());

        System.out.println(list2);

        //另类排序
        /**
         *
         * List<Edmtickettypetab> list = productAll;
             Collections.sort(list,new Comparator<Edmtickettypetab>() {
             public int compare(Edmtickettypetab o1, Edmtickettypetab o2) {
             return o1.getStrbycategorytype().compareTo(o2.getStrbycategorytype());
             }
           });
         */

        List<Student> quiList =
                list.stream().filter(distinctByKey(Student::getName)).collect(Collectors.toList());

        System.out.println("list");
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }

//    @Override
//　　public int compareTo(User user) {        //重写Comparable接口的compareTo方法，
//　　　　return this.age - user.getAge();　　// 根据年龄升序排列，降序修改相减顺序即可
//　　}

//    Collections.sort(list, new Comparator<User>() {
//　　　　@Override
//　　　　public int compare(User u1, User u2) {
//　　　　　　int diff = u1.getAge() - u2.getAge();
//　　　　　　if (diff > 0) {
//　　　　　　　　return 1;
//　　　　　　}else if (diff < 0) {
//　　　　　　　　return -1;
//　　　　　　}
//　　　　　　return 0; //相等为0
//　　　　}
//　　}); // 按年龄排序
//　　System.out.println(list.toString());
}
