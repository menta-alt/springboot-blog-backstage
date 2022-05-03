package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.LogMapper;
import com.elvira.blog.pojo.Log;
import com.elvira.blog.service.LogService;
import com.elvira.blog.vo.LogVo;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.LogParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    //发布日志
    @Override
    public Result publish(LogParams logParams) {
        Log log = new Log();
        log.setDescription(logParams.getDescription());
        logMapper.insert(log);

        LogVo logVo = new LogVo();
        logVo.setId(log.getId().toString());
        logVo.setDescription(log.getDescription());
        logVo.setCreateTime(log.getCreateTime());
        return Result.success(logVo);
    }

    @Override
    public Result getLogs() {
        LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Log::getCreateTime);
        List<Log> logs = logMapper.selectList(queryWrapper);
        return Result.success(logs);
    }

    @Override
    public Result deleteLogById(Long logId) {
        logMapper.deleteById(logId);
        return Result.success(null);
    }
}
