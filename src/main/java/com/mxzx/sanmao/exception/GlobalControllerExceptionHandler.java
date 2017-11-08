package com.mxzx.sanmao.exception;

import com.mxzx.sanmao.controller.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> handWebException(CustomException e) {
        return Result.of(e.code(), e.msg(), null);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result<String> handRuntimeException(Exception e) {
        e.printStackTrace();
        return Result.from(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result<String> handleThrowable(Throwable throwable) {
        logger.error(throwable.getMessage(), throwable);
        return Result.from(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
    }

}