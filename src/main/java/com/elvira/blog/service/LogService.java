package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.LogParams;

public interface LogService {
    /**
     * 发布日志服务
     * @Params: logParams
     * @Return Result
     */
    Result publish(LogParams logParams);

    /**
     * 获取日志列表
     * @Params:
     * @Return Result
     */
    Result getLogs();

    Result deleteLogById(Long logId);
}
