<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'importGamePage.jsp' starting page</title>
  </head>
  
  <body>
    <h1>更新比赛项目页面</h1>
   <form action="${pageContext.request.contextPath}/Admin_importGameData.action" method="post" enctype="multipart/form-data" >
            文 件： <input type="File" name="athlete" id="file1">
              <input type="hidden" name="size" value="8">
            <input type="submit" value="提交">
  </form>
  <a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a>
  </body>
</html>
