package dev.hsooovn.jpa;

import com.google.gson.Gson;
import dev.hsooovn.jpa.aspect.LogExecutionTime;
import dev.hsooovn.jpa.aspect.LogArguments;
import dev.hsooovn.jpa.aspect.LogReturn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final Gson gson;

    public PostController(
            @Autowired PostService postService,
            @Autowired Gson gson
    ){
      this.postService = postService;
      logger.info(gson.toString());
//      this.gson = gson.getGson();
    }

    @LogArguments
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @Valid @RequestBody PostDto postDto
    ){
        this.postService.createPost(postDto);
    }

    @LogReturn
    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        return this.postService.readPost(id);
    }

    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll(){
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        this.postService.deletePost(id);
    }

    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto dto){
        logger.warn(dto.toString());
    }
}
