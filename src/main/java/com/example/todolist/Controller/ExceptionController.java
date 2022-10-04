package com.example.todolist.Controller;

import com.example.todolist.exception.BaseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity exception(BaseException error){
        return ResponseEntity.status(error.getErrorCode().getStatus())
                .body(error.getErrorCode().getMessage());
    }

}
