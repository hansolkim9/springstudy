package com.study.springstudy.springmvc.chap04.service;

import com.study.springstudy.springmvc.chap04.common.Search;
import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardFindAllDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import com.study.springstudy.springmvc.chap05.mapper.ReplyMapper;
import com.study.springstudy.springmvc.chap05.entity.Reply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardMapper boardMapper;
    private final ReplyMapper replyMapper;

    // 목록 조회 엔터티 -> dto
    public List<BoardListResponseDto> getBoardList(Search page) {
        List<BoardFindAllDto> boardList = boardMapper.findAll(page);

        // 조회해온 게시물 리스트에서 각 게시물들의 조회수를 확인하여
        // 조회수가 5 이상인 게시물에 특정 마킹
        List<BoardListResponseDto> dtoList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

        return dtoList;
    }

    // 상세조회
    public BoardDetailResponseDto getBoardDetail(int boardNo) {
        Board board = boardMapper.findOne(boardNo);

        // 댓글 목록 조회
//        List<Reply> replies = replyMapper.findAll(boardNo);

        BoardDetailResponseDto responseDto = new BoardDetailResponseDto(board);
//        responseDto.setReplies(replies);

        return responseDto;
    }

    // 게시물 등록
    public boolean save(Board board) {
        return boardMapper.save(board);
    }

    // 게시물 삭제
    public boolean delete(int boardNo) {
        return boardMapper.delete(boardNo);
    }

    // 조회수 상승
    public void viewCount(int boardNo) {
        boardMapper.upViewCount(boardNo);
    }


    public int getCount(Search search) {
        return boardMapper.count(search);
    }

}
