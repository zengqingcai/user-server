package com.user.common.enums.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/27 16:14
 * @Version: 0.0.1
 */
public enum OrderBussEnum {

    PYA_ORDER("2","pay"),
    MEDICINE_ORDER("1","MEDICINE");

    private String bussIndex;

    private String bussName;

    public String getBussIndex() {
        return bussIndex;
    }

    public void setBussIndex(String bussIndex) {
        this.bussIndex = bussIndex;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }

    OrderBussEnum(String bussIndex, String bussName) {
        this.bussIndex = bussIndex;
        this.bussName = bussName;
    }

    public static Map<String, String> convertToMap() {
        Map<String,String> map = new HashMap<>();
        OrderBussEnum[] orderBussEnums = OrderBussEnum.values();
        for(OrderBussEnum orderBussEnum:orderBussEnums){
            map.put(orderBussEnum.getBussIndex(),orderBussEnum.getBussName());
        }
        return map;
    }
}
