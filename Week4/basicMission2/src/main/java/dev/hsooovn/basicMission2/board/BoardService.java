package dev.hsooovn.basicMission2.board;

public interface BoardService {
    void createBoard(BoardDto dto);
    BoardDto readBoard(int board_id);
    void updateBoard(int board_id, BoardDto dto);
    void deleteBoard(int board_id);
}
