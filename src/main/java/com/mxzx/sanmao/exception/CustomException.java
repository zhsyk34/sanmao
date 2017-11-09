package com.mxzx.sanmao.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class CustomException extends RuntimeException {
    private final int code;
    private final String msg;
}
