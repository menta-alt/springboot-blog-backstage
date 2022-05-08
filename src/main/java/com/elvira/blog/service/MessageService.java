package com.elvira.blog.service;

import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.MessageParams;
import com.elvira.blog.vo.params.MsgReplyParams;

public interface MessageService {
    /**
     * 发布留言服务
     * @Params: messageParams
     * @Return Result.success(messageVo)
     */
    Result publish(MessageParams messageParams);

    /**
     * 发布对应留言的回复
     * @Params: msgReplyParams
     * @Return Result.success(messageVo)
     */
    Result replyPublish(MsgReplyParams msgReplyParams);

    /**
     * 获取所有的留言
     * @Params: null
     * @Return Result.success(messages)
     */
    Result getMessages();

    /**
     * 删除指定留言
     * @Params: messageId
     * @Return null
     */
    Result deleteTagById(Long messageId);

    /**
     * 获取留言所有的留言
     * @Params: null
     * @Return Result.success(msgReply)
     */
    Result getMsgReplies();
}
