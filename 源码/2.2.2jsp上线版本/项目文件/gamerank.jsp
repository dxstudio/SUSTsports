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
    <title>赛事详情</title>
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
                <span>比赛结果统计</span>
            </div>
        </div>
    </div>
  
   <s:iterator var="s" value="list" status="st">
       <div class="row">              
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">      
         <s:if test="#s.sort==1">   
            <s:set var="n" value="#s.game.gid"/>
            <div class="game-item" data-target="<s:property value="#s.game.gid"/>">
                <span><s:property value="#s.game.gname"/></span>
            </div>
           
            <div class="game-item-rank" data-content="<s:property value="#s.game.gid"/>">
                  <table class="table">
                      <tr>
                        <td><img src="${pageContext.request.contextPath}/images/gold.gif"><span>金牌:</span></td>
                        <td><span><s:property value="#s.athlete.aname"/></span></td>
                        <td><span><s:property value="#s.score"/></span></td>
                      </tr>
                 </table>
           </div>
          </s:if>
               <s:if test="#s.sort==2&&#n==#s.game.gid">
                <div class="game-item-rank" data-content="<s:property value="#s.game.gid"/>">
                  <table class="table">
                      <tr>
                        <td><img src="${pageContext.request.contextPath}/images/silver.gif"><span>银牌:</span></td>
                        <td><span><s:property value="#s.athlete.aname"/></span></td>
                        <td><span><s:property value="#s.score"/></span></td>
                      </tr>
                 </table>
           </div>
         </s:if>
         <s:if test="#s.sort==3&&#n==#s.game.gid"> 
              <div class="game-item-rank" data-content="<s:property value="#s.game.gid"/>">
                  <table class="table">
                      <tr>
                        <td><img src="${pageContext.request.contextPath}/images/copper.gif"><span>铜牌:</span></td>
                        <td><span><s:property value="#s.athlete.aname"/></span></td>
                        <td><span><s:property value="#s.score"/></span></td>
                      </tr>
                 </table>
           </div>
          </s:if>        
        </div>
    </div>
 </s:iterator>
</div>
<div class="footer container-fluid">
    <img src="${pageContext.request.contextPath}/images/logo4.png">&nbsp;
    <img src="${pageContext.request.contextPath}/images/logo2.jpg">
    <br>
    <span>&copy;点心网络文化工作室</span>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".game-item").on('click', function () {
            var $CurrentClick = $(this).attr("data-target");
            $(".game-item-rank[data-content=" + $CurrentClick + "]").slideToggle("300");
        })
    })
</script>
</html>