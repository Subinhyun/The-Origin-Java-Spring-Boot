package dev.hsooovn.basicMission2.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
public class BoardRestController {
    private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
    private final BoardService boardService;

    public BoardRestController(
            @Autowired BoardService boardService
    ){
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody BoardDto boardDto){
        logger.info(boardDto.toString());
        this.boardService.createBoard(boardDto);
    }

    @GetMapping("{id}")
    public BoardDto readBoard(@PathVariable("id") int board_id){
        logger.info("in read board");
        return this.boardService.readBoard(board_id);
    }

    @PutMapping("{board_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(
            @PathVariable("board_id") int id,
            @RequestBody BoardDto boardDto
    ){
        logger.info("target board_id: " + id);
        logger.info("update content " + boardDto);
        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{board_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("board_id") int board_id) {
        this.boardService.deleteBoard(board_id);
    }
}
