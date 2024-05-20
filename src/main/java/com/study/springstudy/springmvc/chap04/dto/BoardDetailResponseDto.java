package com.study.springstudy.springmvc.chap04.dto;

import com.study.springstudy.springmvc.chap04.entity.Board;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter @Setter
public class BoardDetailResponseDto {

    private int boardNo;
    private String writer;
    private String title;
    private String content;
    private String regDateTime;

    public BoardDetailResponseDto(Board b) {
        this.boardNo = b.getBoardNo();
        this.writer = b.getWriter();
        this.title = b.getTitle();
        this.content = b.getContent();

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 a hh시 mm분");
        this.regDateTime = pattern.format(b.getRegDateTime());
    }
}
