package com.telecom.jx.sjy.dangyuanback.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.AchievementService;
import com.telecom.jx.sjy.dangyuanback.service.DangZeService;
import com.telecom.jx.sjy.dangyuanback.service.SheZeService;
import com.telecom.jx.sjy.dangyuanback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private DangZeService dangZeService;

    @Autowired
    private SheZeService sheZeService;

    @Autowired
    private AchievementService achievementService;

    @RequestMapping("/userManagement")
    public String userManagement(Model model, Integer currentPage, Integer pageSize) throws Exception {
        System.out.println("currentPage=" + currentPage);
        System.out.println("pageSize=" + pageSize);
        //分页查询所有用戶
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        System.out.println("newCurrentPage=" + currentPage);
        System.out.println("newPageSize=" + pageSize);
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userService.getUsers();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(users));
        return "userManagement";
    }

    @RequestMapping("/roleManagement")
    public String roleManagement() {
        return "roleManagement";
    }

    @RequestMapping("/dangZeManagement")
    public String dangZeManagement(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //分页查询所有党责
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);
        List<DangZe> dangZes = dangZeService.getDangZes();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(dangZes));
        return "dangZeManagement";
    }

    @RequestMapping("/sheZeManagement")
    public String sheZeManagement(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //分页查询所有社责
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);
        List<SheZe> sheZes = sheZeService.getSheZes();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(sheZes));
        return "sheZeManagement";
    }

    @RequestMapping("/achievement")
    public String achievement(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //分页查询所有工作业绩
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);
        List<Achievement> achievements = achievementService.getAchievements();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(achievements));
        return "achievement";
    }

    @RequestMapping("/info")
    public String info() {
        //欢迎访问本系统图片
        return "info";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping("/addDangZe")
    public String addDangZe() {
        return "addDangZe";
    }

    @RequestMapping("/addSheZe")
    public String addSheZe() {
        return "addSheZe";
    }

    @RequestMapping("/addAchievement")
    public String addAchievement() {
        return "addAchievement";
    }

    @RequestMapping("/editDangZe")
    public String editDangZe(Model model, Long dangzeId) throws Exception {
        System.out.println("dangzeId=" + dangzeId);
        DangZe dangZe = dangZeService.getDangZeById(dangzeId);
        model.addAttribute("dangZe", dangZe);
        return "editDangZe";
    }

    @RequestMapping("/editSheZe")
    public String editSheZe(Model model, Long shezeId) throws Exception {
        System.out.println("shezeId=" + shezeId);
        SheZe sheZe = sheZeService.getSheZeById(shezeId);
        model.addAttribute("sheZe", sheZe);
        return "editSheZe";
    }

    @RequestMapping("/editAchievement")
    public String editAchievement(Model model, Long achievementId) throws Exception {
        System.out.println("achievementId=" + achievementId);
        Achievement achievement = achievementService.getAchievementById(achievementId);
        model.addAttribute("achievement", achievement);
        return "editAchievement";
    }

}
