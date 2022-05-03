package com.elvira.blog.vo.params;

import lombok.Data;

@Data
public class ArticleBodyParams {

    // markdown 源码
    private String content;

    // 源码转为 html 的内容
    private String contentHtml;

}
