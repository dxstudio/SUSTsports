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
    
    <title>My JSP 'importSuccess.jsp' starting page</title>

  </head>
  
  <body>
    <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=1">查看运动员的信息</a>
    <a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a>
    <!--  <a href="${pageContext.request.contextPath}/Score_querySC.action?<s:property value="gid"/>">查询导入第项目的成绩</a>-->
   <s:if test="pageBean.list.size()!=null">
    <table border="1">
      <tr>
        <td>编号</td>
        <td>运动员的学号</td>
        <td>运动员的姓名</td>
        <td>参赛项目</td>
        <td>参赛编号</td>
        <td>名次</td>
        <td>成绩</td>
        <td>积分</td>     
      </tr>
    <s:iterator var="p" value="pageBean.list" status="st">
        <tr>
        <td><s:property value="#st.count"/> </td>
        <td><s:property value="#p.athlete.snum"/></td>
        <td><s:property value="#p.athlete.aname"/></td>
        <td><s:property value="#p.game.gname"/></td>
        <td><s:property value="#p.anum"/></td>
        <td><s:property value="#p.sort"/></td>
        <td><s:property value="#p.score"/></td>
        <td><s:property value="#p.integrate"/></td>
      </tr>
    </s:iterator>
    </table>
      第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totlePages"/> 
  <s:if test="pageBean.currentPage!=1">
  <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=1">首页</a>
  <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
  </s:if>
  <s:if test="pageBean.currentPage!=pageBean.totlePages">
  <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>
  <a href="${pageContext.request.contextPath}/Score_inform.action?currentPage=<s:property value="pageBean.totlePages"/>">尾页</a>
  </s:if>
  </s:if>
  <hr>
  <table border="1">
     <tr>
       <td>项目</td>
       <td>成绩</td>
       <td>名次</td>
       <td>积分</td>
     </tr>
  <s:iterator var="l" value="list">
      <tr>
        <td><s:property value="#l.game.gname"/> </td>
        <td><s:property value="#l.score"/> </td>
        <td><s:property value="#l.sort"/> </td>
        <td><s:property value="#l.integrate"/> </td>
      </tr>
  </s:iterator>
  </table>
      
  </body>
  </body>
</html>
