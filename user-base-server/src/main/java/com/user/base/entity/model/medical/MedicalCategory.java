package com.user.base.entity.model.medical;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 医疗分类表
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@TableName("t_bu_medical_category")
public class MedicalCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 种类名称
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 种类编号代码
     */
    @TableField("category_code")
    private String categoryCode;
    /**
     * 0:中药 1:西药 2:针灸
     */
    @TableField("category_of")
    private Integer categoryOf;
    /**
     * 0:禁用 1:启用
     */
    private Integer status;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getCategoryOf() {
        return categoryOf;
    }

    public void setCategoryOf(Integer categoryOf) {
        this.categoryOf = categoryOf;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MedicalCategory{" +
        ", id=" + id +
        ", categoryName=" + categoryName +
        ", categoryCode=" + categoryCode +
        ", categoryOf=" + categoryOf +
        ", status=" + status +
        "}";
    }
}
