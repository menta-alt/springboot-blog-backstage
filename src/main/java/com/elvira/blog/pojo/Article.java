package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date; //一定要导入这个Date！！

@Data
@TableName("article")  //user对应数据库中的表
public class Article {

    private Long id;

    private String title;

    private String description;

    private int commentCounts;

    private int viewCounts;

    /**
     * 内容id
     */
    private Long contentId;
    /**
     *类别id
     */
    private Long categoryId;

    private Long tagId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}