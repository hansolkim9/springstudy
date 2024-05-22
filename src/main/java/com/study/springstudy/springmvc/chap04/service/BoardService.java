package com.study.springstudy.springmvc.chap04.service;

import com.study.springstudy.springmvc.chap04.common.Page;
import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper mapper;

    // 목록 조회 엔터티 -> dto
    public List<BoardListResponseDto> getBoardList(Page page) {
        List<Board> boardList = mapper.findAll(page);

        // 조회해온 게시물 리스트에서 각 게시물들의 조회수를 확인하여
        // 조회수가 5 이상인 게시물에 특정 마킹
        List<BoardListResponseDto> dtoList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

        return dtoList;
    }

    // 상세조회
    public BoardDetailResponseDto getBoardDetail(int boardNo) {
        Board board = mapper.findOne(boardNo);
        return new BoardDetailResponseDto(board);
    }

    // 게시물 등록
    public boolean save(Board board) {
        return mapper.save(board);
    }

    // 게시물 삭제
    public boolean delete(int boardNo) {
        return mapper.delete(boardNo);
    }

    // 조회수 상승
    public void viewCount(int boardNo) {
        mapper.upViewCount(boardNo);
    }


}
