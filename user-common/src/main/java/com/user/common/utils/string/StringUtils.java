package com.user.common.utils.string;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

/**
 * @Authod:zeng
 * @Date: 2020/3/25 8:50
 * @Version: 0.0.1
 */
public class StringUtils {


    /**
     * new String[]{"1003","1004"} ==> '1003','1004'
     * @param strArr
     * @return
     */
    public static String getStrByStrArr(String[] strArr){

        if(strArr==null || strArr.length==0)
            return "";
        StringBuilder stringBuilder = new StringBuilder("");
        for(String string:strArr){
            stringBuilder.append("'"+string+"',");
        }
        return stringBuilder.toString().substring(0,stringBuilder.toString().length()-1);
    }



    /**
     * 001,002 ===> '001','002'
     * @param string
     * @return
     */
    public static String getStrByStr(String string){
        String seqSql ="";
        if(string.indexOf(",")!=-1){
            String[] seqs = string.split(",");
            for (int j = 0; j < seqs.length; j++) {
                if (j == 0) {
                    seqSql = "'" + seqs[0] + "'";
                } else {
                    seqSql = seqSql + ",'" + seqs[j] + "'";
                }
            }
        } else {
            seqSql ="'" + string + "'";
        }
        return seqSql;
    }


    /**
     *
     * @param plArr
     * @param orderArr
     * @return
     */
    public static boolean useLoop2(String[] plArr, String[] orderArr) {
        boolean flag = false;
        if(plArr.length>orderArr.length)
            return false;
        for (int j = 0; j < plArr.length; j++) {
            flag=false;//重新置为false
            for (int k = 0; k < orderArr.length; k++) {
                if (plArr[j].equals(orderArr[k])) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                break;
        }
        return flag;
    }


    public static boolean useLoop(String[] plArr, String[] orderArr) {
        boolean flag = false;
        for (int i = 0; i < plArr.length; i++) {
            for (int j = 0; j < orderArr.length; j++) {
                if (plArr[i].equals(orderArr[j])) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if(flag)
                break;
        }
        return flag;
    }


    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public static String getUuidWithoutOne(){
        String uuid = UUID.randomUUID().toString()
                .replaceAll("-", "");
        return uuid;
    }



    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    public static String getSmsCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.println("短信验证码："+random);
        return random;
    }





    public static void main(String[] args) {
        System.out.println(getStrByStr("1001,1002"));
        System.out.println(getStrByStrArr(new String[]{"1003","1004"}));

        List<String> list = new ArrayList<>();
        list.contains("");
        Collections.sort(list);

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("uuid:"+uuid);

    }




}
