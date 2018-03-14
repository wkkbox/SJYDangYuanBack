package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.service.AchievementService;
import com.telecom.jx.sjy.dangyuanback.service.SheZeService;
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
@RequestMapping("/achievement")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @RequestMapping("/createAchievement")
    @RequiresRoles("admin")
    public String createAchievement(Model model, Achievement achievement) {
        try {
            achievementService.addAchievement(achievement);
            model.addAttribute("msg", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加失败");
            model.addAttribute("achievement", achievement);
        }
        return "addAchievement";
    }

    @RequestMapping("/editAchievement")
    @RequiresRoles("admin")
    public String editSheZe(Model model, Achievement achievement) {
        try {
            achievementService.editAchievement(achievement);
            model.addAttribute("msg", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改失败");
            model.addAttribute("achievement", achievement);
        }
        return "editAchievement";
    }

    @RequestMapping("/checkAchieveDetail")
    public String checkAchieveDetail(Model model, HttpServletRequest request){
        List<String> imgs = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(request.getParameter("imgNum")); i++) {
            imgs.add(request.getParameter("img" + i));
        }
        model.addAttribute("imgs", imgs);
        Long userAchievementId = Long.valueOf(request.getParameter("userAchievementId"));
        Long contentId = Long.valueOf(request.getParameter("contentId"));
        String achievementTitle = request.getParameter("achievementTitle");
        String achievementContent = request.getParameter("achievementContent");
        String commitContent = request.getParameter("commitContent");
        Integer dScore = Integer.valueOf(request.getParameter("dScore"));
        Integer lScore = Integer.valueOf(request.getParameter("lScore"));
        Integer hScore = Integer.valueOf(request.getParameter("hScore"));
        Integer otherAttr = Integer.valueOf(request.getParameter("otherAttr"));
        model.addAttribute("userAchievementId", userAchievementId);
        model.addAttribute("contentId", contentId);
        model.addAttribute("achievementTitle", achievementTitle);
        model.addAttribute("achievementContent", achievementContent);
        model.addAttribute("commitContent", commitContent);
        model.addAttribute("dScore", dScore);
        model.addAttribute("lScore", lScore);
        model.addAttribute("hScore", hScore);
        model.addAttribute("otherAttr", otherAttr);

        return "checkAchieveDetail";
    }

    @ResponseBody
    @RequestMapping("passAchievement")
    public String passAchievement(Long userAchievementId,Integer rScore){
        Map<String,Object> map = new HashMap<>();
        map.put("userAchievementId",userAchievementId);
        map.put("rScore",rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userAchievementId="+userAchievementId);
        System.out.println("rScore="+rScore);
        try {
            achievementService.passAchievement(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    @ResponseBody
    @RequestMapping("noPassAchievement")
    public String noPassAchievement(Long userAchievementId){
        System.out.println("userAchievementId="+userAchievementId);
        try {
            achievementService.noPassAchievement(userAchievementId);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }
    }
}
