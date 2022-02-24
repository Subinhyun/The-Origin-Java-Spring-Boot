package com.example.basicMissionanswer.repository;

import com.example.basicMissionanswer.model.BoardDto;
import com.example.basicMissionanswer.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryPostRepository implements PostRepository{
    private final BoardRepository boardRepository;

    private Long lastIndex = 0L;
    private final Map<Long, PostDto> memory = new HashMap<>();

    public InMemoryPostRepository(
            @Autowired BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Override
    public PostDto create(Long boardId, PostDto dto) {
        BoardDto boardDto = this.boardRepository.read(boardId);
        if(boardDto == null){
            return null;
        }
        dto.setBoardId(boardId);
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return null;
    }

    @Override
    public PostDto read(Long boardId, Long postId) {
        PostDto postDto = memory.getOrDefault(postId, null);
        if (postDto == null) {
            return null;
        }
        else if (!Object.equals(postDto.getBoardId(), boardId)) {
            return null;
        }
        return null;
    }

    @Override
    public Collection<PostDto> readAll(Long boadId) {
        if (boardRepository.read(boadId) == null) return null;
        return null;
    }

    @Override
    public boolean update(Long boardId, Long postId, PostDto dto) {
        return false;
    }

    @Override
    public boolean delete(Long boardId, Long postId, String password) {
        return false;
    }
}
