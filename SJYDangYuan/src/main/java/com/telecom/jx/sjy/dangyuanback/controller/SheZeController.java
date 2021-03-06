package com.telecom.jx.sjy.dangyuanback.controller;

import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.service.SheZeService;
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
@RequestMapping("/sheZe")
public class SheZeController {

    @Autowired
    private SheZeService sheZeService;

    /**
     * 录入社责（title，content，lScore，hScore，rate，sumScore，otherAttr）
     *
     * @param model
     * @param sheZe
     * @return
     */
    @RequestMapping("/createSheZe")
    @RequiresRoles("admin")
    @ResponseBody
    public String createSheZe(Model model, SheZe sheZe) {
        try {
            sheZeService.addSheZe(sheZe);
            //model.addAttribute("msg", "添加成功");
            return "{\"msg\":\"录入成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            //model.addAttribute("msg", "添加失败");
            //model.addAttribute("sheZe", sheZe);
            return "{\"msg\":\"录入失败\"}";
        }
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

    /**
     * 跳转到详情
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/checkSheZeDetail")
    @RequiresRoles("admin")
    public String checkSheZeDetail(Model model, HttpServletRequest request) {
        List<String> imgs = new ArrayList<>();
        for (int i = 1; i <= Integer.valueOf(request.getParameter("imgNum")); i++) {
            imgs.add(request.getParameter("img" + i));
        }
        model.addAttribute("imgs", imgs);
        Long userShezeId = Long.valueOf(request.getParameter("userShezeId"));
        Long contentId = Long.valueOf(request.getParameter("contentId"));
        String shezeTitle = request.getParameter("shezeTitle");
        String shezeContent = request.getParameter("shezeContent");
        String commitContent = request.getParameter("commitContent");
        Integer dScore = Integer.valueOf(request.getParameter("dScore"));
        Integer lScore = Integer.valueOf(request.getParameter("lScore"));
        Integer hScore = Integer.valueOf(request.getParameter("hScore"));
        Integer otherAttr = Integer.valueOf(request.getParameter("otherAttr"));
        model.addAttribute("userShezeId", userShezeId);
        model.addAttribute("contentId", contentId);
        model.addAttribute("shezeTitle", shezeTitle);
        model.addAttribute("shezeContent", shezeContent);
        model.addAttribute("commitContent", commitContent);
        model.addAttribute("dScore", dScore);
        model.addAttribute("lScore", lScore);
        model.addAttribute("hScore", hScore);
        model.addAttribute("otherAttr", otherAttr);
        Long userId = Long.valueOf(request.getParameter("userId"));
        model.addAttribute("userId", userId);
        //跳转到详情
        return "checkSheZeDetail";
    }

    /**
     * 审核通过
     *
     * @param userShezeId
     * @param rScore
     * @param userId
     * @param title
     * @param otherAttr
     * @return
     */
    @ResponseBody
    @RequestMapping("passSheZe")
    @RequiresRoles("admin")
    public String passSheZe(Long userShezeId, Integer rScore, Long userId, String title, Integer otherAttr) {
        Map<String, Object> map = new HashMap<>();
        map.put("userShezeId", userShezeId);
        map.put("rScore", rScore);
        map.put("finishTime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        System.out.println("userShezeId=" + userShezeId);
        System.out.println("rScore=" + rScore);
        map.put("userId", userId);
        map.put("title", title + "申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            sheZeService.passSheZe(map);
            return "{\"msg\":\"审核成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"审核失败\"}";
        }
    }

    /**
     * 驳回
     *
     * @param userShezeId
     * @param userId
     * @param title
     * @param otherAttr
     * @return
     */
    @ResponseBody
    @RequestMapping("noPassSheZe")
    @RequiresRoles("admin")
    public String noPassSheZe(Long userShezeId, Long userId, String title, Integer otherAttr) {
        System.out.println("userShezeId=" + userShezeId);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("title", title + "申请结果");
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        map.put("publishtime", DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        map.put("otherAttr", otherAttr);
        try {
            sheZeService.noPassSheZe(userShezeId, map);
            return "{\"msg\":\"驳回成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"驳回失败\"}";
        }
    }
}
