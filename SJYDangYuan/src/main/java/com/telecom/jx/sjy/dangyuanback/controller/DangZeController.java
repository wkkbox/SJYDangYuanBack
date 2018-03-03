package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.service.DangZeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dangZe")
public class DangZeController {

    @Autowired
    private DangZeService dangZeService;

    @RequestMapping("/createDangZe")
    @RequiresRoles("admin")
    public String addDangZe(Model model, DangZe dangZe) {
        try {
            dangZeService.addDangZe(dangZe);
            model.addAttribute("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加失败");
            model.addAttribute("dangZe", dangZe);
        }
        return "addDangZe";
    }
}
