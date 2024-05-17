package com.study.springstudy.springmvc.chap04.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardPostDto {
    private String title;
    private String writer;
    private String content;
}
