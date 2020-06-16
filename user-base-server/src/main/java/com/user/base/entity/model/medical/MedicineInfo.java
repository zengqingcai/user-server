package com.user.base.entity.model.medical;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 药物详细信息
 * </p>
 *
 * @author zeng
 * @since 2020-03-30
 */
@TableName("t_bu_medicine_info")
public class MedicineInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("medicine_base_id")
    private Long medicineBaseId;
    /**
     * 介绍
     */
    private String introduction;
    /**
     * 功效
     */
    private String efficacy;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 单位
     */
    private Integer unit;
    /**
     * 生产时间
     */
    @TableField("production_time")
    private Date productionTime;
    /**
     * 生成地址
     */
    @TableField("production_addr")
    private Date productionAddr;
    /**
     * 公司
     */
    @TableField("production_company")
    private String productionCompany;
    /**
     * 规格1：100片/瓶
     */
    private Integer specification;
    /**
     * 形状1：颗粒 2：粉状
     */
    private Integer shape;
    /**
     * 备注
     */
    private String note;
    private Date ct;
    private Date ut;
    private Integer cid;
    private Integer uid;
    private Integer ava;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMedicineBaseId() {
        return medicineBaseId;
    }

    public void setMedicineBaseId(Long medicineBaseId) {
        this.medicineBaseId = medicineBaseId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public Date getProductionAddr() {
        return productionAddr;
    }

    public void setProductionAddr(Date productionAddr) {
        this.productionAddr = productionAddr;
    }

    public String getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(String productionCompany) {
        this.productionCompany = productionCompany;
    }

    public Integer getSpecification() {
        return specification;
    }

    public void setSpecification(Integer specification) {
        this.specification = specification;
    }

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }

    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAva() {
        return ava;
    }

    public void setAva(Integer ava) {
        this.ava = ava;
    }

    @Override
    public String toString() {
        return "MedicineInfo{" +
        ", id=" + id +
        ", medicineBaseId=" + medicineBaseId +
        ", introduction=" + introduction +
        ", efficacy=" + efficacy +
        ", price=" + price +
        ", unit=" + unit +
        ", productionTime=" + productionTime +
        ", productionAddr=" + productionAddr +
        ", productionCompany=" + productionCompany +
        ", specification=" + specification +
        ", shape=" + shape +
        ", note=" + note +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }
}
