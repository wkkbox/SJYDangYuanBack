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
        <button type="button" class="button border-yellow" onclick="window.location.href='${pageContext.request.contextPath}/page/addSheZe'">
            <span class="icon-plus-square-o"></span> 社责录入
        </button>
    </div>
    <table class="table table-hover text-center">
        <tr>
            <th width="3%">ID</th>
            <th width="5%">标题</th>
            <th width="10%">积分内容</th>
            <th width="5%">分值/次</th>
            <th width="5%">频率</th>
            <th width="5%">其他属性</th>
            <th width="5%">全年累积最高分</th>
            <%--<th width="5%">操作</th>--%>
        </tr>
        <c:forEach items="${pageInfo.list}" var="sheZe">
            <tr>
                <td>${sheZe.id}</td>
                <td>${sheZe.title}</td>
                <td>${sheZe.content}</td>
                <td>
                    <c:if test="${sheZe.dScore == -1}">
                        ${sheZe.lScore} - ${sheZe.hScore}
                    </c:if>
                    <c:if test="${sheZe.dScore != -1}">
                        ${sheZe.dScore}
                    </c:if>
                </td>
                <td>
                    <c:if test="${sheZe.rate==0}">
                        每月1次
                    </c:if>
                    <c:if test="${sheZe.rate==1}">
                        每季1次
                    </c:if>
                    <c:if test="${sheZe.rate==2}">
                        每年1次
                    </c:if>
                    <c:if test="${sheZe.rate==3}">
                        不限次数
                    </c:if>
                </td>
                <td>
                    <c:if test="${sheZe.otherAttr==0}">
                        无
                    </c:if>
                    <c:if test="${sheZe.otherAttr==1}">
                        个人名义参加
                    </c:if>
                    <c:if test="${sheZe.otherAttr==2}">
                        集体名义参加
                    </c:if>
                </td>
                <td>${sheZe.sumScore}</td>
                <%--<td>
                    <div class="button-group">
                        <a class="button border-main" href="${pageContext.request.contextPath}/page/editSheZe?shezeId=${sheZe.id}">
                            <span class="icon-edit"></span> 修改
                        </a>
                    </div>
                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<script type="text/javascript">
    function del(id,mid){
        if(confirm("您确定要删除吗?")){
            alert("删除成功")
        }
    }
</script>
<div class="pagelist">
    <c:if test="${pageInfo.pages!=1}">
        <a href="${pageContext.request.contextPath}/page/sheZeManagement?currentPage=1&pageSize=${pageInfo.pageSize}">首页</a>
    </c:if>
    <c:if test="${pageInfo.pageNum!=1}">
        <a href="${pageContext.request.contextPath}/page/sheZeManagement?currentPage=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}">上一页</a>
    </c:if>
    <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
        <a href="${pageContext.request.contextPath}/page/sheZeManagement?currentPage=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}">下一页</a>
    </c:if>
    <c:if test="${pageInfo.pages!=1}">
        <a href="${pageContext.request.contextPath}/page/sheZeManagement?currentPage=${pageInfo.pages}&pageSize=${pageInfo.pageSize}">尾页</a>
    </c:if>
    <span style="color: #333333;">&nbsp;当前&nbsp;${pageInfo.pageNum}&nbsp;/&nbsp;${pageInfo.pages}&nbsp;页&nbsp;，&nbsp;共&nbsp;${pageInfo.total}&nbsp;条</span>
</div>
</body>
</html>