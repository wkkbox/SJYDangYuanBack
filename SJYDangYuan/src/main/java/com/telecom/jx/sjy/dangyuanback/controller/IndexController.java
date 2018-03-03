package com.telecom.jx.sjy.dangyuanback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/system/index")
    public String index(){
        System.out.println("index");
        return "index";
    }
}
