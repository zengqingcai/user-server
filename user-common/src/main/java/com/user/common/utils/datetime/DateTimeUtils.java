package com.user.common.utils.datetime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2019/12/6 17:11
 * @Version: 0.0.1
 */
public class DateTimeUtils {

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    private static final String LONG_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    public static String getNowString(String formate){
        if(formate == null || formate.equals("")){
            formate = DateTimeUtils.DEFAULT_DATE_TIME_FORMAT;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formate);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dtf);
    }

    public static String getNowString(){
        String formate = DateTimeUtils.DEFAULT_DATE_TIME_FORMAT;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formate);
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(dtf);
    }

    public static String getTodayString(){
        DateTimeFormatter dtf =
                DateTimeFormatter.ofPattern(DateTimeUtils.DEFAULT_DATE_FORMAT);
        LocalDate localDate = LocalDate.now();
        return localDate.format(dtf);
    }

    public static String getTodayString(String formate){
        if(formate==null || "".equals(formate)){
            formate = DateTimeUtils.DEFAULT_DATE_FORMAT;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formate);
        LocalDate localDate = LocalDate.now();
        return localDate.format(dtf);
    }

    //时间的加减乘除 时间差值 时间的格式化(long string date) 时间戳的处理 时间的比较
    public static void main1111(String[] args) {
        System.out.println(getNowString(DateTimeUtils.DEFAULT_DATE_TIME_FORMAT));
        System.out.println(getNowString(DateTimeUtils.DEFAULT_DATE_FORMAT));
        System.out.println(getNowString(DateTimeUtils.LONG_DATE_TIME_FORMAT));
        System.out.println(getNowString(DateTimeUtils.SIMPLE_DATE_TIME_FORMAT));
        System.out.println(getNowString(DateTimeUtils.DEFAULT_TIME_FORMAT));
        System.out.println(getNowString("yyyy/MM/dd HH/mm/ss"));
        System.out.println(getNowString(""));
        System.out.println(getTodayString(DEFAULT_DATE_FORMAT));
        //2020-04-23T10:00:00.000Z
        //2020-04-28T09:33:07.460Z
        System.out.println("adsf1qw".indexOf("1qw"));

        List<String> list = null;
        list.removeIf(a->a.contains(""));

    }


    //不能小于当前时间
    public static boolean compareNow(Date dateTime){
        return dateTime.before(new Date());
    }

    public static void main(String[] args) {
        System.out.println();
    }

    //结束时间大于开始时间



    // 01. java.util.Date --> java.time.LocalDateTime
    public static LocalDateTime UDateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    // 02. java.util.Date --> java.time.LocalDate
    public static LocalDate UDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    // 03. java.util.Date --> java.time.LocalTime
    public void UDateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    //long --> date
    public Date long2Date(long timestamp,String formate){
        if(formate == null || formate.equals("")){
            formate = DateTimeUtils.DEFAULT_DATE_TIME_FORMAT;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(formate);
        Date date = new Date(timestamp);
        return date;
    }

    //date-->long
    public Long date2Long(Date date){
        return date.getTime();

    }

}
