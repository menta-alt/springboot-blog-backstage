package com.elvira.blog.controller;

import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
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
     * 首页文章列表
     */
    @PostMapping("/hot")
    public Result ArticleList(@RequestBody PageParams pageParams){
        System.out.println("pageParams:"+ pageParams);
        return articleService.listArticle(pageParams);
    }
}
