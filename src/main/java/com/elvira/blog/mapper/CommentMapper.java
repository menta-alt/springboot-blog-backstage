package com.elvira.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elvira.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
