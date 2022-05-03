package com.elvira.blog.controller;

import com.elvira.blog.service.CategoryService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CategoryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 发布标签
     * @Params: 请求体 CategoryParams
     * @Return
     */
    @PostMapping("/categories/publish")
    public Result publish(@RequestBody CategoryParams categoryParams){

        return categoryService.publish(categoryParams);
    }

    /**
     * 获取专栏列表
     * @Return
     */
    @GetMapping("/categories")
    public Result categoriesList(){
        return categoryService.getCategory();
    }

    /**
     * 获取指定id的专栏信息
     * @Return
     */
    @PostMapping("/categoryName")
    public Result getCategoryName(@RequestBody CategoryParams categoryParams){
        return categoryService.getCategoryName(categoryParams.getCategoryId());
    }

    /**
     * 删除指定专栏
     * @Params: categoryId
     * @Return null
     */
    @PostMapping("/content/category/{id}")
    public Result deleteCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.deleteCategoryById(categoryId);
    }
}
