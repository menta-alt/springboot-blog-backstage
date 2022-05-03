package com.elvira.blog.controller;

import com.elvira.blog.pojo.Tag;
import com.elvira.blog.service.TagService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleParams;
import com.elvira.blog.vo.params.TagParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 发布标签
     * @Params: tagParams
     * @Return Result.success(tagVo)
     */
    @PostMapping("/tags/publish")
    public Result publish(@RequestBody TagParams tagParams){
        return tagService.publish(tagParams);
    }

    /**
     * 获取所有的标签
     * @Params: null
     * @Return Result.success(tags)所有的标签
     */
    @GetMapping("/tags")
    public Result tagsList(){
        return tagService.getTags();
    }

    /**
     * 获取指定的标签信息
     * @Params:
     * @Return
     */
    @PostMapping("/tagsName")
    public Result getTagInfo(@RequestBody ArticleParams articleParams){
        return tagService.getTagInfo(articleParams.getArticleId());
    }


    /**
     * 删除指定标签
     * @Params: tagId
     * @Return null
     */
    @PostMapping("/content/tag/{id}")
    public Result deleteTagById(@PathVariable("id") Long tagId){
        return tagService.deleteTagById(tagId);
    }

}
