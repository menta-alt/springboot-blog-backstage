package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.WorksParams;

public interface WorksService {

    /**
     * 发布标签
     * @Params: worksService
     * @Return Result.success(worksVo)
     */
    Result publish(WorksParams worksParams);

    /**
     * 获取所有的标签
     * @Params: null
     * @Return Result.success(works)所有的标签
     */
    Result getWorks();

    /**
     * 删除指定标签
     * @Params: tagId
     * @Return null
     */
    Result deleteWorksById(Long worksId);
}
