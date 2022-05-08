package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("works")
public class Works {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String cover;

    private String title;

    private String url;
}
