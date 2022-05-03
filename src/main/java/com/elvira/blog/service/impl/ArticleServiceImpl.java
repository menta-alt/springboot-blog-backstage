package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elvira.blog.mapper.*;
import com.elvira.blog.pojo.*;
import com.elvira.blog.service.ArticleService;
import com.elvira.blog.vo.Result;
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
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;

    @Override
    public Result getAllArticles() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(articles);
    }

    @Override
    public Result listHotArticle(PageParams pageParams) {
        // 分页查询 article 数据库表
        LambdaQueryWrapper<Article> hotArticleLambdaQueryWrapper = new LambdaQueryWrapper<>(); //条件构造器
        hotArticleLambdaQueryWrapper.orderByDesc(Article::getViewCounts);
        Page<Article> hotArticlePage = new Page<>(pageParams.getPage(),10);
        IPage<Article> hotArticleIPage = articleMapper.selectPage(hotArticlePage, hotArticleLambdaQueryWrapper);
        return Result.success(hotArticleIPage.getRecords());
    }

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
        // 查询专栏对应的id
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryName,articleParams.getCategoryName())
                    .select(Category::getId);
        List<Category> categoryIdList = categoryMapper.selectList(categoryLambdaQueryWrapper);
        Long categoryId = categoryIdList.get(0).getId();

        //查询标签对应的id
        LambdaQueryWrapper<Tag> tagLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tagLambdaQueryWrapper.in(Tag::getTagName, articleParams.getTagsName())
                             .select(Tag::getId);
        List<Tag> tagsList = tagMapper.selectList(tagLambdaQueryWrapper);

        Article article = new Article();
        article.setTitle(articleParams.getTitle());
        article.setDescription(articleParams.getSummary());
        article.setCommentCounts(0);
        article.setViewCounts(0);
        article.setCategoryId(categoryId);

        //插入之后 会生成一个文章id
        this.articleMapper.insert(article);
        //tag
        if (tagsList != null){
            for (Tag tag : tagsList) {
                Long articleId = article.getId();
                ArticleTag articleTag = new ArticleTag(); //article和tag的关联表结构
                articleTag.setArticleId(articleId);
                articleTag.setTagId(tag.getId());
                articleTagMapper.insert(articleTag);
            }
        }

        //articleBody
        ArticleBody articleBody  = new ArticleBody();
        articleBody.setArticleId(article.getId());
        articleBody.setContent(articleParams.getBody().getContent());
        articleBody.setContentHtml(articleParams.getBody().getContentHtml());
        articleBodyMapper.insert(articleBody);

        //body
        article.setBodyId(articleBody.getId());
        articleMapper.updateById(article);

        Map<String,String> map = new HashMap<>();
        map.put("article_id",article.getId().toString());
        return Result.success(map);
    }

    @Override
    public Result deleteBlogById(Long articleId) {
        articleMapper.deleteById(articleId);

        Map<String, Object> articleTagMap = new HashMap<String, Object>();
        articleTagMap.put("article_id", articleId);
        articleTagMapper.deleteByMap(articleTagMap);

        Map<String, Object> articleBodyMap = new HashMap<String, Object>();
        articleBodyMap.put("article_id", articleId);
        articleBodyMapper.deleteByMap(articleBodyMap);

        return Result.success(null);
    }

    @Override
    public Result findArticleById(Long articleId) {
        // 根据id查询文章内容
        LambdaQueryWrapper<ArticleBody> articleBodyQueryWrapper = new LambdaQueryWrapper<>();
        articleBodyQueryWrapper.eq(ArticleBody::getArticleId, articleId);
        List<ArticleBody> bodyList = articleBodyMapper.selectList(articleBodyQueryWrapper);

        return Result.success(bodyList.get(0));
    }

}
