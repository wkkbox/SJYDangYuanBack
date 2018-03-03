<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form action="${pageContext.request.contextPath}/user/dologin" method="post">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>党员系统管理</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="accountName"
                                       value="${requestScope.user.accountName}" placeholder="登录账号"
                                       data-validate="required:请填写账号"/>
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password"
                                       value="${requestScope.user.password}" placeholder="登录密码"
                                       data-validate="required:请填写密码"/>
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <div class="field">
                                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码"
                                       data-validate="required:请填写右侧的验证码"/>
                                <img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode"
                                     style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
                            </div>
                        </div>--%>
                    </div>
                    <%--<div style="padding:0 30px 10px 30px;">
                        <label style="padding-left: 0">
                            <input ${pageScope.rememberMe=="on" ? " checked = 'checked' " : " " } type="checkbox" name="rememberMe" value="on" id="rememberMe" /> 记住我
                        </label>
                    </div>--%>
                    <div style="padding:10px 30px 10px 30px;">
                        <input type="submit" class="button button-block bg-main text-big input-big" value="登录">
                    </div>
                    <p style="text-align: center"><span style="color: red">${requestScope.msg}</span></p>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>