package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date; //一定是导入这个Date

@Data
@TableName("article")  //对应数据库中的article表
public class Article {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String description;

    private int commentCounts;

    private int viewCounts;

    /**
     *类别id
     */
    private Long categoryId;

    /**
     * 内容id
     */
    private Long bodyId;

    /**
     * 创建时间,自动填充时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}