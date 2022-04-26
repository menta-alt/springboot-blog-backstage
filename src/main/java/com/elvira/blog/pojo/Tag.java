package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tag")
public class Tag {

    /**
     * @TableId(type = IdType.AUTO) 使用数据库自增id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String tagName;

    /**
     * 创建时间,自动填充时间
     */

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}