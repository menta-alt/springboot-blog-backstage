package com.elvira.blog.controller;

import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 获取所有文章，不分页
     * @Params:null
     * @Return
     */
    @GetMapping("/articles")
    public Result articlesList(){
        return articleService.getAllArticles();
    }


    /**
     * 首页最热文章列表，分页
     */
    @PostMapping("/articles/hot")
    public Result hotArticleList(@RequestBody PageParams pageParams){
        return articleService.listHotArticle(pageParams);
    }

    /**
     * 首页最新文章列表，分页
     */
    @PostMapping("/articles/recent")
    public Result recentArticleList(@RequestBody PageParams pageParams){
        return articleService.listRecentArticle(pageParams);
    }

    /**
     * 根据文章内容id获取文章详情
     * @Params:
     * @Return
     */
    @PostMapping("/articles/details/{articleId}")
    public Result findArticleById(@PathVariable("articleId") Long articleId){
        return articleService.findArticleById(articleId);
    }

    /**
     * 文章发布
     * @Params:
     * @Return
     */
    @PostMapping("/articles/publish")
    public Result publish(@RequestBody ArticleParams articleParams){
        return articleService.publish(articleParams);
    }

    /**
     * 根据id删除指定文章
     * @Params:articleId
     * @Return:null
     */
    @PostMapping("/content/blog/{articleId}")
    public Result deleteBlogById(@PathVariable Long articleId){
        return articleService.deleteBlogById(articleId);
    }

}
