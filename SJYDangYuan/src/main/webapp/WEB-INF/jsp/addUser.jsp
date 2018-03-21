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
        // 默认表示手机号(帐户名)不对
        var accountNameFlag = false;
        // 默认表示真实姓名不对
        var userNameFlag = false;
        // 默认表示身份证号不对
        var idCardFlag = false;

        $(function () {

            $("#accountName").blur(function () {
                var accountName = $("#accountName").val().trim();
                $("#accountNameTip").html("");
                if (accountName != "") {
                    var regexAccountName = /^\d{3}\d{8}|\d{4}\{7,8}$/;
                    if (!regexAccountName.test(accountName)) {
                        $("#accountNameTip").html("格式错误");
                        accountNameFlag = false;
                    } else {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/user/ajaxCheckAccountName",
                            data: {
                                "accountName": accountName
                            },
                            dataType: "json",
                            type: "post",
                            cache: false,
                            asynch: true,
                            success: function (data) {
                                //alert(data.msg);
                                if (data.msg == "1") {// 输入的手机号(帐户名)可用
                                    // 修改全局的手机号(帐户名)标记为true
                                    accountNameFlag = true;
                                } else {// 输入的手机号(帐户名)不可用
                                    // 修改全局的手机号(帐户名)标记为false
                                    accountNameFlag = false;
                                    // 提示用户
                                    $("#accountNameTip").html("手机号(帐户名)已存在");
                                    // 不可用时获取焦点
                                    $("#accountName").focus();
                                }
                            },
                            error: function () {
                                alert("服务器异常");
                            }
                        });
                    }
                } else {
                    $("#accountNameTip").html("手机号(帐户名)不能为空");
                    accountNameFlag = false;
                }
            });

            $("#userName").blur(function () {
                var userName = $("#userName").val().trim();
                $("#userNameTip").html("");
                if (userName != "") {
                    userNameFlag = true;
                } else {
                    $("#userNameTip").html("真实姓名不能为空");
                    userNameFlag = false;
                }
            });

            $("#idCard").blur(function () {
                var idCard = $("#idCard").val().trim();
                $("#idCardTip").html("");
                if (idCard != "") {
                    var regexIdCard = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
                    if (!regexIdCard.test(idCard)) {
                        $("#idCardTip").html("格式错误");
                        idCardFlag = false;
                    } else {
                        idCardFlag = true;
                    }
                } else {
                    $("#idCardTip").html("身份证号不能为空");
                    idCardFlag = false;
                }
            });

            // 表单提交
            $("#commitButton").click(function () {
                if (!accountNameFlag) {
                    $("#accountName").focus();
                    return;
                }
                if (!userNameFlag) {
                    $("#userName").focus();
                    return;
                }
                if (!idCardFlag) {
                    $("#idCard").focus();
                    return;
                }
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/createUser",
                    data: {
                        "accountName": $("input[name='accountName']").val().trim(),
                        "userName": $("input[name='userName']").val().trim(),
                        "gender": $("select[name='gender']").val(),
                        "idCard": $("input[name='idCard']").val().trim(),
                        "branch": $("select[name='branch']").val()
                    },
                    dataType: "json",
                    type: "post",
                    cache: false,
                    asynch: true,
                    success: function (data) {
                        //alert(data.msg);
                        if (data.msg == "添加成功") {
                            alert('添加成功');
                            window.location.href = '${pageContext.request.contextPath}/page/userManagement';
                        } else if (data.msg == "添加失败") {
                            alert('添加失败');
                        } else {
                            alert('添加失败，手机号(帐户名)已存在');
                        }
                    },
                    error: function () {
                        alert("服务器异常");
                    }
                });
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
                    <label>手机号(帐户名)：</label>
                </div>
                <div class="field">
                    <input id="accountName" value="${user.accountName}" type="text" class="input w50"
                           name="accountName"/>
                    <div id="accountNameTip" class="tips" style="color: red"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>真实姓名：</label>
                </div>
                <div class="field">
                    <input id="userName" value="${user.userName}" type="text" class="input w50" name="userName"/>
                    <div id="userNameTip" class="tips" style="color: red"></div>
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
                    <input id="idCard" value="${user.idCard}" type="text" class="input w50" name="idCard"/>
                    <div id="idCardTip" class="tips" style="color: red"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>所在党小组：</label>
                </div>
                <div class="field">
                    <select name="branch" class="input w50">
                        <option value="第一党小组" ${user.branch=="第一党小组" ? " selected = 'selected' " : " " }>第一党小组</option>
                        <option value="第二党小组" ${user.branch=="第二党小组" ? " selected = 'selected' " : " " }>第二党小组</option>
                        <option value="第三党小组" ${user.branch=="第三党小组" ? " selected = 'selected' " : " " }>第三党小组</option>
                        <option value="第四党小组" ${user.branch=="第四党小组" ? " selected = 'selected' " : " " }>第四党小组</option>
                        <option value="第五党小组" ${user.branch=="第五党小组" ? " selected = 'selected' " : " " }>第五党小组</option>
                        <option value="第六党小组" ${user.branch=="第六党小组" ? " selected = 'selected' " : " " }>第六党小组</option>
                        <option value="第七党小组" ${user.branch=="第七党小组" ? " selected = 'selected' " : " " }>第七党小组</option>
                        <option value="第八党小组" ${user.branch=="第八党小组" ? " selected = 'selected' " : " " }>第八党小组</option>
                        <option value="第九党小组" ${user.branch=="第九党小组" ? " selected = 'selected' " : " " }>第九党小组</option>
                        <option value="第十党小组" ${user.branch=="第十党小组" ? " selected = 'selected' " : " " }>第十党小组</option>
                        <option value="第十一党小组" ${user.branch=="第十一党小组" ? " selected = 'selected' " : " " }>第十一党小组
                        </option>
                        <option value="第十二党小组" ${user.branch=="第十二党小组" ? " selected = 'selected' " : " " }>第十二党小组
                        </option>
                        <option value="第十三党小组" ${user.branch=="第十三党小组" ? " selected = 'selected' " : " " }>第十三党小组
                        </option>
                        <option value="第十四党小组" ${user.branch=="第十四党小组" ? " selected = 'selected' " : " " }>第十四党小组
                        </option>
                        <option value="第十五党小组" ${user.branch=="第十五党小组" ? " selected = 'selected' " : " " }>第十五党小组
                        </option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button id="commitButton" class="button bg-main icon-check-square-o" type="button"> 提交</button>
                    <%--<span style="color: red">${msg}</span>--%>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
