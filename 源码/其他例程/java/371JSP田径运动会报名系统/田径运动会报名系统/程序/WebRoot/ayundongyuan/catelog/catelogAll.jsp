<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/public.js"></script>
        <script language="javascript">
            function baoming(catelogId)
            {
                  var url="<%=path %>/baomingAdd.action?catelogId="+catelogId;
		          //var n="";
		          //var w="300px";
		          //var h="200px";
		          //var s="resizable:no;help:no;status:no;scroll:yes";
		         // openWin(url,n,w,h,s);
		         window.location.href=url;
            }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/images/tbg.gif">&nbsp;运动项目&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="25%">ID</td>
					<td width="25%">运动项目名称</td>
					<td width="25%">运动项目简介</td>
					<td width="25%">报名</td>
		        </tr>	
				<s:iterator value="#request.cateLogList" id="catelog">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#catelog.catelogId"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#catelog.catelogName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#catelog.catelogMiaoshu" escape="false"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a style="color: red" href="#" onclick="baoming(<s:property value="#catelog.catelogId"/>)">我要报名</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
