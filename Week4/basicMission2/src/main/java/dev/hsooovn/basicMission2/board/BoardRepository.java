package dev.hsooovn.basicMission2.board;

public interface BoardRepository {
    boolean save(BoardDto dto);
    BoardDto findByID(int board_id);
    boolean update(int board_id, BoardDto dto);
    boolean delete(int board_id);
}
