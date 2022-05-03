package com.elvira.blog.vo.params;

import com.elvira.blog.pojo.Category;
import com.elvira.blog.pojo.Tag;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParams {
    private Long articleId;

    private String title;

    private ArticleBodyParams body;

    private String categoryName;

    private String summary;

    private List<String> tagsName;

}
