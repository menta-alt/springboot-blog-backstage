package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.PageParams;

public interface ArticleService {

    /**
     * 分页查询 最热文章列表
     * @Params: pageParams
     * @Return
     */
    Result listHotArticle(PageParams pageParams);

    /**
     * 分页查询 最新文章列表
     * @Params: pageParams
     * @Return
     */
    Result listRecentArticle(PageParams pageParams);

    /**
     * 发布文章服务
     * @Params: articleParams
     * @Return
     */
    Result publish(ArticleParams articleParams);
}
