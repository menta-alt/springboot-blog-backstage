package com.elvira.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.elvira.blog.mapper.MessageMapper;
import com.elvira.blog.mapper.MsgReplyMapper;
import com.elvira.blog.pojo.Message;
import com.elvira.blog.pojo.MsgReply;
import com.elvira.blog.service.MessageService;
import com.elvira.blog.vo.MsgReplyVo;
import com.elvira.blog.vo.Result;
import com.elvira.blog.vo.params.MessageParams;
import com.elvira.blog.vo.MessageVo;
import com.elvira.blog.vo.params.MsgReplyParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MsgReplyMapper msgReplyMapper;

    @Override
    public Result publish(MessageParams messageParams) {
        Message message = new Message();
        message.setNickname(messageParams.getNickname());
        message.setEmail(messageParams.getEmail());
        message.setContent(messageParams.getContent());
        messageMapper.insert(message);

        MessageVo messageVo = new MessageVo();
        messageVo.setId(message.getId().toString());
        messageVo.setNickname(message.getNickname());
        messageVo.setEmail(message.getEmail());
        messageVo.setContent(message.getContent());
        messageVo.setCreateTime(message.getCreateTime());
        return Result.success(messageVo);
    }

    @Override
    public Result replyPublish(MsgReplyParams msgReplyParams) {
        MsgReply msgReply = new MsgReply();
        msgReply.setMsgId(msgReplyParams.getMsgId());
        msgReply.setNickname(msgReplyParams.getNickname());
        msgReply.setEmail(msgReplyParams.getEmail());
        msgReply.setContent(msgReplyParams.getContent());
        msgReply.setReplyToWho(msgReplyParams.getReplyToWho());
        msgReplyMapper.insert(msgReply);

        MsgReplyVo msgReplyVo = new MsgReplyVo();
        msgReplyVo.setId(msgReply.getId().toString());
        msgReplyVo.setMsgId(msgReply.getMsgId().toString());
        msgReplyVo.setNickname(msgReply.getNickname());
        msgReplyVo.setEmail(msgReply.getEmail());
        msgReplyVo.setContent(msgReply.getContent());
        msgReplyVo.setReplyToWho(msgReply.getReplyToWho());
        msgReplyVo.setCreateTime(msgReply.getCreateTime());

        return Result.success(msgReplyVo);
    }

    @Override
    public Result getMessages() {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Message::getCreateTime);
        List<Message> messages = messageMapper.selectList(queryWrapper);
        return Result.success(messages);
    }

    @Override
    public Result deleteTagById(Long messageId) {
        messageMapper.deleteById(messageId);
        return Result.success(null);
    }

    @Override
    public Result getMsgReplies() {
        LambdaQueryWrapper<MsgReply> queryWrapper = new LambdaQueryWrapper<>();
        List<MsgReply> msgReplies = msgReplyMapper.selectList(queryWrapper);
        return Result.success(msgReplies);
    }
}
