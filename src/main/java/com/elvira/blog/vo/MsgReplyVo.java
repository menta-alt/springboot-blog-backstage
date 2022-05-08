package com.elvira.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class MsgReplyVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    @JsonSerialize(using = ToStringSerializer.class)
    private String msgId;

    private String nickname;

    private String email;

    private String content;

    private String replyToWho;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
