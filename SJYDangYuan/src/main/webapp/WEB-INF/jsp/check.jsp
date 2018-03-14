<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/checkDangZe'">
            <span class="icon-plus-square-o"></span> 党责审核
        </button>
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/checkSheZe'">
            <span class="icon-plus-square-o"></span> 社责审核
        </button>
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/checkAchieve'">
            <span class="icon-plus-square-o"></span> 工作业绩审核
        </button>
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/checkHonorsAward'">
            <span class="icon-plus-square-o"></span> 荣誉奖励审核
        </button>
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/checkProfessDevelop'">
            <span class="icon-plus-square-o"></span> 专业提升审核
        </button>
    </div>
</div>
<script type="text/javascript">
    function del(id,mid){
        if(confirm("您确定要删除吗?")){
            alert("删除成功")
        }
    }
</script>
</body>
</html>