package com.example.basicMission2.post;

import com.example.basicMission2.post.PostDto;

import java.util.List;

public interface PostRepository {
    boolean save(PostDto dto);
    List<PostDto> findAll();
    PostDto findByID(int id);
    boolean update(int id, PostDto dto);
    boolean delete(int id);
}
