package com.user.doctor.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 医生详细信息
 * </p>
 *
 * @author zeng
 * @since 2020-03-03
 */
@TableName("t_bu_doctor_detail")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    @TableField("doctor_info_id")
    private Long doctorInfoId;
    /**
     * 毕业院校
     */
    private String graduated;
    /**
     * 身份证号码
     */
    @TableField("id_card")
    private String idCard;


    private LocalDateTime ct;


    private Integer cid;
    private LocalDateTime ut;
    private Integer uid;
    private Integer status;
}
