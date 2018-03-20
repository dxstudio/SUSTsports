<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default  navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/images/logo.jpg" class="img-responsive logo">
                <span>陕西科技大学运动会</span>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                 <li><a href="${pageContext.request.contextPath}/index.action">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=1">赛事详情</a></li>
                <li><a href="${pageContext.request.contextPath}/Post_sendPage.action?currentPage=1">互动专区</a></li>
              
               
                <li><a href="${pageContext.request.contextPath}/Score_queryResult.action?currentPage=1">结果统计</a></li> 
                <li><a href="${pageContext.request.contextPath}/Admin_loginPage.action">管理员登陆</a></li>                          
            </ul>
        </div>
    </div>
</nav>