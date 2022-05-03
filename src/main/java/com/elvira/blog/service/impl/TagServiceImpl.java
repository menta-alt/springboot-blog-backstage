package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.ArticleTagMapper;
import com.elvira.blog.mapper.TagMapper;
import com.elvira.blog.pojo.ArticleTag;
import com.elvira.blog.pojo.Category;
import com.elvira.blog.pojo.Tag;
import com.elvira.blog.service.TagService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.TagVo;
import com.elvira.blog.vo.params.TagParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private ArticleTagMapper articleTagMapper;

    //发布标签
    @Override
    public Result publish(TagParams tagParams) {
        Tag tag = new Tag();
        tag.setTagName(tagParams.getTagName());
        tagMapper.insert(tag);

        TagVo tagVo = new TagVo();
        tagVo.setId(tag.getId().toString());
        tagVo.setTagName(tag.getTagName());
        tagVo.setCreateTime(tag.getCreateTime());
        return Result.success(tagVo);
    }

    @Override
    public Result getTags() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Tag::getCreateTime);
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        return Result.success(tags);
    }

    @Override
    public Result deleteTagById(Long tagId) {
        tagMapper.deleteById(tagId);
        return Result.success(null);
    }

    @Override
    public Result getTagInfo(Long articleId) {
        LambdaQueryWrapper<ArticleTag> articleTagQueryWrapper = new LambdaQueryWrapper<>();
        articleTagQueryWrapper.eq(ArticleTag::getArticleId, articleId)
                              .select(ArticleTag::getTagId);
        List<ArticleTag> articleTagsList = articleTagMapper.selectList(articleTagQueryWrapper);
        List<Long> tagsIdList = new ArrayList<>();
        // 获取指定文章id所对应的所有的标签id
        if (articleTagsList != null){
            for (ArticleTag articleTag : articleTagsList) {
                tagsIdList.add(articleTag.getTagId());
            }
        }

        LambdaQueryWrapper<Tag> tagQueryWrapper = new LambdaQueryWrapper<>();
        tagQueryWrapper.in(Tag::getId, tagsIdList)
                       .select(Tag::getTagName);
        List<Tag> tagsList = tagMapper.selectList(tagQueryWrapper);
        List<String> tagsNameList = new ArrayList<>();
        if (tagsList != null){
            for (Tag tag : tagsList) {
                tagsNameList.add(tag.getTagName());
            }
        }
        return Result.success(tagsNameList);
    }
}
