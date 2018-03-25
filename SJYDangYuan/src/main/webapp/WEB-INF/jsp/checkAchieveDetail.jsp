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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/zooming.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css"/>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>审批内容</strong></div>
    <div class="body-content">
        <input type="hidden" name="userAchievementId" value="${userAchievementId}"/>
        <input type="hidden" name="contentId" value="${contentId}"/>
        <input type="hidden" name="userId" value="${userId}"/>
        <input type="hidden" name="otherAttr" value="${otherAttr}" />
        <form method="post" class="form-x" action="">
            <div class="form-group">
                <div class="label">
                    <label>活动标题：</label>
                </div>
                <div class="field">
                    <input readonly="readonly" type="text" class="input w50" name="achievementTitle" value="${achievementTitle}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>活动内容：</label>
                </div>
                <div class="field">
                    <input readonly="readonly" type="text" class="input" name="achievementContent" value="${achievementContent}"/>
                </div>
            </div>

            <c:if test="${imgs.size()>=1}">
                <div class="form-group">
                    <div class="label">
                        <label>活动拍照：</label>
                    </div>
                    <div id="imgchk" class="field">
                        <c:forEach items="${imgs}" var="img">
                                <img class="img-zoomable" style="margin: 2px;width: 200px;height: 200px" src="http://101.132.177.132:8081/${img}">
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <div class="form-group">
                <div class="label">
                    <label>内容记录：</label>
                </div>
                <div class="field">
                    <input readonly="readonly" type="text" class="input" name="commitContent" value="${commitContent}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>分值/次：</label>
                </div>
                <div class="field">
                    <c:if test="${dScore == -1}">
                        <input readonly="readonly" type="text" class="input w50" value="${lScore} - ${hScore}"/>
                    </c:if>
                    <c:if test="${dScore != -1}">
                        <input readonly="readonly" type="text" class="input w50" value="${dScore}"/>
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>得分：</label>
                </div>
                <div class="field">
                    <c:if test="${dScore == -1}">
                        <input id="rScore" type="text" class="input w50" name="rScore" value="${lScore}"/>
                    </c:if>
                    <c:if test="${dScore != -1}">
                        <input readonly="readonly" id="rScore" type="text" class="input w50" name="rScore"
                               value="${dScore}"/>
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <a href="javascript:void(0)" id="checkPass"
                       onclick="checkPass(${userAchievementId},${userId},${dScore},${lScore},${hScore},'${achievementTitle}',${otherAttr})"
                       class="button bg-main icon-check-square-o">
                        审批通过
                    </a>
                    <%--<a href="${pageContext.request.contextPath}/page/checkDangZe" class="button bg-main icon-check-square-o" type="button"> 审批通过</a>--%>
                    <%--<button class="button bg-main icon-check-square-o" type="button"> 驳回</button>--%>
                    <a href="javascript:void(0)" id="checkNo" onclick="checkNo(${userAchievementId},${userId},'${achievementTitle}',${otherAttr})"
                       class="button bg-main icon-check-square-o">
                        驳回
                    </a>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">

    //图片放大
    var zooming = new Zooming({
        customSize: {
            width: 400,
            height: 400
        }
    });
    zooming.listen('.img-zoomable');

    function checkPass(userAchievementId, userId, dScore, lScore, hScore,title,otherAttr) {
        if (dScore == -1) {
            if ($("#rScore").val() > hScore || $("#rScore").val() < lScore) {
                alert("得分应在"+lScore+"到"+hScore+"之间");
                return;
            }
        }

        $.ajax({
            url:"${pageContext.request.contextPath}/achievement/passAchievement",
            data:{
                "userAchievementId":userAchievementId,
                "rScore":$("#rScore").val(),
                "userId":userId,
                "title":title,
                "otherAttr":otherAttr
            },
            dataType:"json",
            type:"post",
            cache:false,
            asynch:true,
            success:function(data){
                alert(data.msg);
                window.location.href='${pageContext.request.contextPath}/page/checkAchieve';
            },
            error:function(){
                alert("服务器异常");
            }
        });


    }

    function checkNo(userAchievementId,userId,title,otherAttr) {
        $.ajax({
            url:"${pageContext.request.contextPath}/achievement/noPassAchievement",
            data:{
                "userAchievementId":userAchievementId,
                "userId":userId,
                "title":title,
                "otherAttr":otherAttr
            },
            dataType:"json",
            type:"post",
            cache:false,
            asynch:true,
            success:function(data){
                alert(data.msg);
                window.location.href='${pageContext.request.contextPath}/page/checkAchieve';
            },
            error:function(){
                alert("服务器异常");
            }
        });
    }
</script>
</body>
</html>