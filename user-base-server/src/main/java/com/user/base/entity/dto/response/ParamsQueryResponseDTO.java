package com.user.base.entity.dto.response;

import lombok.Data;

/**
 * @Authod:zeng
 * @Date: 2020/3/24 10:24
 * @Version: 0.0.1
 */
@Data
public class ParamsQueryResponseDTO {

    private Integer id;

    private Integer pid;


    private String parentKey;
    /**
     * key值
     */
    private String paramsKey;
    /**
     * value值
     */
    private String paramsValue;
    /**
     * 参数描述
     */
    private String paramsDesc;

    /**
     * 0:无效 1:有效
     */
    private Integer status;
}
