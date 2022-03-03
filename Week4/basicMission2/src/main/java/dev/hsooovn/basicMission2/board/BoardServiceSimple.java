package dev.hsooovn.basicMission2.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceSimple implements BoardService {
    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);
    private final BoardRepository boardRepository;

    public BoardServiceSimple(
            @Autowired BoardRepository postRepository
    ) {
        this.boardRepository = postRepository;
    }

    @Override
    public void createBoard(BoardDto dto){
        // TODO
        if(!this.boardRepository.save(dto)){
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public BoardDto readBoard(int board_id) {
        return this.boardRepository.findByID(board_id);
    }

    @Override
    public void updateBoard(int board_id, BoardDto dto) {
        this.boardRepository.update(board_id, dto);
    }

    @Override
    public void deleteBoard(int board_id) {
        this.boardRepository.delete(board_id);
    }
}
