package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.common.Page;
import com.study.springstudy.springmvc.chap04.common.PageMaker;
import com.study.springstudy.springmvc.chap04.common.Search;
import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardPostDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.repository.BoardRepository;
import com.study.springstudy.springmvc.chap04.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    // 의존객체
//    private final BoardRepository repository;
    private final BoardService service;
    private final HttpSession httpSession;

    // 1. 목록 조회 요청 (/board/list : GET)
    @GetMapping("/list")
    public String list(@ModelAttribute("s") Search page, Model model) {
        // 1. 데이터베이스로부터 게시글 목록 조회
        List<BoardListResponseDto> boardList = service.getBoardList(page);

        // 페이지 정보를 생성하여 JSP에게 전송
        PageMaker maker = new PageMaker(page, service.getCount(page));

        // 3. jsp파일에 해당 목록데이터를 보냄
        model.addAttribute("bList", boardList);
        model.addAttribute("maker", maker);
//        model.addAttribute("s", page);
        return "board/list";
    }

    // 2. 게시글 쓰기 양식 화면 열기 요청 (/board/write : GET)
    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    // 3. 게시글 등록 요청 (/board/write : POST)
    // -> 목록조회 요청 리다이렉션
    @PostMapping("/write")
    public String register(BoardPostDto dto, HttpSession session) {
//        Board board = new Board(dto);
//        Board board = dto.toEntity();
        service.save(dto, session);
        return "redirect:/board/list";
    }

    // 4. 게시글 삭제 요청 (/board/delete : GET)
    // -> 목록조회 요청 리다이렉션
    @GetMapping("/delete")
    public String delete(@RequestParam int bno) {
        service.delete(bno);
        return "redirect:/board/list";
    }

    // 5. 게시글 상세 조회 요청 (/board/detail : GET)
    @GetMapping("/detail")
    public String read(int bno, Model model, HttpServletRequest request) {
        BoardDetailResponseDto b = service.getBoardDetail(bno);
        if (b != null) service.viewCount(bno);
        model.addAttribute("b", b);

        // 요청 헤더를 파싱하여 이전 페이지의 주소를 얻어냄
        String ref = request.getHeader("Referer");
        model.addAttribute("ref", ref);

        return "board/detail";
    }

}


