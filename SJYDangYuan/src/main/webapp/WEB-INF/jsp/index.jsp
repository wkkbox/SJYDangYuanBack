<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>党员管理系统</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="logo margin-big-left fadein-top">
        <h1><img src="${pageContext.request.contextPath}/images/y.jpg" class="radius-circle rotate-hover" height="50" alt=""/>党员管理系统</h1>
    </div>
    <div class="head-l">
        <button type="button" class="button button-little bg-green" onclick="window.location.href='${pageContext.request.contextPath}/system/index'">
            <span class="icon-home"></span>前台首页
        </button>
        <a class="button button-little bg-red" href="${pageContext.request.contextPath}/user/logout"><span class="icon-power-off"></span> 退出登录</a>
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
    <h2><span class="icon-user"></span>系统管理</h2>
    <ul style="display:block">
        <li><a href="${pageContext.request.contextPath}/page/userManagement" target="right"><span class="icon-caret-right"></span>用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/roleManagement" target="right"><span class="icon-caret-right"></span>角色管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/permissionManagement" target="right"><span class="icon-caret-right"></span>权限管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/scoreManagement" target="right"><span class="icon-caret-right"></span>积分管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/departmentManagement" target="right"><span class="icon-caret-right"></span>部门管理</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>活动录入</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/page/dangZeManagement" target="right"><span class="icon-caret-right"></span>党责管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/sheZeManagement" target="right"><span class="icon-caret-right"></span>社责管理</a></li>
        <li><a href="${pageContext.request.contextPath}/page/achievement" target="right"><span class="icon-caret-right"></span>工作业绩</a></li>
        <li><a href="${pageContext.request.contextPath}/page/honorsAwards" target="right"><span class="icon-caret-right"></span>荣誉奖励</a></li>
        <li><a href="${pageContext.request.contextPath}/page/professionalDevelopment" target="right"><span class="icon-caret-right"></span>专业提升</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>日常管理</h2>
    <ul>
        <li><a href="${pageContext.request.contextPath}/page/approval" target="right"><span class="icon-caret-right"></span>日常考核</a></li>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>一票否决</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>我的桌面</h2>
    <ul>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>日常待办事务</a></li>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>个人考核情况</a></li>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>信息发布</a></li>
    </ul>
    <h2><span class="icon-pencil-square-o"></span>报表系统</h2>
    <ul>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>全员考核情况表</a></li>
        <li><a href="kb.html" target="right"><span class="icon-caret-right"></span>部门考核情况表</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(function () {
        $(".leftnav h2").click(function () {
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function () {
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
    <li><a href="javascript:void(0)" target="right" class="icon-home"> 首页</a></li>
    <li><a href="javascript:void(0)" id="a_leader_txt">网站信息</a></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath}/page/info" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>
