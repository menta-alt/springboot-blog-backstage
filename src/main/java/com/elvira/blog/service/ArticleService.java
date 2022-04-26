package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.PageParams;

public interface ArticleService {

    /**
     * 分页查询 文章列表
     * @Params: pageParams
     * @Return
     */

    Result listArticle(PageParams pageParams);
}
