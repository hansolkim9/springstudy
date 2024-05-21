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
    @DisplayName("전체조회")
    void findAllTest() {
        //given
        
        //when
        List<Board> all = mapper.findAll();
        //then
        System.out.println("all = " + all);
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