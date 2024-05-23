package com.study.springstudy.springmvc.chap05;

import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import com.study.springstudy.springmvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired BoardMapper boardMapper;
    @Autowired ReplyMapper replyMapper;

//    @Test
//    @DisplayName("")
//    void bulkInsert() {
//        // 게시물 100개와 댓글 5000개를 랜덤으로 등록
//        for (int i = 1; i <= 100; i++) {
//            Board b = Board.builder()
//                    .title("글제목 " + i)
//                    .writer("글쓴이 " + i)
//                    .content("내용" + i)
//                    .build();
//
//            boardMapper.save(b);
//        }
//
//        for (int i = 1; i <= 5000; i++) {
//            Reply r = Reply.builder()
//                    .replyText("댓글 " + i)
//                    .replyWriter("댓글 작성자 " + i)
//                    .boardNo((long) (Math.random() * 100 + 1))
//                    .build();
//
//            replyMapper.save(r);
//        }
//    }

    @Test
    @DisplayName("전체조회")
    void findAllTest() {
        //given
        long boardNo = 1;
        //when
        List<Reply> replies = replyMapper.findAll(boardNo);
        //then
        replies.forEach(System.out::println);
    }
    
    @Test
    @DisplayName("댓글 삭제")
    void deleteTest() {
        //given
        long replyNo = 1;
        //when
        replyMapper.delete(replyNo);
        //then
    }

    @Test
    @DisplayName("수정")
    void modifyTest() {
        //given
        long replyNo = 2;
        Reply reply = Reply.builder()
                .replyNo(replyNo)
                .replyText("수정2")
                .build();
        //when
        replyMapper.modify(reply);
        //then
    }

}