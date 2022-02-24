package com.example.basicMissionanswer.controller;

import com.example.basicMissionanswer.model.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("board/{boardId}/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    public PostController(){

    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @PathVariable("boardId") Long boardId
    ){
        PostDto result = null;
        return null;
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostDto> readPost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId
    ){
        return null;
    }

    @GetMapping
    public ResponseEntity<Collection<PostDto>> readPostAll(
            @PathVariable("boardId") Long boardId
    ){
        return null;
    }

    @PutMapping("{postId}")
    public ResponseEntity<?> updatePost(
            @PathVariable("boardId") Long boardId
    ){
        return null;
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(
            @PathVariable("boardId") Long boardId,
            @PathVariable("postId") Long postId,
            @PathVariable("password") String password
    ){
        return null;
    }
}
