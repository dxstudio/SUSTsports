<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'importScorePage.jsp' starting page</title>
    
  </head>
  
  <body>
    <h1>导入比赛成绩页面</h1>
   <form action="${pageContext.request.contextPath}/Admin_importScoreData.action" method="post" enctype="multipart/form-data" >
            文 件： <input type="File" name="athlete" id="file1">
            <input type="hidden" name="gid" value='<s:property value="gid"/>'>
            <select name="size">
                  <option value="7">个人项目</option>
                  <option value="6">团体项目</option>
            </select>
            <input type="submit" value="提交">
  </form>
  <a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a>
  </body>
</html>
