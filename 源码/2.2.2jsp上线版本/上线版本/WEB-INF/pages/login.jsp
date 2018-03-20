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
    <title>管理员登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/indexStyle.css" rel="stylesheet" type="text/css">
</head>
<body class="adminBody">
<%@ include file="header.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="adminLoginForm">
                <h2>管理员登录</h2><span><s:actionerror name="f3"/></span>
                <form action="${pageContext.request.contextPath}/Admin_adminLogin" method="post" onSubmit="return loginConfirm()" class="loginForm" >
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="请输入管理员账号..." name="aname" required >
                       <br> <span><s:fielderror fieldName="aname" name="f2"/></span>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control"  placeholder="请输入账号密码..."name="apwd" required>
                       <br> <span><s:fielderror fieldName="apwd" name="f1"/></span>
                    </div>
                    <button type="submit" class="btn btn-primary">登录</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="footer container-fluid adminFooter">
    <img src="images/logo4.png">&nbsp;
    <img src="images/logo2.jpg">
    <br>
    <span>&copy;点心网络文化工作室</span>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    function loginConfirm() {
        var $usernameLength=$(".loginForm input[type='text']").val().length;
        var $passwordLength=$(".loginForm input[type='password']").val().length;

        if($usernameLength==0)
        {
            alert("请输入正确的管理员账户！");
            $(".loginForm input[type='text']").focus();
            return false;
        }
        if($passwordLength>13 || $passwordLength <6)
        {
            alert("密码长度不合法，请重新输入！");
            $(".loginForm input[type='password']").focus();
            return false;
        }
        else
        {
            return true;
        }
    }
</script>
</html>
