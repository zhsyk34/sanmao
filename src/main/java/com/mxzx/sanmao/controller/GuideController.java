package com.mxzx.sanmao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class GuideController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping("/index")
    public String index() {
        logger.info("index-------------->>>>>>>>>>>>>>>>>");
        return "index";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH)
    public String error() {
        logger.info("error-------------->>>>>>>>>>>>>>>>>");
        return "error";
    }

}
