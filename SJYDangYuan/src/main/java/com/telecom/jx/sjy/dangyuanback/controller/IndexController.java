package com.telecom.jx.sjy.dangyuanback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 跳转到 index.jsp页面
     *
     * @return
     */
    @RequestMapping("/system/index")
    public String index() {
        System.out.println("index");
        return "index";
    }
}
