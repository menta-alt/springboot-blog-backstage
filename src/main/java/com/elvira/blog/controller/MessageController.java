package com.elvira.blog.controller;

import com.elvira.blog.service.MessageService;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.MessageParams;
import com.elvira.blog.vo.params.MsgReplyParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 发布留言
     * @Params: messageParams
     * @Return Result.success(messageVo)
     */
    @PostMapping("/messages/publish")
    public Result publish(@RequestBody MessageParams messageParams){
        return messageService.publish(messageParams);
    }

    /**
     * 发布对应留言的回复
     * @Params: msgReplyParams
     * @Return Result.success(messageVo)
     */
    @PostMapping("/msgReply/publish")
    public Result replyPublish(@RequestBody MsgReplyParams msgReplyParams){
        return messageService.replyPublish(msgReplyParams);
    }

    /**
     * 获取所有的留言
     * @Params: null
     * @Return Result.success(messages)
     */
    @GetMapping("/messages")
    public Result messagesList(){
        return messageService.getMessages();
    }

    /**
     * 获取留言所有的留言
     * @Params: null
     * @Return Result.success(msgReply)
     */
    @GetMapping("/messages/replies")
    public Result msgReplyList(){
        return messageService.getMsgReplies();
    }

    /**
     * 删除指定留言
     * @Params: messageId
     * @Return null
     */
    @PostMapping("/content/message/{id}")
    public Result deleteTagById(@PathVariable("id") Long messageId){
        return messageService.deleteTagById(messageId);
    }
}
