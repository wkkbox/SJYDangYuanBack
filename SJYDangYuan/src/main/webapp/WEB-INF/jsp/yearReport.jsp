<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 本年报表</strong></div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="5%">序号</th>
            <th width="6%">姓名</th>
            <th width="6%">所属支部</th>
            <th width="6%">本年总积分</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="score" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${score.userName}</td>
                <td>${score.branch}</td>
                <td>${score.score}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">
    function fresh() {
        window.location.href = '${pageContext.request.contextPath}/page/yearReport?currentPage=1&pageSize=6';
    }
</script>
<div class="pagelist">
    <c:if test="${pageInfo.pages!=0}">
        <c:if test="${pageInfo.pageNum!=1}">
            <a href="${pageContext.request.contextPath}/page/yearReport?currentPage=1&pageSize=${pageInfo.pageSize}">首页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum!=1}">
            <a href="${pageContext.request.contextPath}/page/yearReport?currentPage=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
            <a href="${pageContext.request.contextPath}/page/yearReport?currentPage=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下一页</a>
        </c:if>
        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
            <a href="${pageContext.request.contextPath}/page/yearReport?currentPage=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a>
        </c:if>
        <span style="color: #333333;">&nbsp;当前&nbsp;${pageInfo.pageNum}&nbsp;/&nbsp;${pageInfo.pages}&nbsp;页&nbsp;，&nbsp;共&nbsp;${pageInfo.total}&nbsp;条</span>
        <a href="javascript:void(0)" onclick="fresh()">刷新</a>
    </c:if>
</div>
</body>
</html>