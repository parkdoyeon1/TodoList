package com.example.todolist.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    NOT_FOUND(404,"Not Found Id : 없는 아이디 입니다."),
    BAD_REQUEST(400,"Bad Request : 잘못된 입력입니다."),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION(415, "BAD_REQUEST : 잘못된 입력 타입입니다."),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(400, "BAD_REQUEST : 값이 NULL값입니다."),
    METHOD_ARGUMENT_TYPE_MISMATCH_EXCEPTION(400,"잘못된 엔드포인트 입니다."),
    ILLEGAL_STATE_EXCEPTION(400,"BAD_REQUEST : 중복된 아이디 입니다.");

    private final Integer status;
    private final String message;

    ErrorCode(int status,String message){
        this.status = status;
        this.message = message;
    }



}
