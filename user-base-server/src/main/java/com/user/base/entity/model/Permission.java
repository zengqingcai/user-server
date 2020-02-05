package com.user.base.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父节点ID
     */
    @TableField("parent_id")
    private Integer parentId;
    /**
     * 权限代码
     */
    private String code;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 图标url
     */
    private String icon;
    /**
     * 功能url
     */
    private String url;
    /**
     * 权限类型 0:菜单  1:按钮 2:超链接
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 使用状态(0:禁用 1:有效)
     */
    private Integer status;
    /**
     * 备注描述
     */
    private String description;
    /**
     * 操作时间
     */
    @TableField("operate_time")
    private Date operateTime;


    /**
     * 当前页码
     */
    private Integer currentPage = 1;

    /**
     * 每页记录数
     */
    private Integer pageSize = 10;


    @Override
    public String toString() {
        return "TSysPermission{" +
                ", id=" + id +
                ", parentId=" + parentId +
                ", code=" + code +
                ", name=" + name +
                ", icon=" + icon +
                ", url=" + url +
                ", type=" + type +
                ", sort=" + sort +
                ", status=" + status +
                ", description=" + description +
                ", operateTime=" + operateTime +
                "}";
    }

}