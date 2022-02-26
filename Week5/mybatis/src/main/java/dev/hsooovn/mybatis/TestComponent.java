package dev.hsooovn.mybatis;

import dev.hsooovn.mybatis.dao.PostDao;
import dev.hsooovn.mybatis.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    private final PostDao postDao;
    public TestComponent(
            @Autowired PostDao postDao
    ){
        this.postDao = postDao;
        PostDto newPost = new PostDto();
        newPost.setTitle("From Mybatis");
        newPost.setContent("Hello Database!");
        newPost.setWriter("hsooovn");
        newPost.setBoard(1);
        this.postDao.createPost(newPost);

        List<PostDto> postDtoList = this.postDao.readPostAll();
        System.out.println(postDtoList.get(postDtoList.size() - 1));

        PostDto firstPost = postDtoList.get(0);
        firstPost.setContent("Update From Mybatis!");
        postDao.updatePost(firstPost);

        System.out.println(this.postDao.readPost(firstPost.getId()));
    }
}
