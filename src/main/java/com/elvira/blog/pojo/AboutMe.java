package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("aboutme")
public class AboutMe {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String content;

    private String contentHtml;
}
