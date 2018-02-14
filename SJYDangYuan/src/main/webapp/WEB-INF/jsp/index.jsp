<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#touchMe").click(function () {
                alert("点我点我");
            });
        });
    </script>
</head>
<body>
${sessionScope.info }
<%--拥有的菜单如下：<br>
<c:forEach items="${requestScope.menus}" var="menu">
    <a href="${pageContext.request.contextPath}/${menu.menuUrl}">${menu.menuName}</a>
</c:forEach>--%>
<input id="touchMe" type="button" value="点我">
<br><a href="${pageContext.request.contextPath}/user/logout">退出登录</a>
</body>
</html>
