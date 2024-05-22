package com.study.springstudy.springmvc.chap04.common;

import lombok.*;

@Getter @Setter @ToString
@EqualsAndHashCode
public class Search extends Page {

    // 검색어, 검색조건
    private String keyword, type;

    public Search() {
        this.keyword = "";
    }
}
