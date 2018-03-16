package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;
import com.telecom.jx.sjy.dangyuanback.service.AchievementService;
import com.telecom.jx.sjy.dangyuanback.service.ProfessDevelopService;
import com.telecom.jx.sjy.dangyuanback.util.DateUtil;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @RequestMapping("/checkProfessDevelopDetail")
    public String checkProfessDevelopDetail(Model model, HttpServletRequest request){
        List<String> imgs = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(request.getParameter("imgNum")); i++) {
            imgs.add(request.getParameter("img" + i));
        }
        model.addAttribute("imgs", imgs);
        Long userProfessDevelopId = Long.valueOf(request.getParameter("userProfessDevelopId"));
        Long contentId = Long.valueOf(request.getParameter("contentId"));
        String professDevelopTitle = request.getParameter("professDevelopTitle");
        String professDevelopContent = request.getParameter("professDevelopContent");
        String commitContent = request.getParameter("commitContent");
        Integer dScore = Integer.valueOf(request.getParameter("dScore"));
        Integer lScore = Integer.valueOf(request.getParameter("lScore"));
        Integer hScore = Integer.valueOf(request.getParameter("hScore"));
        Integer otherAttr = Integer.valueOf(request.getParameter("otherAttr"));
        model.addAttribute("userProfessDevelopId", userProfessDevelopId);
        model.addAttribute("contentId", contentId);
        model.addAttribute("professDevelopTitle", professDevelopTitle);
        model.addAttribute("professDevelopContent", professDevelopContent);
        model.addAttribute("commitContent", commitContent);
        model.addAttribute("dScore", dScore);
        model.addAttribute("lScore", lScore);
        model.addAttribute("hScore", hScore);
        model.addAttribute("otherAttr", otherAttr);
        Long userId = Long.valueOf(request.getParameter("userId"));
        model.addAttribute("userId", userId);

        return "checkProfessDevelopDetail";
    }

    @ResponseBody
    @RequestMapping("passProfessDevelop")
    public String passProfessDevelop(Long userProfessDevelopId,Integer rScore, Long userId,String title, Integer otherAttr){
        Map<String,Object> map = new HashMap<>();
        map.put("userProfessDevelopId",userProfessDevelopId);
        map.put("rScore",rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userProfessDevelopId="+userProfessDevelopId);
        System.out.println("rScore="+rScore);
        map.put("userId", userId);
        map.put("title", title+"申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            professDevelopService.passProfessDevelop(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    @ResponseBody
    @RequestMapping("noPassProfessDevelop")
    public String noPassProfessDevelop(Long userProfessDevelopId, Long userId,String title, Integer otherAttr){
        System.out.println("userProfessDevelopId="+userProfessDevelopId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", title+"申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            professDevelopService.noPassProfessDevelop(userProfessDevelopId,map);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }
    }
}
