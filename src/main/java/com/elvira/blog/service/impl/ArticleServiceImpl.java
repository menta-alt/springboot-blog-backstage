package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elvira.blog.mapper.ArticleMapper;
import com.elvira.blog.pojo.Article;
import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result listArticle(PageParams pageParams) {
        /**
         * 1.分页查询 article 数据库表
         */
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper = new LambdaQueryWrapper<>(); //条件构造器
        Page<Article> userPage = new Page<>(pageParams.getPage(),10);
        IPage<Article> userIPage = articleMapper.selectPage(userPage, articleLambdaQueryWrapper);
        return Result.success(userIPage.getRecords());
    }

}
