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
import java.util.*;

@Controller
@RequestMapping("/honorsAward")
public class HonorsAwardController {

    @Autowired
    private HonorsAwardService honorsAwardService;

    /**
     * 录入荣誉奖励（title，content，lScore，hScore，rate，sumScore，otherAttr）
     *
     * @param model
     * @param honorsAward
     * @return
     */
    @RequestMapping("/createHonorsAward")
    @RequiresRoles("admin")
    @ResponseBody
    public String createHonorsAward(Model model, HonorsAward honorsAward) {
        try {
            honorsAwardService.addHonorsAward(honorsAward);
            //model.addAttribute("msg", "添加成功");
            return "{\"msg\":\"录入成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            //model.addAttribute("msg", "添加失败");
            //model.addAttribute("honorsAward", honorsAward);
            return "{\"msg\":\"录入失败\"}";
        }
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

    /**
     * 跳转到详情
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/checkHonorsAwardDetail")
    @RequiresRoles("admin")
    public String checkHonorsAwardDetail(Model model, HttpServletRequest request) {
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
        Long userId = Long.valueOf(request.getParameter("userId"));
        model.addAttribute("userId", userId);
        //跳转到详情
        return "checkHonorsAwardDetail";
    }

    /**
     * 审核通过
     *
     * @param userHonorsAwardId
     * @param rScore
     * @param userId
     * @param title
     * @param otherAttr
     * @return
     */
    @ResponseBody
    @RequestMapping("passHonorsAward")
    @RequiresRoles("admin")
    public String passHonorsAward(Long userHonorsAwardId, Integer rScore, Long userId, String title, Integer otherAttr) {
        Map<String, Object> map = new HashMap<>();
        map.put("userHonorsAwardId", userHonorsAwardId);
        map.put("rScore", rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userHonorsAwardId=" + userHonorsAwardId);
        System.out.println("rScore=" + rScore);
        map.put("userId", userId);
        map.put("title", title + "申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            honorsAwardService.passHonorsAward(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    /**
     * 驳回
     *
     * @param userHonorsAwardId
     * @param userId
     * @param title
     * @param otherAttr
     * @return
     */
    @ResponseBody
    @RequestMapping("noPassHonorsAward")
    @RequiresRoles("admin")
    public String noPassHonorsAward(Long userHonorsAwardId, Long userId, String title, Integer otherAttr) {
        System.out.println("userHonorsAwardId=" + userHonorsAwardId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", title + "申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            honorsAwardService.noPassHonorsAward(userHonorsAwardId, map);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }
    }
}
