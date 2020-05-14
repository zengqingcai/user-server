package com.user.common.utils.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Authod:zeng
 * @Date: 2020/5/3 15:00
 * @Version: 0.0.1
 * 正则表达式
 */
public class Regex {


    public static boolean regex4CellPhone(String phone){
        if(phone.length() != 11){
            return false;
        }else{
            String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if(isMatch){
                System.out.println("您的手机号" + phone + "是正确格式@——@");
                return true;
            } else {
                System.out.println("您的手机号" + phone + "是错误格式！！！");
                return false;
            }
        }
    }


    public static void main(String[] args) {

        System.out.println(regex4CellPhone("1354425841"));

    }
}
