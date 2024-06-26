package com.study.springstudy.springmvc.chap04.mapper;

import com.study.springstudy.springmvc.chap04.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("")
    void insertTest() {
        for (int i = 1; i <= 300; i++) {
            Board b = new Board();
            b.setTitle("테스트제목"+i);
            b.setWriter("테스트작성자"+i);
            b.setContent("내용"+i);

            mapper.save(b);
        }
    }
    
    @Test
    @DisplayName("상세조회")
    void findOneTest() {
        //given
        int boardNo = 5;
        //when
        Board one = mapper.findOne(boardNo);
        //then
        System.out.println("one = " + one);
    }

}