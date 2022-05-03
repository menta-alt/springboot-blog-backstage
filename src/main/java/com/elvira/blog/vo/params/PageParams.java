package com.elvira.blog.vo.params;

import lombok.Data;

@Data
public class PageParams {

    private int page;

    private int pageSize = 10;
}
