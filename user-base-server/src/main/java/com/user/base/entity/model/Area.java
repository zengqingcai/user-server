package com.user.base.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author zeng
 * @since 2020-02-28
 */
@TableName("t_sys_area")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父级id
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 0:国 1:省 2:市 3:区
     */
    private Integer type;
}
