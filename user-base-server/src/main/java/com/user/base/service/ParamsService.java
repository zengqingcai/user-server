package com.user.base.service;

import com.github.pagehelper.PageInfo;
import com.user.base.common.CodeMsg;
import com.user.base.entity.dto.request.ParamsQueryRequestDTO;
import com.user.base.entity.dto.response.ParamsQueryResponseDTO;
import com.user.base.entity.model.Params;

/**
 * <p>
 * 系统参数表 服务类
 * </p>
 *
 * @author zeng
 * @since 2020-02-26
 */
public interface ParamsService{

    PageInfo<ParamsQueryResponseDTO> findPage(ParamsQueryRequestDTO params) throws Exception;

    Params selectById(Integer id);


    CodeMsg saveParams(Params params);


    CodeMsg updateParams(Params params);


    String getValueByKey(String paramsKey);
}
