package com.telecom.jx.sjy.dangyuanback.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.telecom.jx.sjy.dangyuanback.pojo.po.*;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.*;
import com.telecom.jx.sjy.dangyuanback.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private HonorsAwardService honorsAwardService;

    @Autowired
    private ProfessDevelopService professDevelopService;

    @Autowired
    private AttachmentService attachmentService;

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

    @RequestMapping("/honorsAward")
    public String honorsAwards(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //分页查询所有荣誉奖励
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);
        List<HonorsAward> honorsAwards = honorsAwardService.getHonorsAwards();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(honorsAwards));
        return "honorsAward";
    }

    @RequestMapping("/professDevelop")
    public String professDevelop(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //分页查询所有专业提升
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);
        List<ProfessDevelop> professDevelops = professDevelopService.getProfessDevelops();
        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(professDevelops));
        return "professDevelop";
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

    @RequestMapping("/addProfessDevelop")
    public String addProfessDevelop() {
        return "addProfessDevelop";
    }

    @RequestMapping("/addHonorsAward")
    public String addHonorsAward() {
        return "addHonorsAward";
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

    @RequestMapping("/editProfessDevelop")
    public String editProfessDevelop(Model model, Long professDevelopId) throws Exception {
        System.out.println("professDevelopId=" + professDevelopId);
        ProfessDevelop professDevelop = professDevelopService.getProfessDevelopById(professDevelopId);
        model.addAttribute("professDevelop", professDevelop);
        return "editProfessDevelop";
    }

    @RequestMapping("/editHonorsAward")
    public String editHonorsAward(Model model, Long honorsAwardId) throws Exception {
        System.out.println("honorsAwardId=" + honorsAwardId);
        HonorsAward honorsAward = honorsAwardService.getHonorsAwardById(honorsAwardId);
        model.addAttribute("honorsAward", honorsAward);
        return "editHonorsAward";
    }

    @RequestMapping("/check")
    public String check() {
        return "check";
    }

    @RequestMapping("/checkDangZe")
    public String checkDangZe(Model model, Integer currentPage, Integer pageSize) throws Exception {
        //System.out.println("党责审核");
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);

        List<DangZeContent> dangZeContents = dangZeService.getDangZeContents();
        //System.out.println("dangZeContents.size=" + dangZeContents.size());


        for (int i = 0; i < dangZeContents.size(); i++) {
            //String content = dangZeContents.get(i).getContent();
            Long contentId = dangZeContents.get(i).getId();
            Long userId = dangZeContents.get(i).getUserId();
            //1
            User user = userService.getUserById(userId);
            //System.out.println("contentId=" + contentId);
            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("activityType", 0);
            //2
            List<ActivityAttachment> attachments = attachmentService.getAttachments(map);
            Long arrangeId = dangZeContents.get(i).getArrangeId();

            DangZeArrangeCustom arrangeCustom = dangZeService.getDangZeArrangeCustom(arrangeId);
            if (arrangeCustom == null) {
                arrangeCustom = dangZeService.getDangZe3ArrangeCustom(arrangeId);
            }
            String time = arrangeCustom.getTime();
            Long dangzeId = arrangeCustom.getDangzeId();
            //3
            DangZe dangZe = dangZeService.getDangZeById(dangzeId);
            //Integer dScore = dangZe.getdScore();
            //Integer lScore = dangZe.getlScore();
            //Integer hScore = dangZe.gethScore();
            map.put("time", time);
            map.put("dangzeId", dangzeId);
            map.put("userId", userId);
            //4
            //Long userDangzeId = dangZeService.getUserDangZeId(map);
            //System.out.println("userDangzeId233="+dangZeContents.get(i).getUserDangzeId());
            //System.out.println("userDangzeId="+userDangzeId);
            //Integer state = dangZeService.getUserDangZeState(map);
            //System.out.println("state="+state);
            //5
            //String commitTime = dangZeService.getCommitTime(dangZeContents.get(i).getUserDangzeId());
            //System.out.println("commitTime="+commitTime);
            //System.out.println("commitTime233="+dangZeContents.get(i).getCommitTime());
            //dangZeContents.get(i).setUserDangzeId(userDangzeId);
            dangZeContents.get(i).setAttachments(attachments);
            dangZeContents.get(i).setDangZe(dangZe);
            dangZeContents.get(i).setUser(user);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(dangZeContents.get(i).getCommitTime());
            dangZeContents.get(i).setCommitTime(sdf.format(date));
            //System.out.println(dangZeContents.get(i).getCommitTime());

        }

        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(dangZeContents));

        return "checkDangZe";
    }

    @RequestMapping("/checkSheZe")
    public String checkSheZe(Model model, Integer currentPage, Integer pageSize) throws Exception{
        //System.out.println("党责审核");
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);

        List<SheZeContent> sheZeContents = sheZeService.getSheZeContents();

        for (int i = 0; i < sheZeContents.size(); i++) {
            Long contentId = sheZeContents.get(i).getId();
            Long userId = sheZeContents.get(i).getUserId();
            //1
            User user = userService.getUserById(userId);

            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("activityType", 1);
            //2
            List<ActivityAttachment> attachments = attachmentService.getAttachments(map);
            Long arrangeId = sheZeContents.get(i).getArrangeId();

            SheZeArrangeCustom arrangeCustom = sheZeService.getSheZeArrangeCustom(arrangeId);
            if (arrangeCustom == null) {
                arrangeCustom = sheZeService.getSheZe3ArrangeCustom(arrangeId);
            }
            Long shezeId = arrangeCustom.getShezeId();
            //3
            SheZe sheZe = sheZeService.getSheZeById(shezeId);
            //4
            sheZeContents.get(i).setAttachments(attachments);
            sheZeContents.get(i).setSheZe(sheZe);
            sheZeContents.get(i).setUser(user);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(sheZeContents.get(i).getCommitTime());
            sheZeContents.get(i).setCommitTime(sdf.format(date));

        }

        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(sheZeContents));



        return "checkSheZe";
    }

    @RequestMapping("/checkAchieve")
    public String checkAchieve(Model model, Integer currentPage, Integer pageSize) throws Exception{
        //System.out.println("党责审核");
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);

        List<AchievementContent> achievementContents = achievementService.getAchievementContents();

        for (int i = 0; i < achievementContents.size(); i++) {
            Long contentId = achievementContents.get(i).getId();
            Long userId = achievementContents.get(i).getUserId();
            //1
            User user = userService.getUserById(userId);

            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("activityType", 2);
            //2
            List<ActivityAttachment> attachments = attachmentService.getAttachments(map);
            Long arrangeId = achievementContents.get(i).getArrangeId();

            AchievementArrangeCustom arrangeCustom = achievementService.getAchievementArrangeCustom(arrangeId);
            if (arrangeCustom == null) {
                arrangeCustom = achievementService.getAchievement3ArrangeCustom(arrangeId);
            }
            Long achievementId = arrangeCustom.getAchievementId();
            //3
            Achievement achievement = achievementService.getAchievementById(achievementId);
            //4
            achievementContents.get(i).setAttachments(attachments);
            achievementContents.get(i).setAchievement(achievement);
            achievementContents.get(i).setUser(user);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(achievementContents.get(i).getCommitTime());
            achievementContents.get(i).setCommitTime(sdf.format(date));

        }

        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(achievementContents));


        return "checkAchieve";
    }

    @RequestMapping("/checkHonorsAward")
    public String checkHonorsAward(Model model, Integer currentPage, Integer pageSize) throws Exception{
        //System.out.println("党责审核");
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);

        List<HonorsAwardContent> honorsAwardContents = honorsAwardService.getHonorsAwardContents();

        for (int i = 0; i < honorsAwardContents.size(); i++) {
            Long contentId = honorsAwardContents.get(i).getId();
            Long userId = honorsAwardContents.get(i).getUserId();
            //1
            User user = userService.getUserById(userId);

            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("activityType", 3);
            //2
            List<ActivityAttachment> attachments = attachmentService.getAttachments(map);
            Long arrangeId = honorsAwardContents.get(i).getArrangeId();

            HonorsAwardArrangeCustom arrangeCustom = honorsAwardService.getHonorsAwardArrangeCustom(arrangeId);
            if (arrangeCustom == null) {
                arrangeCustom = honorsAwardService.getHonorsAward3ArrangeCustom(arrangeId);
            }
            Long honorsAwardId = arrangeCustom.getHonorsAwardId();
            //3
            HonorsAward honorsAward = honorsAwardService.getHonorsAwardById(honorsAwardId);
            //4
            honorsAwardContents.get(i).setAttachments(attachments);
            honorsAwardContents.get(i).setHonorsAward(honorsAward);
            honorsAwardContents.get(i).setUser(user);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(honorsAwardContents.get(i).getCommitTime());
            honorsAwardContents.get(i).setCommitTime(sdf.format(date));

        }

        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(honorsAwardContents));


        return "checkHonorsAward";
    }

    @RequestMapping("/checkProfessDevelop")
    public String checkProfessDevelop(Model model, Integer currentPage, Integer pageSize) throws Exception{
        //System.out.println("党责审核");
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null) {
            pageSize = 6;
        }
        PageHelper.startPage(currentPage, pageSize);

        List<ProfessDevelopContent> professDevelopContents = professDevelopService.getProfessDevelopContents();

        for (int i = 0; i < professDevelopContents.size(); i++) {
            Long contentId = professDevelopContents.get(i).getId();
            Long userId = professDevelopContents.get(i).getUserId();
            //1
            User user = userService.getUserById(userId);

            Map<String, Object> map = new HashMap<>();
            map.put("contentId", contentId);
            map.put("activityType", 4);
            //2
            List<ActivityAttachment> attachments = attachmentService.getAttachments(map);
            Long arrangeId = professDevelopContents.get(i).getArrangeId();

            ProfessDevelopArrangeCustom arrangeCustom = professDevelopService.getProfessDevelopArrangeCustom(arrangeId);
            if (arrangeCustom == null) {
                arrangeCustom = professDevelopService.getProfessDevelop3ArrangeCustom(arrangeId);
            }
            Long professdevelopId = arrangeCustom.getProfessdevelopId();
            //3
            ProfessDevelop professDevelop = professDevelopService.getProfessDevelopById(professdevelopId);
            //4
            professDevelopContents.get(i).setAttachments(attachments);
            professDevelopContents.get(i).setProfessDevelop(professDevelop);
            professDevelopContents.get(i).setUser(user);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse(professDevelopContents.get(i).getCommitTime());
            professDevelopContents.get(i).setCommitTime(sdf.format(date));

        }

        // 绑定分页返回
        model.addAttribute("pageInfo", new PageInfo<>(professDevelopContents));


        return "checkProfessDevelop";
    }

}
