package dev.hsooovn.mybatis.mapper;

import dev.hsooovn.mybatis.dto.BoardDto;

public interface BoardMapper {
    int createBoard(BoardDto dto);
}
