package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.exception.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.error("系统异常", e);
        if (e instanceof CustomException) {
            CustomException ce = (CustomException) e;
            return Result.from(ce.code(), ce.msg());
        }

        return Result.from(HttpStatus.SERVICE_UNAVAILABLE, null);
    }
}
