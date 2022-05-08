package com.elvira.blog.controller;

import com.elvira.blog.service.WorksService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.WorksParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorksController {
    @Autowired
    private WorksService worksService;

    /**
     * 发布标签
     * @Params: worksService
     * @Return Result.success(worksVo)
     */
    @PostMapping("/works/publish")
    public Result publish(@RequestBody WorksParams worksParams){
        return worksService.publish(worksParams);
    }

    /**
     * 获取所有的标签
     * @Params: null
     * @Return Result.success(works)所有的标签
     */
    @GetMapping("/works")
    public Result worksList(){
        return worksService.getWorks();
    }


    /**
     * 删除指定标签
     * @Params: worksId
     * @Return null
     */
    @PostMapping("/content/works/{id}")
    public Result deleteWorksById(@PathVariable("id") Long worksId){
        return worksService.deleteWorksById(worksId);
    }
}
