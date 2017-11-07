package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.error("系统异常", e);
        if (e instanceof CustomException) {
            CustomException ce = (CustomException) e;
            return Result.from(ce.code(), ce.message());
        }

        return Result.from(HttpStatus.SERVICE_UNAVAILABLE, null);
    }
}
