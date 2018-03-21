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
        // 默认表示标题不对
        var titleFlag = false;
        // 默认表示内容不对
        var contentFlag = false;
        // 默认表示累积最高分不对
        var sumScoreFlag = false;

        $(function() {
            $("#title").blur(function () {
                var title = $("#title").val().trim();
                $("#titleTip").html("");
                if (title != "") {
                    titleFlag = true;
                }else{
                    $("#titleTip").html("标题不能为空");
                    titleFlag = false;
                }
            });

            $("#content").blur(function () {
                var content = $("#content").val().trim();
                $("#contentTip").html("");
                if (content != "") {
                    contentFlag = true;
                }else{
                    $("#contentTip").html("积分内容不能为空");
                    contentFlag = false;
                }
            });

            $("#sumScore").blur(function () {
                var sumScore = $("#sumScore").val().trim();
                $("#sumScoreTip").html("");
                if (sumScore != "") {
                    var regexScore = /^[1-9]\d*$/;
                    if(!regexScore.test(sumScore)){
                        $("#sumScoreTip").html("请输入数字");
                        sumScoreFlag = false;
                    }else {
                        sumScoreFlag = true;
                    }
                }else{
                    $("#sumScoreTip").html("全年累积最高分不能为空");
                    sumScoreFlag = false;
                }
            });

            // 表单提交
            $("#commitButton").click(function () {
                if (!titleFlag) {
                    $("#title").focus();
                    return;
                }
                if (!contentFlag) {
                    $("#content").focus();
                    return;
                }
                if (!sumScoreFlag) {
                    $("#sumScore").focus();
                    return;
                }
                $.ajax({
                    url:"${pageContext.request.contextPath}/honorsAward/createHonorsAward",
                    data:{
                        "title":$("input[name='title']").val().trim(),
                        "content":$("input[name='content']").val().trim(),
                        "lScore":$("select[name='lScore']").val(),
                        "hScore":$("select[name='hScore']").val(),
                        "rate":$("select[name='rate']").val(),
                        "sumScore":$("input[name='sumScore']").val().trim(),
                        "otherAttr":$("select[name='otherAttr']").val()
                    },
                    dataType:"json",
                    type:"post",
                    cache:false,
                    asynch:true,
                    success:function(data){
                        //alert(data.msg);
                        if(data.msg=="录入成功"){
                            alert('录入成功');
                            window.location.href='${pageContext.request.contextPath}/page/honorsAward';
                        }else {
                            alert('录入失败');
                        }
                    },
                    error:function(){
                        alert("服务器异常");
                    }
                });
            });

        })

    </script>
</head>
<body>
<div class="panel admin-panel margin-top">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>荣誉奖励录入</strong></div>
    <div class="body-content">
        <form id="addHonorsAwardForm" method="post" class="form-x" action="${pageContext.request.contextPath}/honorsAward/createHonorsAward">
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input id="title" value="${honorsAward.title}" type="text" class="input w50" name="title" />
                    <div id="titleTip" class="tips" style="color: red"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>积分内容：</label>
                </div>
                <div class="field">
                    <input id="content" value="${honorsAward.content}" type="text" class="input w50" name="content" />
                    <div id="contentTip" class="tips" style="color: red"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>分值：</label>
                </div>
                <div class="w51">
                    <select name="lScore" class="input w52" style="display: inline-table;width: 100px">
                        <option value="1" ${honorsAward.lScore == 1 ? " selected = 'selected' " : " " }>1</option>
                        <option value="2" ${honorsAward.lScore == 2 ? " selected = 'selected' " : " " }>2</option>
                        <option value="3" ${honorsAward.lScore == 3 ? " selected = 'selected' " : " " }>3</option>
                        <option value="4" ${honorsAward.lScore == 4 ? " selected = 'selected' " : " " }>4</option>
                        <option value="5" ${honorsAward.lScore == 5 ? " selected = 'selected' " : " " }>5</option>
                        <option value="6" ${honorsAward.lScore == 6 ? " selected = 'selected' " : " " }>6</option>
                        <option value="7" ${honorsAward.lScore == 7 ? " selected = 'selected' " : " " }>7</option>
                        <option value="8" ${honorsAward.lScore == 8 ? " selected = 'selected' " : " " }>8</option>
                        <option value="9" ${honorsAward.lScore == 9 ? " selected = 'selected' " : " " }>9</option>
                        <option value="10" ${honorsAward.lScore == 10 ? " selected = 'selected' " : " " }>10</option>
                        <option value="11" ${honorsAward.lScore == 11 ? " selected = 'selected' " : " " }>11</option>
                        <option value="12" ${honorsAward.lScore == 12 ? " selected = 'selected' " : " " }>12</option>
                    </select>
                    <label class="w53">到</label>
                    <select name="hScore" class="input w52" style="display: inline-table;width: 100px">
                        <option value="1" ${honorsAward.hScore == 1 ? " selected = 'selected' " : " " }>1</option>
                        <option value="2" ${honorsAward.hScore == 2 ? " selected = 'selected' " : " " }>2</option>
                        <option value="3" ${honorsAward.hScore == 3 ? " selected = 'selected' " : " " }>3</option>
                        <option value="4" ${honorsAward.hScore == 4 ? " selected = 'selected' " : " " }>4</option>
                        <option value="5" ${honorsAward.hScore == 5 ? " selected = 'selected' " : " " }>5</option>
                        <option value="6" ${honorsAward.hScore == 6 ? " selected = 'selected' " : " " }>6</option>
                        <option value="7" ${honorsAward.hScore == 7 ? " selected = 'selected' " : " " }>7</option>
                        <option value="8" ${honorsAward.hScore == 8 ? " selected = 'selected' " : " " }>8</option>
                        <option value="9" ${honorsAward.hScore == 9 ? " selected = 'selected' " : " " }>9</option>
                        <option value="10" ${honorsAward.hScore == 10 ? " selected = 'selected' " : " " }>10</option>
                        <option value="11" ${honorsAward.hScore == 11 ? " selected = 'selected' " : " " }>11</option>
                        <option value="12" ${honorsAward.hScore == 12 ? " selected = 'selected' " : " " }>12</option>
                    </select>
                    <label class="w53">分</label>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>频率：</label>
                </div>
                <div class="field">
                    <select name="rate" class="input w50">
                        <option value="0" ${honorsAward.rate == 0 ? " selected = 'selected' " : " " }>每月1次</option>
                        <option value="1" ${honorsAward.rate == 1 ? " selected = 'selected' " : " " }>每季1次</option>
                        <option value="2" ${honorsAward.rate == 2 ? " selected = 'selected' " : " " }>每年1次</option>
                        <option value="3" ${honorsAward.rate == 3 ? " selected = 'selected' " : " " }>不限次数</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>全年累积最高分：</label>
                </div>
                <div class="field">
                    <input id="sumScore" value="${honorsAward.sumScore}" type="text" class="input w50" name="sumScore" />
                    <div id="sumScoreTip" class="tips" style="color: red"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>其他属性：</label>
                </div>
                <div class="field">
                    <select name="otherAttr" class="input w50">
                        <option value="1" ${honorsAward.otherAttr == 1 ? " selected = 'selected' " : " " }>国家级</option>
                        <option value="2" ${honorsAward.otherAttr == 2 ? " selected = 'selected' " : " " }>省部级</option>
                        <option value="3" ${honorsAward.otherAttr == 3 ? " selected = 'selected' " : " " }>地市级</option>
                        <option value="4" ${honorsAward.otherAttr == 4 ? " selected = 'selected' " : " " }>县（区）级</option>
                        <option value="5" ${honorsAward.otherAttr == 5 ? " selected = 'selected' " : " " }>集团（中央企业）级</option>
                        <option value="6" ${honorsAward.otherAttr == 6 ? " selected = 'selected' " : " " }>行业级</option>
                        <option value="7" ${honorsAward.otherAttr == 7 ? " selected = 'selected' " : " " }>省公司级</option>
                        <option value="8" ${honorsAward.otherAttr == 8 ? " selected = 'selected' " : " " }>市公司级</option>
                        <option value="9" ${honorsAward.otherAttr == 9 ? " selected = 'selected' " : " " }>客户级</option>
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
