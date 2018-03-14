package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;
import com.telecom.jx.sjy.dangyuanback.service.HonorsAwardService;
import com.telecom.jx.sjy.dangyuanback.util.DateUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/checkHonorsAwardDetail")
    public String checkHonorsAwardDetail(Model model, HttpServletRequest request){
        List<String> imgs = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(request.getParameter("imgNum")); i++) {
            imgs.add(request.getParameter("img" + i));
        }
        model.addAttribute("imgs", imgs);
        Long userHonorsAwardId = Long.valueOf(request.getParameter("userHonorsAwardId"));
        Long contentId = Long.valueOf(request.getParameter("contentId"));
        String honorsAwardTitle = request.getParameter("honorsAwardTitle");
        String honorsAwardContent = request.getParameter("honorsAwardContent");
        String commitContent = request.getParameter("commitContent");
        Integer dScore = Integer.valueOf(request.getParameter("dScore"));
        Integer lScore = Integer.valueOf(request.getParameter("lScore"));
        Integer hScore = Integer.valueOf(request.getParameter("hScore"));
        Integer otherAttr = Integer.valueOf(request.getParameter("otherAttr"));
        model.addAttribute("userHonorsAwardId", userHonorsAwardId);
        model.addAttribute("contentId", contentId);
        model.addAttribute("honorsAwardTitle", honorsAwardTitle);
        model.addAttribute("honorsAwardContent", honorsAwardContent);
        model.addAttribute("commitContent", commitContent);
        model.addAttribute("dScore", dScore);
        model.addAttribute("lScore", lScore);
        model.addAttribute("hScore", hScore);
        model.addAttribute("otherAttr", otherAttr);

        return "checkHonorsAwardDetail";
    }

    @ResponseBody
    @RequestMapping("passHonorsAward")
    public String passHonorsAward(Long userHonorsAwardId,Integer rScore){
        Map<String,Object> map = new HashMap<>();
        map.put("userHonorsAwardId",userHonorsAwardId);
        map.put("rScore",rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userHonorsAwardId="+userHonorsAwardId);
        System.out.println("rScore="+rScore);
        try {
            honorsAwardService.passHonorsAward(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    @ResponseBody
    @RequestMapping("noPassHonorsAward")
    public String noPassHonorsAward(Long userHonorsAwardId){
        System.out.println("userHonorsAwardId="+userHonorsAwardId);
        try {
            honorsAwardService.noPassHonorsAward(userHonorsAwardId);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }
    }
}
