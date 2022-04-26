package com.elvira.blog.controller;

import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 首页最热文章列表
     */
    @PostMapping("/hot")
    public Result hotArticleList(@RequestBody PageParams pageParams){
        return articleService.listHotArticle(pageParams);
    }

    /**
     * 首页最新文章列表
     */
    @PostMapping("/recent")
    public Result recentArticleList(@RequestBody PageParams pageParams){
        return articleService.listRecentArticle(pageParams);
    }

    /**
     * 文章发布
     * @Params:
     * @Return
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody ArticleParams articleParams){
        System.out.println("pageParams:"+ articleParams);
        return articleService.publish(articleParams);
    }


}
