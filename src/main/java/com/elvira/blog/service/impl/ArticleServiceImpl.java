package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elvira.blog.mapper.ArticleBodyMapper;
import com.elvira.blog.mapper.ArticleMapper;
import com.elvira.blog.mapper.ArticleTagMapper;
import com.elvira.blog.pojo.Article;
import com.elvira.blog.pojo.ArticleBody;
import com.elvira.blog.pojo.ArticleTag;
import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.TagVo;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;
    @Autowired
    private ArticleBodyMapper articleBodyMapper;

    /**
     * 最热文章列表查询
     */
    @Override
    public Result listHotArticle(PageParams pageParams) {
        // 分页查询 article 数据库表
        LambdaQueryWrapper<Article> hotArticleLambdaQueryWrapper = new LambdaQueryWrapper<>(); //条件构造器
        hotArticleLambdaQueryWrapper.orderByDesc(Article::getViewCounts);
        Page<Article> hotArticlePage = new Page<>(pageParams.getPage(),10);
        IPage<Article> hotArticleIPage = articleMapper.selectPage(hotArticlePage, hotArticleLambdaQueryWrapper);
        return Result.success(hotArticleIPage.getRecords());
    }

    /**
     * 最新文章列表查询
     */
    @Override
    public Result listRecentArticle(PageParams pageParams) {
        LambdaQueryWrapper<Article> recentArticleLambdaQueryWrapper = new LambdaQueryWrapper<>(); //条件构造器
        recentArticleLambdaQueryWrapper.orderByDesc(Article::getCreateTime);
        Page<Article> recentArticlePage = new Page<>(pageParams.getPage(),10);
        IPage<Article> recentArticleIPage = articleMapper.selectPage(recentArticlePage, recentArticleLambdaQueryWrapper);
        return Result.success(recentArticleIPage.getRecords());
    }

    @Override
    public Result publish(ArticleParams articleParams) {
        /**
         * 1. 发布文章 目的 构建Article对象
         * 2. 作者id  当前的登录用户
         * 3. 标签  要将标签加入到 关联列表当中
         * 4. body 内容存储 article bodyId
         */
        Article article = new Article();
        article.setViewCounts(0);
        article.setTitle(articleParams.getTitle());
        article.setDescription(articleParams.getSummary());
        article.setCommentCounts(0);
        article.setCreateTime(new Date(System.currentTimeMillis()));
        article.setCategoryId(Long.parseLong(articleParams.getCategory().getId()));
        //插入之后 会生成一个文章id
        this.articleMapper.insert(article);
        //tag
        List<TagVo> tags = articleParams.getTags();
        if (tags != null){
            for (TagVo tag : tags) {
                Long articleId = article.getId();
                ArticleTag articleTag = new ArticleTag();
                articleTag.setTagId(Long.parseLong(tag.getId()));
                articleTag.setArticleId(articleId);
                articleTagMapper.insert(articleTag);
            }
        }
        //body
        ArticleBody articleBody  = new ArticleBody();
        articleBody.setArticleId(article.getId());
        articleBody.setContent(articleParams.getBody().getContent());
        articleBody.setContentHtml(articleParams.getBody().getContentHtml());
        articleBodyMapper.insert(articleBody);

        article.setBodyId(articleBody.getId());
        articleMapper.updateById(article);
        Map<String,String> map = new HashMap<>();
        map.put("id",article.getId().toString());
        return Result.success(map);
    }


}
