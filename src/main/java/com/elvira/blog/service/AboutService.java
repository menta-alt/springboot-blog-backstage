package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleBodyParams;

public interface AboutService {
    /**
     * 发布关于我
     * @Params:articleBodyParams
     * @Return:null
     */
    Result publishAboutMe(ArticleBodyParams articleBodyParams);

    /**
     * 发布关于
     * @Params:articleBodyParams
     * @Return:null
     */
    Result publishAboutSite(ArticleBodyParams articleBodyParams);

    /**
     * 获取关于我
     * @Params:
     * @Return
     */
    Result getAboutMe();

    /**
     * 获取关于站点
     * @Params:
     * @Return
     */
    Result getAboutSite();
}
