package com.elvira.blog.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class WorksVo {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;

    private String cover;

    private String title;

    private String url;
}
