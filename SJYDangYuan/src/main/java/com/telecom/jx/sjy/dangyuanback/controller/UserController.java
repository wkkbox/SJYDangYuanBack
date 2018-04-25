package com.telecom.jx.sjy.dangyuanback.controller;


import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginView() {
        return "login";
    }

    /**
     * 登录控制器（accountName(电话号码)，password）
     *
     * @param user
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = {"/dologin"})
    public String login(User user, Model model, HttpServletRequest request) {
        System.out.println(request.getMethod());
        System.out.println(user);
        if ("GET".equals(request.getMethod())) {
            //回显
            model.addAttribute("msg", "提交方式有误");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getAccountName(), user.getPassword());
        try {
            subject.login(token);
            //Session session = subject.getSession();
            //System.out.println("sessionId:" + session.getId());
            //System.out.println("sessionHost:" + session.getHost());
            //System.out.println("sessionTimeout:" + session.getTimeout());
            //session.setAttribute("info", "session的数据");
        } catch (Exception e) {
            e.printStackTrace();
            //回显
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
        User currentUser = null;
        if (subject.isAuthenticated()) {
            try {
                currentUser = userService.getUserByAccountName(user.getAccountName());
                //登录成功currentUser存入session
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(604800);//7天
                session.setAttribute("currentUser", currentUser);
                //User currentUser = userService.getUserByName(user.getUserName());
                //List<Menu> menus = userService.getMenusByUserId(currentUser.getId());
                //System.out.println("菜单：" + menus.size() + " " + menus);
                //model.addAttribute("menus", menus);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //登录成功
        return "index";
        //return "forward:system/index";
    }

    /**
     * 管理员退出控制器
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //执行subject.logout()会自动调用stop()方法来销毁会话session.stop()
        subject.logout();
        return "login";
    }

    /**
     * 新增党员（accountName，userName，gender，idCard，branch）
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/createUser")
    @RequiresRoles("admin")
    @ResponseBody
    public String addUser(Model model, User user) {
        try {
            String accountName = user.getAccountName();
            System.out.println("accountName" + accountName);
            User findUser = userService.getUserByAccountName(accountName);
            if (findUser != null) {//已经存在这个帐户
                //model.addAttribute("msg", "添加失败，手机号(帐户名)已存在");
                //model.addAttribute("user", user);
                return "{\"msg\":\"添加失败，手机号(帐户名)已存在\"}";
            } else {
                userService.addUser(user);
                //model.addAttribute("msg", "添加成功");
                return "{\"msg\":\"添加成功\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //model.addAttribute("msg", "添加失败");
            //model.addAttribute("user", user);
            return "{\"msg\":\"添加失败\"}";
        }
    }

    /**
     * 校验帐户名是否可用(accountName)
     *
     * @param accountName
     * @return
     * @throws Exception
     */
    @RequestMapping("/ajaxCheckAccountName")
    @RequiresRoles("admin")
    @ResponseBody
    public String ajaxCheckAccountName(String accountName) throws Exception {
        System.out.println("accountName" + accountName);
        User findUser = userService.getUserByAccountName(accountName);
        if (findUser != null) {//手机号已经存在
            return "{\"msg\":\"0\"}";
        } else {//手机号可用
            return "{\"msg\":\"1\"}";
        }
    }

    /**
     * 重置密码（userId）
     *
     * @param userId
     * @return
     */
    @RequestMapping("/resetPwd")
    @ResponseBody
    @RequiresRoles("admin")
    public String resetPwd(Long userId) {
        System.out.println("userId=" + userId);
        try {
            userService.resetPwd(userId);
            return "{\"msg\":\"重置密码成功\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"msg\":\"重置密码失败\"}";
        }
    }

    /**
     * 未使用
     *
     * @return
     */
    @RequestMapping("/deleteUser")
    @RequiresRoles("admin")
    public String delUser() {
        return "delUser";
    }

    /**
     * 未使用
     *
     * @return
     */
    @RequestMapping("/updateUser")
    @RequiresPermissions(value = {"user:update"})
    public String updateUser() {
        return "updateUser";
    }

    /**
     * 未使用
     *
     * @param model
     * @return
     */
    @RequestMapping("/listUser")
    @RequiresPermissions(value = {"user:view"})
    public String showUsers(Model model) {
        List<User> userList = null;
        try {
            userList = userService.showUsers();
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return "error/error";
        }
        model.addAttribute("userList", userList);
        return "listUser";
    }

}
