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
            $("#addAchievementForm").validate({
                rules:{
                    "title":{
                        required:true
                    },
                    "content":{
                        required:true
                    },
                    "sumScore":{
                        required:true
                    }
                },
                messages:{
                    "title":{
                        required:"标题不能为空"
                    },
                    "content":{
                        required:"积分内容不能为空"
                    },
                    "sumScore":{
                        required:"累积最高分不能为空"
                    }
                }
            });
        })

    </script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>工作业绩录入</strong></div>
    <div class="body-content">
        <form id="addAchievementForm" method="post" class="form-x" action="${pageContext.request.contextPath}/achievement/createAchievement">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input value="${achievement.title}" type="text" class="input w50" name="title" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>积分内容：</label>
                </div>
                <div class="field">
                    <input value="${achievement.content}" type="text" class="input w50" name="content" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>分值/次：</label>
                </div>
                <div class="field">
                    <select name="dScore" class="input w50">
                        <option value="1" ${achievement.dScore == 1 ? " selected = 'selected' " : " " }>1</option>
                        <option value="2" ${achievement.dScore == 2 ? " selected = 'selected' " : " " }>2</option>
                        <option value="3" ${achievement.dScore == 3 ? " selected = 'selected' " : " " }>3</option>
                        <option value="4" ${achievement.dScore == 4 ? " selected = 'selected' " : " " }>4</option>
                        <option value="5" ${achievement.dScore == 5 ? " selected = 'selected' " : " " }>5</option>
                        <option value="6" ${achievement.dScore == 6 ? " selected = 'selected' " : " " }>6</option>
                        <option value="7" ${achievement.dScore == 7 ? " selected = 'selected' " : " " }>7</option>
                        <option value="8" ${achievement.dScore == 8 ? " selected = 'selected' " : " " }>8</option>
                        <option value="9" ${achievement.dScore == 9 ? " selected = 'selected' " : " " }>9</option>
                        <option value="10" ${achievement.dScore == 10 ? " selected = 'selected' " : " " }>10</option>
                        <option value="11" ${achievement.dScore == 11 ? " selected = 'selected' " : " " }>11</option>
                        <option value="12" ${achievement.dScore == 12 ? " selected = 'selected' " : " " }>12</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>频率：</label>
                </div>
                <div class="field">
                    <select name="rate" class="input w50">
                        <option value="0" ${achievement.rate == 0 ? " selected = 'selected' " : " " }>每月1次</option>
                        <option value="1" ${achievement.rate == 1 ? " selected = 'selected' " : " " }>每季1次</option>
                        <option value="2" ${achievement.rate == 2 ? " selected = 'selected' " : " " }>每年1次</option>
                        <option value="3" ${achievement.rate == 3 ? " selected = 'selected' " : " " }>不限次数</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>全年累积最高分：</label>
                </div>
                <div class="field">
                    <input value="${achievement.sumScore}" type="text" class="input w50" name="sumScore" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field">
                    <select name="otherAttr" class="input w50">
                        <option value="1" ${achievement.otherAttr == 1 ? " selected = 'selected' " : " " }>考核优秀</option>
                        <option value="2" ${achievement.otherAttr == 2 ? " selected = 'selected' " : " " }>考核称职</option>
                    </select>
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
