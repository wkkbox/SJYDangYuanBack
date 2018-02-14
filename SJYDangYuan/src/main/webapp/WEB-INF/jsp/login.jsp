<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    账户:<input type="text" name="accountName" value="${requestScope.user.accountName}"><br>
    密码:<input type="password" name="password" value="${requestScope.user.password}"><br>
    <input type="submit" value="登录"><span>${requestScope.msg}</span>
</form>
</body>
</html>
