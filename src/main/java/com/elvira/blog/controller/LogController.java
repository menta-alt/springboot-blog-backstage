package com.elvira.blog.controller;

import com.elvira.blog.service.LogService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.LogParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 发布日志
     * @Params:
     * @Return
     */
    @PostMapping("/logs/publish")
    public Result publish(@RequestBody LogParams logParams){
        return logService.publish(logParams);
    }

    /**
     * 获取日志列表
     */
    @GetMapping("/logs")
    public Result logsList(){
        return logService.getLogs();
    }

    /**
     * 删除指定日志
     * @Params:
     * @Return
     */
    @PostMapping("/content/log/{id}")
    public Result deletelogById(@PathVariable("id") Long logId){
        return logService.deleteLogById(logId);
    }
}
