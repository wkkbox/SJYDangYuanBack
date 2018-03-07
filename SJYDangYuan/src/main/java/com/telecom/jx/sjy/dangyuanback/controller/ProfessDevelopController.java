package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;
import com.telecom.jx.sjy.dangyuanback.service.AchievementService;
import com.telecom.jx.sjy.dangyuanback.service.ProfessDevelopService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professDevelop")
public class ProfessDevelopController {

    @Autowired
    private ProfessDevelopService professDevelopService;

    @RequestMapping("/createProfessDevelop")
    @RequiresRoles("admin")
    public String createProfessDevelop(Model model, ProfessDevelop professDevelop) {
        try {
            professDevelopService.addProfessDevelop(professDevelop);
            model.addAttribute("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加失败");
            model.addAttribute("professDevelop", professDevelop);
        }
        return "addProfessDevelop";
    }

    @RequestMapping("/editProfessDevelop")
    @RequiresRoles("admin")
    public String editProfessDevelop(Model model, ProfessDevelop professDevelop) {
        try {
            professDevelopService.editProfessDevelop(professDevelop);
            model.addAttribute("msg", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改失败");
            model.addAttribute("professDevelop", professDevelop);
        }
        return "editProfessDevelop";
    }
}
