package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardPostDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
public class BoardController {

    // 의존객체
    private final BoardRepository repository;

    // 1. 목록 조회 요청 (/board/list : GET)
    @GetMapping("/list")
    public String list(Model model) {
        // 1. 데이터베이스로부터 게시글 목록 조회
        List<Board> boardList = repository.findAll();

        // 2. 클라이언트에 데이터를 보내기 전에 렌더링에 필요한 데이터만 추출하기

        List<BoardListResponseDto> bList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

//        List< BoardListResponseDto> bList = new ArrayList<>();
//
//        for (Board b : boardList) {
//            BoardListResponseDto dto = new BoardListResponseDto(b);
//            bList.add(dto);
//        }

        // 3. jsp파일에 해당 목록데이터를 보냄
        model.addAttribute("bList", bList);
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
    public String register(BoardPostDto dto) {
//        Board board = new Board(dto);
        Board board = dto.toEntity();
        repository.save(board);
        return "redirect:/board/list";
    }

    // 4. 게시글 삭제 요청 (/board/delete : GET)
    // -> 목록조회 요청 리다이렉션
    @GetMapping("/delete")
    public String delete(int bno) {
        repository.delete(bno);
        return "redirect:/board/list";
    }

    // 5. 게시글 상세 조회 요청 (/board/detail : GET)
    @GetMapping("/detail")
    public String read(int bno, Model model) {
        Board b = repository.findOne(bno);
        if (b != null) repository.upViewCount(bno);
        model.addAttribute("b", new BoardDetailResponseDto(b));
        return "board/detail";
    }

}


