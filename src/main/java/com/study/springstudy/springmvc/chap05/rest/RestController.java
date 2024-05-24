package com.study.springstudy.springmvc.chap05.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/rest")
@Controller
public class RestController {

    @GetMapping("/rest/hello")
    @ResponseBody // 서버가 클라이언트에게 순수한 데이터를 전달할 때 사용
    public String hello() {

        return "안녕하세요 헤헤";
    }

    @GetMapping("/hobby")
    @ResponseBody
    public List<String> hobby() {
        List<String> hobbies = List.of("잠자기", "숨쉬기", "누워있기", "가만히있기");
        return hobbies;
    }

}
