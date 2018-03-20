<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>运动会积分榜</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/indexStyle.css" rel="stylesheet" type="text/css">
   
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="bag-img">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                  <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/images/pannel01.gif" alt="运动会海报图" class="img-responsive">
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/images/pannel02.gif" alt="运动会海报图" class="img-responsive">
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/images/bg10.jpg" alt="运动会海报图" class="img-responsive">
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="title">
                <span>学院积分排名</span>
            </div>
        </div>
    </div>
    <s:iterator var="a" value="aclist" status="st">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="academy-item" data-target='<s:property value="#st.count"/>'>
                <div class="academy-img">
                    <img src="${pageContext.request.contextPath}/picture/<s:property value="#a.picture"/>" class="img-responsive">
                </div>
                <div class="rank-img">
                    <img src="${pageContext.request.contextPath}/images/<s:property value="#st.count"/>.jpg" class="img-responsive">
                </div>
            </div>
            <div class="academy-content clearfix" data-content="<s:property value="#st.count"/>">
                <label>总分：<s:property value="#a.totalScore"/>分</label>
                <div class="gold"><span>金牌:</span><img src="${pageContext.request.contextPath}/images/gold.gif"><span>X <s:property value="#a.gold"/>枚</span></div>
                <div class="silver"><span>银牌:</span><img src="${pageContext.request.contextPath}/images/silver.gif"><span>X  <s:property value="#a.silver"/>枚</span></div>
                <div class="copper"><span>铜牌:</span><img src="${pageContext.request.contextPath}/images/copper.gif"><span>X <s:property value="#a.copper"/>枚</span></div>
            </div>
        </div>
    </div>
    </s:iterator>  
</div>

<%@ include file="footer.jsp"%>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".academy-item").on('click', function () {
            var $CurrentClick = $(this).attr("data-target");
            $(".academy-content[data-content=" + $CurrentClick + "]").slideToggle("500");
        })
    })
</script>
</html>
