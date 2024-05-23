package com.study.springstudy.springmvc.chap05.entity;

/*

    CREATE TABLE tbl_reply (
        reply_no INT(8) PRIMARY KEY auto_increment,
        reply_text VARCHAR(1000) NOT NULL,
        reply_writer VARCHAR(100) NOT NULL,
        reply_date DATETIME DEFAULT CURRENT_TIMESTAMP,
        board_no INT(8),
        constraint fk_reply
        foreign key (board_no)
        references tbl_board (board_no)
        on delete cascade
    );

 */

import lombok.*;

import java.time.LocalDateTime;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    private long replyNo;
    private String replyText;
    private String replyWriter;
    private LocalDateTime replyDate;
    private long boardNo;

}
