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
    <title>My JSP 'importPage.jsp' starting page</title>
  </head> 
  <body>
   <h1>导入数据页面</h1>
   <span id="sp"></span>
   <s:actionerror/>
   <form action="${pageContext.request.contextPath}/Admin_importData.action" method="post" enctype="multipart/form-data" >
            文 件： <input type="File" name="athlete" id="file1">
            <select name="size">
                  <option value="5">个人项目</option>
                  <option value="4">团体项目</option>
            </select>
            <input type="submit" value="提交" >
  </form>
  <a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a>
  </body>
</html>
