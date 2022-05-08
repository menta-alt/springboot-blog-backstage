package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.WorksMapper;
import com.elvira.blog.pojo.Works;
import com.elvira.blog.service.WorksService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.WorksVo;
import com.elvira.blog.vo.params.WorksParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksMapper worksMapper;


    @Override
    public Result publish(WorksParams worksParams) {
        Works works = new Works();
        works.setCover(worksParams.getCover());
        works.setTitle(worksParams.getTitle());
        works.setUrl(worksParams.getUrl());
        worksMapper.insert(works);

        WorksVo worksVo = new WorksVo();
        worksVo.setId(works.getId().toString());
        worksVo.setCover(works.getCover());
        worksVo.setTitle(works.getTitle());
        worksVo.setUrl(works.getUrl());
        return Result.success(worksVo);
    }

    @Override
    public Result getWorks() {
        LambdaQueryWrapper<Works> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Works::getId);
        List<Works> works = worksMapper.selectList(queryWrapper);
        return Result.success(works);
    }

    @Override
    public Result deleteWorksById(Long worksId) {
        worksMapper.deleteById(worksId);
        return Result.success(null);
    }
}
