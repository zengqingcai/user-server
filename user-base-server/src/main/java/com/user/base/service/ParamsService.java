package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.comm.CodeMsg;
import com.user.base.entity.model.Params;
import com.user.base.entity.model.Role;

import java.io.Serializable;

/**
 * <p>
 * 系统参数表 服务类
 * </p>
 *
 * @author zeng
 * @since 2020-02-26
 */
public interface ParamsService{

    PageInfo<Params> findPage(Params params);


    Params selectById(Integer id);


    CodeMsg saveParams(Params params);


    CodeMsg updateParams(Params params);


    String getValueByKey(String paramsKey);
}
