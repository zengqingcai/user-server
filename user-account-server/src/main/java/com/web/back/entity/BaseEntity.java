package com.web.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: liqun
 * @since: 2018/9/25:10:05
 * @description: 基础实体类
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * type:为主键生成策略
     */
    @TableId(type = IdType.AUTO)
    private Long id;
}
