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
    
    <title>My JSP 'importScore.jsp' starting page</title>

  </head>
  
  <body>
     <h1>比赛项目分类</h1>
      <s:if test="pageBean.list.size()!=0">
    <table border="1">
      <tr>
        <td>编号</td>
        <td>比赛项目名</td>
        <td>比赛类型</td>
      </tr>
    <s:iterator var="p" value="pageBean.list" status="st">
        <tr>
           <td><s:property value="#st.count"/> </td>
        <td>
          <a href="${pageContext.request.contextPath}/Admin_ScorePage.action?gid=<s:property value="#p.gid"/>"><s:property value="#p.gname"/></a>
         </td>
        <td>比赛类型</td>
      </tr>
    </s:iterator>
    </table>
      第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totlePages"/> 
  <s:iterator begin="1" end="pageBean.totlePages" var="cp">
     <s:if  test="#cp==pageBean.currentPage">
      <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=<s:property value="#cp"/>" style="color:red"><s:property value="#cp"/></a>
     </s:if>
     <s:else>
     <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=<s:property value="#cp"/>"><s:property value="#cp"/></a>
     </s:else>
  </s:iterator>
 
  <s:if test="pageBean.currentPage!=1">
  <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=1">首页</a>
  <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=<s:property value="pageBean.currentPage-1"/>">上一页</a>
  </s:if>
  <s:if test="pageBean.currentPage!=pageBean.totlePages">
  <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=<s:property value="pageBean.currentPage+1"/>">下一页</a>
  <a href="${pageContext.request.contextPath}/Admin_importScore.action?currentPage=<s:property value="pageBean.totlePages"/>">尾页</a>
  </s:if>
  </s:if>
  <a href="${pageContext.request.contextPath}/Admin_reback.action">返回管理员页面</a>
  </body>
</html>
