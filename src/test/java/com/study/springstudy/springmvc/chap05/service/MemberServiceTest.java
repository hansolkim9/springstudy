package com.study.springstudy.springmvc.chap05.service;

import com.study.springstudy.springmvc.chap05.dto.request.SignUpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원가입을 하면 비밀번호가 인코딩된다.")
    void joinTest() {
        //given
        SignUpDto dto = SignUpDto.builder()
                .account("kitty")
                .password("kkk1234!")
                .email("sanrio@gmail.com")
                .name("헬로키티")
                .build();

        //when
        boolean flag = memberService.join(dto);

        //then
        assertTrue(flag);
    }

}