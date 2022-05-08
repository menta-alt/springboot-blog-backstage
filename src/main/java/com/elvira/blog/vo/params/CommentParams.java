package com.elvira.blog.vo.params;

import lombok.Data;

@Data
public class CommentParams {
    private Long articleId;

    private Long parentId;

    private String nickname;

    private String email;

    private String content;

    private String replyToWho;

    private Long level;
}
