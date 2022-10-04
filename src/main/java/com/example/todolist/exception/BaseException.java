package com.example.todolist.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode){
        super();
        this.errorCode =errorCode;
    }

}
