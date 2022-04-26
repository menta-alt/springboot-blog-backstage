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
}
