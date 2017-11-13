package com.mxzx.sanmao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class GuideController implements ErrorController {

    private static final String INDEX = "index";
    private static final String ERROR = "error";

    @Override
    public String getErrorPath() {
        logger.error("-------------------------访问出错");
        return ERROR;
    }

    @GetMapping("/")
    public String index() {
        logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<欢迎访问首页");
        return INDEX;
    }

    @RequestMapping(ERROR)
    public String error() {
        //TODO
//        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>跳转到错误页面");
        return ERROR;
    }

}
