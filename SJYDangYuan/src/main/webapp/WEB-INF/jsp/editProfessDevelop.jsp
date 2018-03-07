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
            $("#editAchievementForm").validate({
                rules:{
                    "title":{
                        required:true
                    },
                    "content":{
                        required:true
                    }
                },
                messages:{
                    "title":{
                        required:"标题不能为空"
                    },
                    "content":{
                        required:"积分内容不能为空"
                    }
                }
            });
        })

    </script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>专业提升修改</strong></div>
    <div class="body-content">
        <form id="editAchievementForm" method="post" class="form-x" action="${pageContext.request.contextPath}/professDevelop/editProfessDevelop">
            <input type="hidden" value="${professDevelop.id}" name="id" />
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input value="${professDevelop.title}" type="text" class="input w50" name="title" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>积分内容：</label>
                </div>
                <div class="field">
                    <input value="${professDevelop.content}" type="text" class="input w50" name="content" />
                </div>
            </div>
            <%--<div class="form-group">
                <div class="label">
                    <label>分值：</label>
                </div>
                <div class="w51">
                    <select name="lScore" class="input w52">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <label class="w53">到</label>
                    <select name="hScore" class="input w52">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <label class="w53">分</label>
                    <div class="tips"></div>
                </div>
            </div>--%>
            <%--<div class="form-group">
                <div class="label">
                    <label>频率：</label>
                </div>
                <div class="field">
                    <select name="rate" class="input w50">
                        &lt;%&ndash;${dangZe.rate == 0 ? " selected = 'selected' " : " " }&ndash;%&gt;
                        <option value="0" >每月1次</option>
                        <option value="1" >每季1次</option>
                        <option value="2" >每年1次</option>
                        <option value="3" >不限次数</option>
                    </select>
                </div>
            </div>--%>
            <%--<div class="form-group">
                <div class="label">
                    <label>全年累积最高分：</label>
                </div>
                <div class="field">
                    <input value="" type="text" class="input w50" name="sumScore" />
                    <div class="tips"></div>
                </div>
            </div>--%>
            <%--<div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field">
                    <select name="otherAttr" class="input w50">
                        <option value="0" >无</option>
                        <option value="1" >个人名义参加</option>
                        <option value="2" >集体名义参加</option>
                    </select>
                </div>
            </div>--%>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 确认修改</button>
                    <span style="color: red">${msg}</span>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
