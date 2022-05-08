package com.elvira.blog.controller;

import com.elvira.blog.service.CommentService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CommentParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 发布评论
     * @Params: commentParams
     * @Return Result.success(commentVo)
     */
    @PostMapping("/comments/publish")
    public Result publish(@RequestBody CommentParams commentParams){
        return commentService.publish(commentParams);
    }

    /**
     * 获取指定层级的所有的评论
     * @Params: commentParams
     * @Return Result.success(commentVo)
     */
    @PostMapping("/comments")
    public Result getComments(@RequestBody CommentParams commentParams){
        return commentService.getComments(commentParams);
    }

}
