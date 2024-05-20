package com.study.springstudy.springmvc.chap04.entity;

import com.study.springstudy.springmvc.chap04.dto.BoardPostDto;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*
    CREATE TABLE tbl_board (
    board_no INT(8) PRIMARY KEY auto_increment,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    writer VARCHAR(100) NOT NULL,
    view_count INT(8) DEFAULT 0,
    reg_date_time DATETIME DEFAULT current_timestamp
    );
 */

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private int boardNo; // 게시글 번호
    private String title; // 글제목
    private String content; // 글내용
    private String writer; // 작성자명
    private int viewCount; // 조회수
    private LocalDateTime regDateTime; // 작성일시

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.writer = rs.getString("writer");
        this.viewCount = rs.getInt("view_count");
        this.regDateTime = rs.getTimestamp("reg_date_time").toLocalDateTime();
    }

    public Board(BoardPostDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writer = dto.getWriter();
    }


    // 엔터티는 DB와 소통 - 민감한 정보를 담고 있기 때문에 화면에 보여줄 땐 (클라이언트와 소통할 땐) dto 사용하는게 좋다.
//    public String getRegDateTimeFormatted() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        return regDateTime.format(formatter);
//    }
//
//    public String truncateTitle() {
//        if (title.length() > 7) {
//            return title.substring(0, 7) + "...";
//        }
//        return title;
//    }
//    public String truncateContent() {
//        if (content.length() > 30) {
//            return content.substring(0, 30) + "...";
//        }
//        return content;
//    }
}
