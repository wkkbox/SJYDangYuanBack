package com.telecom.jx.sjy.dangyuanback.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.DangZeService;
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

    @RequestMapping("/editDangZe")
    public String editDangZe(Model model, Long dangzeId) throws Exception {
        System.out.println("dangzeId=" + dangzeId);
        DangZe dangZe = dangZeService.getDangZeById(dangzeId);
        model.addAttribute("dangZe", dangZe);
        return "editDangZe";
    }

}
