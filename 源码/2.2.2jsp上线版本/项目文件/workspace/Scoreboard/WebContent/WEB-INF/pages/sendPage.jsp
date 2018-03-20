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
    <title>互动专区</title>
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
                <span>实时互动排名</span>
            </div>
            <div>
                <table class="table">
                    <tr>
                        <th>学院名称</th>
                        <th>发帖数</th>
                    </tr> 
                    <s:iterator var="a" value="alist">               
                     <tr>
                         <td><img src="${pageContext.request.contextPath}/picture/<s:property value="#a.picture"/>"></td>
                         <td><s:property value="#a.totalPost"/></td>
                     </tr>
                   </s:iterator>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="title">
                <span>实时互动专区</span>
                <button type="button" class="btn" data-toggle="modal" data-target="#cheer">我要发言</button>
            </div>
        </div>
    </div>
    <s:iterator var="p" value="pageBean.list"  status="st">               
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
            <div class="section">
                <span>第<s:property value="#p.pid"/>楼</span>
                <p style="text-indent:5em">    
                      <s:property value="@com.ljj.domain.Post@getTrue(#p.content)"/>  
                </p>     
                <label class="clearfix">
                    <span>From:<s:property value="#p.academe.acname"/></span>
                    <span class="section-time">Time:<s:property value="#p.time"/></span>
                </label>
            </div>
        </div>
    </div>
    </s:iterator> 
     <s:if test="pageBean.list!=null"> 
      <div class="row">
        <div class="paging">
          <nav>
         <ul class="pagination">                                    
                                    <s:if test="pageBean.currentPage!=1">
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.currentPage-1"/>" aria-label="Previous">
                                           <span aria-hidden="true">&laquo;</span>
                                       </a>
                                   </li>
                                   <li><a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=1">首页</a></li>
                                   </s:if>
                                   
                                   <s:else>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=1" aria-label="Previous" disabled>
                                           <span aria-hidden="true">&laquo;</span>
                                       </a>
                                   </li>
                                   <li><a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.currentPage-1"/>" disabled>首页</a></li>
                                   </s:else>
                                   
                                   <li class="active"><a href="#"><s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totlePages"/> </a></li>
                                   
                                   <s:if test="pageBean.currentPage!=pageBean.totlePages">
 
  
                                   <li><a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.totlePages"/>">末尾</a></li>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.currentPage+1"/>" aria-label="Next">
                                           <span aria-hidden="true">&raquo;</span>
                                       </a>
                                   </li>
                                    </s:if>
                                    <s:else>
                                       <li><a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.totlePages"/>" disabled>末尾</a></li>
                                   <li>
                                       <a href="${pageContext.request.contextPath}/Post_sendPage?currentPage=<s:property value="pageBean.currentPage+1"/>" aria-label="Next" disabled>
                                           <span aria-hidden="true">&raquo;</span>
                                       </a>
                                   </li>
                                    </s:else>
                               </ul>
                           </nav>  
        </div>

      </div>     
     
    </s:if>
              
</div>

<div class="modal fade" id="cheer" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
                <img src="${pageContext.request.contextPath}/images/logo.jpg" class="img-responsive">
            </div>
                <div class="modal-body">
                   <form action="${pageContext.request.contextPath}/Post_savePage.action" method="post" onsubmit="return confirm()">
                        <div class="form-group">
                            <textarea class="form-control" rows="4" placeholder="说点什么..." name="content"></textarea>
                        </div>
                        <div class="form-group">
                        
                            <select class="form-control" name="academe.acid">
                               <s:iterator var="a" value="alist">
                                    <option value="<s:property value="#a.acid"/>"> <s:property value="#a.acname"/></option>
                               </s:iterator>
                            </select>   
                            <input type="hidden" name="currentPage" value="1">                                        
                        </div>
                        <button type="submit" class="btn btn-primary">提交发言</button>
                        <button type="button" data-dismiss="modal" class="btn btn-warning">关闭取消</button>
                    </form>
                </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $(".section-time").each(function () {
            var $time=$(this).text();
            if($time||$time=="")
              $(this).text($time.substr(0,18));
        });
    });
    function confirm()
    {
        var $textLength=$("#cheer form textarea").val().length;
        if($textLength == 0)
        {
            console.log($textLength);
            alert("请填写您要说的话！我们不提交空帖子！");
            $("#cheer form textarea").focus();
            return false;
        }
        else if($textLength >=255)
        {
            console.log($textLength);
            alert("您的文采太好了！超出了我们的帖子长度要求！（255字）");
            $("#cheer form textarea").focus();
            return false;
        }
        else
        {
            console.log($textLength);
            return true;
        }
    }
</script>
</html>