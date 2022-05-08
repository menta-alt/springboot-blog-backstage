package com.elvira.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private Long articleId;

    private Long parentId;

    private String nickname;

    private String email;

    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private String replyToWho;

    private Long level;
}
