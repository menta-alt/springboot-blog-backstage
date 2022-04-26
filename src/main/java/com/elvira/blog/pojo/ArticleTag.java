package com.elvira.blog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("article_tag")
public class ArticleTag {

    private Long id;

    private Long articleId;

    private Long tagId;
}
