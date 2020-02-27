package com.user.base.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 系统参数表
 * </p>
 *
 * @author zeng
 * @since 2020-02-26
 */
@TableName("t_sys_params")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Params implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("pid")
    private Integer pid;
    /**
     * key值
     */
    @TableField("params_key")
    private String paramsKey;
    /**
     * value值
     */
    @TableField("params_value")
    private String paramsValue;
    /**
     * 参数描述
     */
    @TableField("params_desc")
    private String paramsDesc;
    /**
     * 0:不是叶子节点 1:是
     */
    @TableField("leaf")
    private Integer leaf;
    /**
     * 0:无效 1:有效
     */
    @TableField("status")
    private Integer status;

    private Integer currentPage = 1;

    private Integer pageSize = 10;

}
