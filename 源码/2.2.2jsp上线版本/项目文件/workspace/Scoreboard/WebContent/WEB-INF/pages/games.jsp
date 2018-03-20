<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>赛事详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/indexStyle.css" rel="stylesheet" type="text/css">
   
</head>
<body>
<%@ include file="header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="bag-img">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/images/pannel01.gif" alt="运动会海报图" class="img-responsive">
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/images/pannel01.gif" alt="运动会海报图" class="img-responsive">
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="title">
                <span>赛事日程表</span>
            </div>
            <s:if test="pageBean.list.size()!=0">
            <div class="schedule">
                <table class="table table-striped">
                    <tr>
                        <th>比赛项目</th>
                        <th>日期时间</th>
                        <th>赛次</th>
                        <th>人数</th>
                    </tr>
                   <s:iterator var="g" value="pageBean.list" status="st">
                    <tr>
                        <td><s:property value="#g.gname"/></td>
                        <td class="garm-time"><s:property value="#g.gdate"/> <s:property value="#g.start"/></td>
                        <td><s:property value="#g.gameType"/></td>
                        <td><s:property value="#g.people"/></td>
                    </tr>   
                    </s:iterator>                
                    <tr>
                       <td colspan="4">
                           <nav>
                               <ul class="pagination">
                                   
                                    <s:if test="pageBean.currentPage!=1">
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.currentPage-1"/>" aria-label="Previous">
                                           <span aria-hidden="true">&laquo;</span>
                                       </a>
                                   </li>
                                   <li><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=1">首页</a></li>
                                   </s:if>
                                   
                                   <s:else>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=1" aria-label="Previous" disabled>
                                           <span aria-hidden="true">&laquo;</span>
                                       </a>
                                   </li>
                                   <li><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.currentPage-1"/>" disabled>首页</a></li>
                                   </s:else>
                                   
                                   <li class="active"><a href="#"><s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totlePages"/> </a></li>
                                   
                                   <s:if test="pageBean.currentPage!=pageBean.totlePages">
 
  
                                   <li><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.totlePages"/>">末尾</a></li>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.currentPage+1"/>" aria-label="Next">
                                           <span aria-hidden="true">&raquo;</span>
                                       </a>
                                   </li>
                                    </s:if>
                                    <s:else>
                                       <li><a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.totlePages"/>" disabled>末尾</a></li>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Game_queryGames.action?currentPage=<s:property value="pageBean.currentPage+1"/>" aria-label="Next" disabled>
                                           <span aria-hidden="true">&raquo;</span>
                                       </a>
                                   </li>
                                    </s:else>
                               </ul>
                           </nav>

                       </td>
                    </tr>
                </table>

            </div>
          </s:if>
        </div>
    </div>
</div>



<div class="modal fade" id="cheer" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <img src="${pageContext.request.contextPath}/images/logo.jpg" class="img-responsive">
            </div>
            <form>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <textarea class="form-control" rows="4" placeholder="说点什么..."></textarea>
                        </div>
                        <div class="form-group">
                            <select class="form-control">
                                <option>轻工学院</option>
                                <option>材料学院</option>
                                <option>环境学院</option>
                                <option>食品学院</option>
                                <option>机电学院</option>
                                <option>电信学院</option>
                                <option>经管学院</option>
                                <option>化工学院</option>
                                <option>设艺学院</option>
                                <option>文理学院</option>
                                <option>职教学院</option>
                                <option>镐京学院</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">提交发言</button>
                        <button type="submit" data-dismiss="modal" class="btn btn-warning">关闭取消</button>
                    </form>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".garm-time").each(function () {
            var $time=$(this).text();
            $(this).text($time.substr(5));
        })
    })
</script>
</html>