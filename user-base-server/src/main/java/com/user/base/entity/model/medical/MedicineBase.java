package com.user.base.entity.model.medical;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 药品信息表
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@TableName("t_bu_medicine_base")
public class MedicineBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 医疗分类id
     */
    @TableField("medical_category_id")
    private Integer medicalCategoryId;
    /**
     * 药品名称
     */
    @TableField("medicine_name")
    private String medicineName;
    /**
     * 药品编码
     */
    @TableField("medicine_code")
    private String medicineCode;
    /**
     * 1：启用 0：禁用
     */
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMedicalCategoryId() {
        return medicalCategoryId;
    }

    public void setMedicalCategoryId(Integer medicalCategoryId) {
        this.medicalCategoryId = medicalCategoryId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(String medicineCode) {
        this.medicineCode = medicineCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TBuMedicineBase{" +
        ", id=" + id +
        ", medicalCategoryId=" + medicalCategoryId +
        ", medicineName=" + medicineName +
        ", medicineCode=" + medicineCode +
        ", status=" + status +
        "}";
    }
}
