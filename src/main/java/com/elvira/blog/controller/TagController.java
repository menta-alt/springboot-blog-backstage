package com.elvira.blog.controller;

import com.elvira.blog.service.TagService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.TagParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 发布标签
     * @Params:
     * @Return
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody TagParams tagParams){
        return tagService.publish(tagParams);
    }

    /**
     * 获取标签列表
     * @Params:
     * @Return
     */
    @GetMapping
    public Result tagsList(){
        return tagService.getTags();
    }

}
