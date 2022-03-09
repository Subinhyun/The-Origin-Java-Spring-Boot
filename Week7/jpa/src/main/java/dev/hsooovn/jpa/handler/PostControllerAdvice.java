package dev.hsooovn.jpa.handler;

import dev.hsooovn.jpa.exception.BaseException;
import dev.hsooovn.jpa.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(BaseException exception){
        return new ErrorResponseDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handleValidException(
            MethodArgumentNotValidException exception
    ){
        return new ErrorResponseDto(exception.getMessage());
    }
}
