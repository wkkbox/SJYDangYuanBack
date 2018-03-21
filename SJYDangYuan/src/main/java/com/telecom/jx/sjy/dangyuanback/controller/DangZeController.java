package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.DangZeService;
import com.telecom.jx.sjy.dangyuanback.util.DateUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/dangZe")
public class DangZeController {

    @Autowired
    private DangZeService dangZeService;

    @RequestMapping("/createDangZe")
    @RequiresRoles("admin")
    @ResponseBody
    public String createDangZe(Model model, DangZe dangZe) {
        try {
            dangZeService.addDangZe(dangZe);
            //model.addAttribute("msg", "添加成功");
            return "{\"msg\":\"录入成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            //model.addAttribute("msg", "添加失败");
            //model.addAttribute("dangZe", dangZe);
            return "{\"msg\":\"录入失败\"}";
        }
    }

    @RequestMapping("/editDangZe")
    @RequiresRoles("admin")
    public String editDangZe(Model model, DangZe dangZe) {
        try {
            dangZeService.editDangZe(dangZe);
            model.addAttribute("msg", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改失败");
            model.addAttribute("dangZe", dangZe);
        }
        return "editDangZe";
    }

    @RequestMapping("/checkDangZeDetail")
    @RequiresRoles("admin")
    public String checkDangZeDetail(Model model, HttpServletRequest request) {
        List<String> imgs = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(request.getParameter("imgNum")); i++) {
            imgs.add(request.getParameter("img" + i));
        }
        model.addAttribute("imgs", imgs);
        Long userDangzeId = Long.valueOf(request.getParameter("userDangzeId"));
        Long contentId = Long.valueOf(request.getParameter("contentId"));
        String dangzeTitle = request.getParameter("dangzeTitle");
        String dangzeContent = request.getParameter("dangzeContent");
        String commitContent = request.getParameter("commitContent");
        Integer dScore = Integer.valueOf(request.getParameter("dScore"));
        Integer lScore = Integer.valueOf(request.getParameter("lScore"));
        Integer hScore = Integer.valueOf(request.getParameter("hScore"));
        model.addAttribute("userDangzeId", userDangzeId);
        model.addAttribute("contentId", contentId);
        model.addAttribute("dangzeTitle", dangzeTitle);
        model.addAttribute("dangzeContent", dangzeContent);
        model.addAttribute("commitContent", commitContent);
        model.addAttribute("dScore", dScore);
        model.addAttribute("lScore", lScore);
        model.addAttribute("hScore", hScore);
        Long userId = Long.valueOf(request.getParameter("userId"));
        model.addAttribute("userId", userId);

        return "checkDangZeDetail";
    }

    @ResponseBody
    @RequestMapping("passDangZe")
    @RequiresRoles("admin")
    public String passDangZe(Long userDangzeId, Integer rScore, Long userId, String dangzeTitle) {
        Map<String, Object> map = new HashMap<>();
        map.put("userDangzeId", userDangzeId);
        map.put("rScore", rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userDangzeId=" + userDangzeId);
        System.out.println("rScore=" + rScore);
        map.put("userId", userId);
        map.put("title", dangzeTitle+"申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        try {
            dangZeService.passDangZe(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    @ResponseBody
    @RequestMapping("noPassDangZe")
    @RequiresRoles("admin")
    public String noPassDangZe(Long userDangzeId, Long userId, String dangzeTitle) {
        System.out.println("userDangzeId=" + userDangzeId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", dangzeTitle+"申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        try {
            dangZeService.noPassDangZe(userDangzeId,map);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }


    }
}
