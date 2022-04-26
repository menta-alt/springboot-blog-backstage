package com.elvira.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elvira.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
