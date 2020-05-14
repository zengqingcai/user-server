package com.user.general.entity.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zeng
 * @since 2020-03-26
 */
@TableName("t_bu_user_message")
@Data
public class UserMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 消息类型
     */
    @TableField("message_type")
    private Integer messageType;
    /**
     * 0:未读 1:已读
     */
    @TableField("read_flag")
    private Integer readFlag;
    /**
     * 标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    private Date ct;
    private Date ut;
    private Long cid;
    private Long uid;
    private Integer ava;



    @Override
    public String toString() {
        return "TBuUserMessage{" +
        ", id=" + id +
        ", userId=" + userId +
        ", messageType=" + messageType +
        ", readFlag=" + readFlag +
        ", title=" + title +
        ", content=" + content +
        ", ct=" + ct +
        ", ut=" + ut +
        ", cid=" + cid +
        ", uid=" + uid +
        ", ava=" + ava +
        "}";
    }
}
