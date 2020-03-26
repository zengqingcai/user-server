package com.user.base.entity.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Authod:zeng
 * @Date: 2020/3/24 10:07
 * @Version: 0.0.1
 */
@Data
public class ParamsQueryRequestDTO implements Serializable {

        private static final long serialVersionUID = 1L;

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



        private Integer currentPage = 1;



        private Integer pageSize = 10;
}
