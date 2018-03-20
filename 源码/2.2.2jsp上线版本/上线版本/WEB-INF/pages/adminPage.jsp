<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminPage.jsp' starting page</title>

  </head>
  
  <body>
       <h1>管理员页面</h1>
       <s:if test="#session.list==null">
       <a href="${pageContext.request.contextPath}/Academe_initAcademe.action?">是初始化学院信息</a>
       </s:if>
       <s:else>
          <s:property value="#session.admin.aname"/>
       </s:else>
       <hr>
       <s:actionerror/>
       <p><a href="${pageContext.request.contextPath}/Admin_importPage.action?">导入参赛运动员的信息</a></p>
       <p><a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=1">导入比赛成绩</a></p>
      <p> <a href="${pageContext.request.contextPath}/Admin_importGame.action?">导入比赛信息</a></p>
      <p> <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=1">查看运动员的信息</a></p>
       <p><a href="${pageContext.request.contextPath}/Admin_clearScore.action?">清空积分榜</a></p>
       <p> <a href="${pageContext.request.contextPath}/Admin_loginout.action?">退出返回管理员页面</a></p>
  </body>
</html>
