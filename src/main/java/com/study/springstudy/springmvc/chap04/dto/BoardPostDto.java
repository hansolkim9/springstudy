package com.study.springstudy.springmvc.chap04.dto;

import com.study.springstudy.springmvc.chap04.entity.Board;
import lombok.Getter;
import lombok.Setter;

// dto는 클라이언트와 소통(jsp 등..)
// dto의 필드명은 반드시 html form태그의 입력태그들 name속성과 일치해야 한다.
@Getter @Setter
public class BoardPostDto {
    private String title;
    private String writer;
    private String content;

    public Board toEntity() {
        Board board = new Board();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        return board;
    }
}
