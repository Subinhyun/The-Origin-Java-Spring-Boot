package com.example.basicMission2.board;

import com.example.basicMission2.board.BoardDto;

import java.util.List;

public interface BoardRepository {
    boolean save(BoardDto dto);
    BoardDto findByID(int board_id);
    boolean update(int board_id, BoardDto dto);
    boolean delete(int board_id);
}
