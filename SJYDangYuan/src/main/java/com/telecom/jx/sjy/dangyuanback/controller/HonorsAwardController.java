package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;
import com.telecom.jx.sjy.dangyuanback.service.HonorsAwardService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/honorsAward")
public class HonorsAwardController {

    @Autowired
    private HonorsAwardService honorsAwardService;

    @RequestMapping("/createHonorsAward")
    @RequiresRoles("admin")
    public String createHonorsAward(Model model, HonorsAward honorsAward) {
        try {
            honorsAwardService.addHonorsAward(honorsAward);
            model.addAttribute("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加失败");
            model.addAttribute("honorsAward", honorsAward);
        }
        return "addHonorsAward";
    }

    @RequestMapping("/editHonorsAward")
    @RequiresRoles("admin")
    public String editHonorsAward(Model model, HonorsAward honorsAward) {
        try {
            honorsAwardService.editHonorsAward(honorsAward);
            model.addAttribute("msg", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改失败");
            model.addAttribute("honorsAward", honorsAward);
        }
        return "editHonorsAward";
    }
}
