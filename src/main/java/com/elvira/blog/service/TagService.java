package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.TagParams;

public interface TagService {
    /**
     * 发布标签服务
     * @Params: tagParams
     * @Return Result.success(tagVo)
     */
    Result publish(TagParams tagParams);

    /**
     * 获取tags列表
     * @Params:
     * @Return Result.success(tags)所有的标签
     */
    Result getTags();

    /**
     * 根据id删除标签
     * @Params: tagId
     * @Return null
     */
    Result deleteTagById(Long tagId);

    /**
     *
     * @Params: tagId
     * @Return
     */
    Result getTagInfo(Long articleId);
}
