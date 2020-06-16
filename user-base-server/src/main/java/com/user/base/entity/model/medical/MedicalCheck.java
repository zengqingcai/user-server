package com.user.base.entity.model.medical;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 检查项目信息
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@TableName("t_bu_medical_check")
public class MedicalCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 检查项目编码
     */
    @TableField("item_code")
    private String itemCode;
    /**
     * 检查名称
     */
    @TableField("item_name")
    private String itemName;
    /**
     * 检查功能
     */
    @TableField("item_efficacy")
    private String itemEfficacy;
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEfficacy() {
        return itemEfficacy;
    }

    public void setItemEfficacy(String itemEfficacy) {
        this.itemEfficacy = itemEfficacy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MedicalCheck{" +
        ", id=" + id +
        ", itemCode=" + itemCode +
        ", itemName=" + itemName +
        ", itemEfficacy=" + itemEfficacy +
        ", status=" + status +
        "}";
    }
}
