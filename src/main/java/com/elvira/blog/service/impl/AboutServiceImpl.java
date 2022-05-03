package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elvira.blog.mapper.AboutMeMapper;
import com.elvira.blog.mapper.AboutSiteMapper;
import com.elvira.blog.pojo.AboutMe;
import com.elvira.blog.pojo.AboutSite;
import com.elvira.blog.pojo.Article;
import com.elvira.blog.service.AboutService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleBodyParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    private AboutMeMapper aboutMeMapper;

    @Autowired
    private AboutSiteMapper aboutSiteMapper;

    @Override
    public Result publishAboutMe(ArticleBodyParams articleBodyParams) {
        LambdaQueryWrapper<AboutMe> queryWrapper = new LambdaQueryWrapper<>();
        Long count = aboutMeMapper.selectCount(queryWrapper);
        AboutMe aboutMe = new AboutMe();

        if(count == 0) {
            aboutMe.setContent(articleBodyParams.getContent());
            aboutMe.setContentHtml(articleBodyParams.getContentHtml());
            aboutMeMapper.insert(aboutMe);
        } else {
            LambdaUpdateWrapper<AboutMe> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(AboutMe::getId, 1)
                         .set(AboutMe::getContent, articleBodyParams.getContent())
                         .set(AboutMe::getContentHtml, articleBodyParams.getContentHtml());
            aboutMeMapper.update(aboutMe,updateWrapper);
        }

        return Result.success(null);
    }

    @Override
    public Result publishAboutSite(ArticleBodyParams articleBodyParams) {
        LambdaQueryWrapper<AboutSite> queryWrapper = new LambdaQueryWrapper<>();
        Long count = aboutSiteMapper.selectCount(queryWrapper);
        AboutSite aboutSite = new AboutSite();

        if(count == 0) {
            aboutSite.setContent(articleBodyParams.getContent());
            aboutSite.setContentHtml(articleBodyParams.getContentHtml());
            aboutSiteMapper.insert(aboutSite);
        } else {
            LambdaUpdateWrapper<AboutSite> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(AboutSite::getId, 1)
                         .set(AboutSite::getContent, articleBodyParams.getContent())
                         .set(AboutSite::getContentHtml, articleBodyParams.getContentHtml());
            aboutSiteMapper.update(aboutSite,updateWrapper);
        }

        return Result.success(null);
    }

    @Override
    public Result getAboutMe() {
        LambdaQueryWrapper<AboutMe> queryWrapper = new LambdaQueryWrapper<>();
        List<AboutMe> aboutme = aboutMeMapper.selectList(queryWrapper);
        if(aboutme.size() != 0) {
            AboutMe res = aboutme.get(0);
            return Result.success(res);
        } else {
            return Result.success("");
        }
    }

    @Override
    public Result getAboutSite() {
        LambdaQueryWrapper<AboutSite> queryWrapper = new LambdaQueryWrapper<>();
        List<AboutSite> aboutsite = aboutSiteMapper.selectList(queryWrapper);
        if( aboutsite.size() != 0) {
            AboutSite res = aboutsite.get(0);
            return Result.success(res);
        } else {
            return Result.success("");
        }
    }
}
