package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CommentParams;

public interface CommentService {
    /**
     * 发布评论
     * @Params: commentParams
     * @Return Result.success(commentVo)
     */
    Result publish(CommentParams commentParams);

    /**
     * 获取指定层级的所有的评论
     * @Params: level
     * @Return Result.success(commentVo)
     */
    Result getComments(CommentParams commentParams);
}
