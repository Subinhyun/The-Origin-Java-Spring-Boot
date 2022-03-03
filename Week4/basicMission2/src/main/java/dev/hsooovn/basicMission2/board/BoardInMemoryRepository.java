package dev.hsooovn.basicMission2.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BoardInMemoryRepository implements BoardRepository {
    private static final Logger logger = LoggerFactory.getLogger(BoardInMemoryRepository.class);
    private final List<BoardDto> boardList;

    public BoardInMemoryRepository() {
        this.boardList = new ArrayList<>();
    }

    @Override
    public boolean save(BoardDto dto) {
        return this.boardList.add(dto);
    }

    @Override
    public BoardDto findByID(int board_id) {
        return this.boardList.get(board_id);
    }

    @Override
    public boolean update(int board_id, BoardDto boardDto) {
        BoardDto targetBoard = this.boardList.get(board_id);
        if (boardDto.getBoard_id() != null){
            targetBoard.setBoard_id(boardDto.getBoard_id());
        }
        this.boardList.set(board_id, targetBoard);
        return true;
    }

    @Override
    public boolean delete(int board_id) {
        this.boardList.remove(board_id);
        return true;
    }
}
