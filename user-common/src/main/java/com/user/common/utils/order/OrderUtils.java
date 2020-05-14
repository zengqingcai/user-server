package com.user.common.utils.order;

import com.user.common.enums.order.OrderBussEnum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Authod:zeng
 * @Date: 2020/3/27 16:09
 * @Version: 0.0.1
 */
public class OrderUtils {

    /**
     * 根据业务代码生成唯一订单号
     * @param orderBuss
     * @return
     */
    public static String generalOrder(OrderBussEnum orderBuss){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime dateTime = LocalDateTime.now();
        int random = (int)(Math.random()*1000)+100;
        return orderBuss.getBussName()+dateTime.format(df)+random;
    }

}
