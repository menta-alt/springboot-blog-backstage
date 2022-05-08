package com.elvira.blog.vo.params;

import lombok.Data;

@Data
public class MsgReplyParams {
    private Long msgId;

    private String nickname;

    private String email;

    private String content;

    private String replyToWho;
}
