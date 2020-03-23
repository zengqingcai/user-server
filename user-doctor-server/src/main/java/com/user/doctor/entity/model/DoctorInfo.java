package com.user.doctor.entity.model;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 
 * </p>
 *
 * @author zeng
 * @since 2020-03-03
 */
@TableName("t_bu_doctor_info")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DoctorInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 姓名
     */
    private String name;


    private String phone;
    /**
     * 0 男 1 女
     */
    private Integer sex;


    private Integer age;
    /**
     * 0 外科
     */
    private Integer type;


    private LocalDateTime ct;
    /**
     * 0代表本人
     */
    private Integer cid;


    private LocalDateTime ut;
    /**
     * 0代表本人
     */
    private Integer uid;
    /**
     * 0无效1有效
     */
    private Integer status;
}
