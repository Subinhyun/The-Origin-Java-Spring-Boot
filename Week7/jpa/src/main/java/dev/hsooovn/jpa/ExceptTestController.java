package dev.hsooovn.jpa;

import dev.hsooovn.jpa.exception.BaseException;
import dev.hsooovn.jpa.exception.ErrorResponseDto;
import dev.hsooovn.jpa.exception.PostNotInBoadException;
import dev.hsooovn.jpa.exception.PostNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id){
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoadException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDto handleBaseException(BaseException exception){
//        return new ErrorResponseDto(exception.getMessage());
//    }
}
