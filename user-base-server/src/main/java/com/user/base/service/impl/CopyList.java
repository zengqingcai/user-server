package com.user.base.service.impl;

import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

/**
 * @Authod:zeng
 * @Date: 2020/3/24 10:47
 * @Version: 0.0.1
 */
public class CopyList<T extends Object,T2 extends Object> {


    public void copyList(Class<T> obj,List<T> destList,List<T2> orgList)throws Exception{
        for(T2 t2:orgList){
            T dest = obj.newInstance();
            BeanUtils.copyProperties(dest,t2);
            destList.add(dest);
        }
    }



    CopyList(Class<T> obj,List<T> destList,List<T2> orgList){
        try {
            //copyList(obj,destList,orgList);
            for(T2 t2:orgList){
                T dest = obj.newInstance();
                BeanUtils.copyProperties(dest,t2);
                destList.add(dest);
            }
        }catch (Exception e){

        }

    }

    CopyList(){}
}
