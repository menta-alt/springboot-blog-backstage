package com.elvira.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elvira.blog.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
