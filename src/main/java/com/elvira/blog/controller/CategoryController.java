package com.elvira.blog.controller;

import com.elvira.blog.service.CategoryService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CategoryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 发布标签
     * @Params: 请求体 CategoryParams
     * @Return
     */
    @PostMapping("/publish")
    public Result publish(@RequestBody CategoryParams categoryParams){

        return categoryService.publish(categoryParams);
    }

    /**
     * 获取标签列表
     * @Return
     */
    @GetMapping
    public Result categoriesList(){
        return categoryService.getCategory();
    }
}
