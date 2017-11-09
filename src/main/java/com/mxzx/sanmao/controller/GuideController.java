package com.mxzx.sanmao.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuideController implements ErrorController {

    private static final String INDEX = "index";
    private static final String ERROR = "error";

    @Override
    public String getErrorPath() {
        return ERROR;
    }

    @GetMapping
    public String index() {
        return INDEX;
    }

    @RequestMapping(ERROR)
    public String error() {
        return ERROR;
    }

}
