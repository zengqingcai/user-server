package com.user.base.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 药品分类表
 * </p>
 *
 * @author zeng
 * @since 2019-12-06
 */
@TableName("t_bu_medicine_category")
public class MedicineCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 种类编号
     */
    @TableField("category_name")
    private String categoryName;
    /**
     * 种类名称
     */
    @TableField("category_code")
    private String categoryCode;
    /**
     * 0:中药 1:西药
     */
    @TableField("category_of")
    private Boolean categoryOf;
    /**
     * 0:禁用 1:启用
     */
    private Integer status;
    private LocalDateTime ct;
    private LocalDateTime ut;
    private Long cid;
    private Long uid;
    /**
     * 0:无效 1:有效
     */
    private Boolean ava;


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

    public Boolean getCategoryOf() {
        return categoryOf;
    }

    public void setCategoryOf(Boolean categoryOf) {
        this.categoryOf = categoryOf;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCt() {
        return ct;
    }

    public void setCt(LocalDateTime ct) {
        this.ct = ct;
    }

    public LocalDateTime getUt() {
        return ut;
    }

    public void setUt(LocalDateTime ut) {
        this.ut = ut;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Boolean getAva() {
        return ava;
    }

    public void setAva(Boolean ava) {
        this.ava = ava;
    }

    @Override
    public String toString() {
        return "MedicineCategory{" +
        ", id=" + id +
        ", categoryName=" + categoryName +
        ", categoryCode=" + categoryCode +
        ", categoryOf=" + categoryOf +
        ", status=" + status +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }


    public enum MedicineCategoryStatus{

        DIS_ENABLE(0,"禁用"),
        ENABLE(1,"启用");

        private Integer status;
        private String desc;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        MedicineCategoryStatus(Integer status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        /**
         * 枚举转Map
         *
         * @return Map
         */
        public static Map<Integer, String> convertToMap() {
            Map<Integer, String> medicineCategoryStatusMap = new HashMap<Integer, String>();
            MedicineCategoryStatus[] statuses = MedicineCategoryStatus.values();
            for (MedicineCategoryStatus status : statuses) {
                medicineCategoryStatusMap.put(status.getStatus(), status.getDesc());
            }
            return medicineCategoryStatusMap;
        }
    }


}
