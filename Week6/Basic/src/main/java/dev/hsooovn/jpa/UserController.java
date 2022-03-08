package dev.hsooovn.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(
            @Autowired UserService userService
    ){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(
            @Valid @RequestBody UserDto userDto
    ){
        this.userService.createUser(userDto);
    }

    @GetMapping("{id}")
    public UserDto readUser(
            @PathVariable("id") int id
    ){
        return this.userService.readUser(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody UserDto userDto
    ){
        this.userService.updateUser(id, userDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(
            @PathVariable("id") int id
    ){
        this.userService.deleteUser(id);
    }
}
