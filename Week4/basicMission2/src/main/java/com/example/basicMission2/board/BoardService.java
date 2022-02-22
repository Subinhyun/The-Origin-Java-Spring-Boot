package com.example.basicMission2.board;

import com.example.basicMission2.board.BoardDto;

public interface BoardService {
    void createBoard(BoardDto dto);
    BoardDto readBoard(int board_id);
    void updateBoard(int board_id, BoardDto dto);
    void deleteBoard(int board_id);
}
