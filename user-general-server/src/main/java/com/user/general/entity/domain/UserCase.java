package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zeng
 * @since 2020-03-26
 */
@TableName("t_bu_user_case")
public class UserCase implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Long userId;
    @TableField("doctor_id")
    private Long doctorId;
    @TableField("case_type")
    private Integer caseType;
    @TableField("case_content")
    private String caseContent;
    @TableField("case_sort")
    private Integer caseSort;
    private LocalDateTime ct;
    private LocalDateTime ut;
    private Integer cid;
    private Integer uid;
    private Integer ava;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getCaseType() {
        return caseType;
    }

    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public Integer getCaseSort() {
        return caseSort;
    }

    public void setCaseSort(Integer caseSort) {
        this.caseSort = caseSort;
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
        return "TBuUserCase{" +
        ", id=" + id +
        ", userId=" + userId +
        ", doctorId=" + doctorId +
        ", caseType=" + caseType +
        ", caseContent=" + caseContent +
        ", caseSort=" + caseSort +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }
}
