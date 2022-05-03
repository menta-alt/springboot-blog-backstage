package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CategoryParams;
import com.elvira.blog.vo.params.TagParams;

public interface CategoryService {
    /**
     * 发布专栏服务
     * @Params: categoryParams
     * @Return Result
     */
    Result publish(CategoryParams categoryParams);

    /**
     * 获取专栏列表
     * @Params:
     * @Return Result
     */
    Result getCategory();

    /**
     * 获取指定id的专栏名字
     * @Params:
     * @Return
     */
    Result getCategoryName(Long categoryId);

    /**
     * 根据指定id删除专栏
     * @Params:
     * @Return
     */
    Result deleteCategoryById(Long categoryId);


}
