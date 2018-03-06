package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.service.SheZeService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sheZe")
public class SheZeController {

    @Autowired
    private SheZeService sheZeService;

    @RequestMapping("/createSheZe")
    @RequiresRoles("admin")
    public String createSheZe(Model model, SheZe sheZe) {
        try {
            sheZeService.addSheZe(sheZe);
            model.addAttribute("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加失败");
            model.addAttribute("sheZe", sheZe);
        }
        return "addSheZe";
    }

    @RequestMapping("/editSheZe")
    @RequiresRoles("admin")
    public String editSheZe(Model model, SheZe sheZe) {
        try {
            sheZeService.editSheZe(sheZe);
            model.addAttribute("msg", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改失败");
            model.addAttribute("sheZe", sheZe);
        }
        return "editSheZe";
    }
}
