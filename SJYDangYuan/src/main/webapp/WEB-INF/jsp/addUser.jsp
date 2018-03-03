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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
    <script type="text/javascript">
        $(function() {
            $("#addUserForm").validate({
                rules:{
                    "accountName":{
                        required:true
                    },
                    "userName":{
                        required:true
                    },
                    "idCard":{
                        required:true
                    },
                    "branch":{
                        required:true
                    }
                },
                messages:{
                    "accountName":{
                        required:"帐户名不能为空"
                    },
                    "userName":{
                        required:"真实姓名不能为空"
                    },
                    "idCard":{
                        required:"身份证号不能为空"
                    },
                    "branch":{
                        required:"所属支部不能为空"
                    }
                }
            });
        })

    </script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加用户</strong></div>
    <div class="body-content">
        <form id="addUserForm" method="post" class="form-x" action="${pageContext.request.contextPath}/user/createUser">
            <div class="form-group">
                <div class="label">
                    <label>帐户名：</label>
                </div>
                <div class="field">
                    <input value="${user.accountName}" type="text" class="input w50" name="accountName"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>真实姓名：</label>
                </div>
                <div class="field">
                    <input value="${user.userName}" type="text" class="input w50" name="userName"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <select name="gender" class="input w50">
                        <option value="1" ${user.gender=="1" ? " selected = 'selected' " : " " }>男</option>
                        <option value="0" ${user.gender=="0" ? " selected = 'selected' " : " " }>女</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input value="${user.idCard}" type="text" class="input w50" name="idCard"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>所属支部：</label>
                </div>
                <div class="field">
                    <input value="${user.branch}" type="text" class="input w50" name="branch"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    <span style="color: red">${msg}</span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
