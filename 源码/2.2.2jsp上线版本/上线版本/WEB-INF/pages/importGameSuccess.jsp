<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'importGameSuccess.jsp' starting page</title>
    

  </head>
  
  <body>
   操作成功！点击此处<a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a><br>
 <p><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=1"">点击查看比赛项目</a></p>
  </body>
</html>
