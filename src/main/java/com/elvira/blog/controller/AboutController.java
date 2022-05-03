package com.elvira.blog.controller;

import com.elvira.blog.service.AboutService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.ArticleBodyParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {
    @Autowired
    private AboutService aboutService;

    /**
     * 发布关于我
     * @Params:articleBodyParams
     * @Return
     */
    @PostMapping("/aboutme/publish")
    public Result aboutMe(@RequestBody ArticleBodyParams articleBodyParams){
        return aboutService.publishAboutMe(articleBodyParams);
    }

    /**
     * 发布关于站点
     * @Params:articleBodyParams
     * @Return
     */
    @PostMapping("/aboutsite/publish")
    public Result aboutSite(@RequestBody ArticleBodyParams articleBodyParams){
        return aboutService.publishAboutSite(articleBodyParams);
    }

    /**
     * 获取关于我
     * @Params:
     * @Return
     */
    @GetMapping("/aboutme")
    public Result getAboutMe(){
        return aboutService.getAboutMe();
    }

    /**
     * 获取关于站点
     * @Params:
     * @Return
     */
    @GetMapping("/aboutsite")
    public Result getAboutSite(){
        return aboutService.getAboutSite();
    }

}
