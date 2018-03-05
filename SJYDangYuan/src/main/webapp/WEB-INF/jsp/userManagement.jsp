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
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
        <button type="button" class="button border-yellow"
                onclick="window.location.href='${pageContext.request.contextPath}/page/addUser'">
            <span class="icon-plus-square-o"></span> 添加用户
        </button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="3%">ID</th>
            <th width="5%">账户名</th>
            <th width="5%">身份证号</th>
            <th width="5%">真实姓名</th>
            <th width="5%">性别</th>
            <th width="5%">所属支部</th>
            <th width="10%">操作</th>
        </tr>
        <c:forEach items="${pageInfo.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.accountName}</td>
                <td>${user.idCard}</td>
                <td>${user.userName}</td>
                <td>
                    <c:if test="${user.gender==0}">
                        女
                    </c:if>
                    <c:if test="${user.gender==1}">
                        男
                    </c:if>
                </td>
                <td>${user.branch}</td>
                <td>
                    <div class="button-group">
                        <button id="resetPwd" onclick="return resetPwd(${user.id},'${user.userName}')"
                           class="button border-main">
                            <span class="icon-edit"></span> 重置密码
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">
    function resetPwd(userId, userName) {
        if (confirm("您确定要为 " + userName + " 重置密码吗?")) {
            $.ajax({
                url:"${pageContext.request.contextPath}/user/resetPwd",
                data:{"userId":userId},
                dataType:"json",
                type:"post",
                cache:false,
                asynch:true,
                success:function(data){
                    alert(data.msg);
                },
                error:function(){
                    alert("服务器异常");
                }
            });
        }
    }
</script>
<div class="pagelist">
    <c:if test="${pageInfo.pages!=1}">
        <a href="${pageContext.request.contextPath}/page/userManagement?currentPage=1&pageSize=${pageInfo.pageSize}">首页</a>
    </c:if>
    <c:if test="${pageInfo.pageNum!=1}">
        <a href="${pageContext.request.contextPath}/page/userManagement?currentPage=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>
    </c:if>
    <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
        <a href="${pageContext.request.contextPath}/page/userManagement?currentPage=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下一页</a>
    </c:if>
    <c:if test="${pageInfo.pages!=1}">
        <a href="${pageContext.request.contextPath}/page/userManagement?currentPage=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a>
    </c:if>
    <span style="color: #333333;">&nbsp;当前&nbsp;${pageInfo.pageNum}&nbsp;/&nbsp;${pageInfo.pages}&nbsp;页&nbsp;，&nbsp;共&nbsp;${pageInfo.total}&nbsp;条</span>
</div>
</body>
</html>