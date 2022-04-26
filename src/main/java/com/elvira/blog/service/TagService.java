package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.TagParams;

public interface TagService {
    /**
     * 发布文章服务
     * @Params: tagParams
     * @Return Result
     */
    Result publish(TagParams tagParams);

    /**
     * 获取tags列表
     * @Params:
     * @Return Result
     */
    Result getTags();

}
