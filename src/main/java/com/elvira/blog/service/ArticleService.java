package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.PageParams;

public interface ArticleService {
    /**
     * 不分页，获取所有文章
     * @Params: null
     * @Return
     */
    Result getAllArticles();

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

    /**
     * 根据id删除指定文章
     * @Params: articleId
     * @Return null
     */
    Result deleteBlogById(Long articleId);

    /**
     * 根据文章内容id获取文章详情
     * @Params:articleId
     * @Return
     */
    Result findArticleById(Long articleId);
}
