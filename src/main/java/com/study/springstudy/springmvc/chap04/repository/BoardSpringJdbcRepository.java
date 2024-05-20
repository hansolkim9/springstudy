package com.study.springstudy.springmvc.chap04.repository;

import com.study.springstudy.springmvc.chap04.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardSpringJdbcRepository implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM tbl_board";
        return template.query(sql, (rs, rowNum) -> new Board(rs));
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM tbl_board WHERE board_no = ?";
        Board board = template.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
        // 게시물 상세 조회 시 조회수 +1 시키기
        String update = "UPDATE tbl_board SET view_count = view_count + 1 WHERE board_no = ?";
        template.update(update, boardNo);

        return board;
    }

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO tbl_board (writer, title, content) VALUES (?, ?, ?)";
        return template.update(sql, board.getWriter(), board.getTitle(), board.getContent()) == 1;
    }

    @Override
    public boolean delete(int boardNo) {
        String sql = "DELETE FROM tbl_board WHERE board_no = ?";
        return template.update(sql, boardNo) == 1;
    }
}
