package com.flab.baseballgame.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "game is closed")
    @ExceptionHandler(GameEndException.class)
    public ErrorResponse closedGameError() {
        return new ErrorResponse("false", null, new ErrorResponse.Err("Closed_game", ""));
    }
}