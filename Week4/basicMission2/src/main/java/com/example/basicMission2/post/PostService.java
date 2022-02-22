package com.example.basicMission2.post;

import com.example.basicMission2.post.PostDto;

import java.util.List;

public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id, String password);
}
