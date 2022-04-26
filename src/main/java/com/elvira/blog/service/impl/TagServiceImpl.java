package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.TagMapper;
import com.elvira.blog.pojo.Tag;
import com.elvira.blog.service.TagService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.TagVo;
import com.elvira.blog.vo.params.TagParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;

    //发布标签
    @Override
    public Result publish(TagParams tagParams) {
        Tag tag = new Tag();
        tag.setTagName(tagParams.getTagName());
        tagMapper.insert(tag);

        TagVo tagVo = new TagVo();
        tagVo.setId(tag.getId().toString());
        tagVo.setTagName(tag.getTagName());
        tagVo.setCreateTime(tag.getCreateTime());
        return Result.success(tagVo);
    }

    @Override
    public Result getTags() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        return Result.success(tags);
    }
}
