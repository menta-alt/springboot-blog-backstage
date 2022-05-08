package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("message")
public class Message {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickname;

    private String email;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
