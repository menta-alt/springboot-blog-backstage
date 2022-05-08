package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.CommentMapper;
import com.elvira.blog.pojo.Comment;
import com.elvira.blog.pojo.Message;
import com.elvira.blog.service.CommentService;
import com.elvira.blog.vo.CommentVo;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.CommentParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Result publish(CommentParams commentParams) {
        Comment comment = new Comment();
        comment.setArticleId(commentParams.getArticleId());
        comment.setParentId(commentParams.getParentId());
        comment.setNickname(commentParams.getNickname());
        comment.setEmail(commentParams.getEmail());
        comment.setContent(commentParams.getContent());
        comment.setReplyToWho(commentParams.getReplyToWho());
        comment.setLevel(commentParams.getLevel());
        commentMapper.insert(comment);

        CommentVo commentVo = new CommentVo();
        commentVo.setId(comment.getId().toString());
        commentVo.setArticleId(comment.getArticleId());
        commentVo.setParentId(comment.getParentId());
        commentVo.setNickname(comment.getNickname());
        commentVo.setEmail(comment.getEmail());
        commentVo.setCreateTime(comment.getCreateTime());
        commentVo.setContent(comment.getContent());
        commentVo.setReplyToWho(comment.getReplyToWho());
        commentVo.setLevel(comment.getLevel());

        return Result.success(commentVo);
    }

    @Override
    public Result getComments(CommentParams commentParams) {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getLevel, commentParams.getLevel())
                    .eq(Comment::getArticleId, commentParams.getArticleId());
        if(commentParams.getLevel() == 1) {
            queryWrapper.orderByDesc(Comment::getCreateTime);
        }
        List<Comment> comments = commentMapper.selectList(queryWrapper);
        return Result.success(comments);
    }
}
