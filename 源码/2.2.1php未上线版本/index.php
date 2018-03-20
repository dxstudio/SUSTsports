<?php
	include "php/config.php";
	$sql="select * from academy order by score DESC limit 0,3";
	$rst=mysql_query($sql);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,
maximum-scale=1,user-scalable=no" />
	<title>陕西科技大学校运会</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<div id="container" style="height:100%;">
	    <!--title-->
 		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 header">校运会积分榜</div>
 			<div class="row content">
 				<div class="col-sm-12 col-md-6 col-lg-8 swiper">
  					<div id="myCarousel" class="carousel slide">
					   <!-- 轮播（Carousel）指标 -->
					   <ol class="carousel-indicators">
					      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					      <li data-target="#myCarousel" data-slide-to="1"></li>
					      <li data-target="#myCarousel" data-slide-to="2"></li>
					   </ol>   
					   <!-- 轮播（Carousel）项目 -->
					   <div class="carousel-inner">
					      <div class="item active">
					         <img src="img/slide.jpg" alt="First slide">
					      </div>
					      <div class="item">
					          <img src="img/slide.jpg" alt="First slide">
					      </div>
					      <div class="item">
					          <img src="img/slide.jpg" alt="First slide">
					      </div>
					   </div>
					   <!-- 轮播（Carousel）导航 -->
					   <a class="carousel-control left" href="#myCarousel" 
					      data-slide="prev">&lsaquo;</a>
					   <a class="carousel-control right" href="#myCarousel" 
					      data-slide="next">&rsaquo;</a>
					</div>
 				</div>
 				<!--rank-->
 				<div class="col-sm-12 col-md-6 col-lg-4 grades">
  					<div class="panel panel-default">
   						<div class="panel-heading">
   							<h5 align="center">学院积分排名</h5>
   						</div>
   						<table class="table">
						    <tr>
						       	<th>名次</th>
						        <th>学院</th>
						        <th>积分</th>
						    </tr></thead>
						    <?php
						    	
						    	for($i=1;$row=mysql_fetch_assoc($rst);$i++){
						    		echo "<tr>";
						    		echo "<td>$i</td>";
									echo "<td>{$row['academy']}</td>";
									echo "<td>{$row['score']}</td>";
									echo "</tr>";
						    	}
						    ?>				      	
   						</table>
   					</div>
   					<center>
   					<a class="btn btn-primary" href="php/rank.php">更多排名</a>
   					<a class="btn btn-primary" href="html/grades.html">项目详情</a>
   					<a class="btn btn-primary" href="php/comment.php">点我留言</a>
   					</center>
   				</div>
			</div>
 		</div>
 		<div class="col-sm-12 col-md-6 col-lg-8 news">
		  	<h5><b>实时资讯</b></h5>
		  	<div class="media">
		    	<div class="media-left media-middle">
		    		<a href="html/news1.html"><img class="media-object" src="img/news1.jpg"/></a> 
		    	</div>
		    	<div class="media-body">
			      	<h5 class="media-heading"><a href="html/news1.html">运动会｜你玩嗨了没？</a></h5>
			      	<span>千呼万唤始出来！在我们翘首期盼中，终于迎来了我们一年一度的春季运动会。</span>
		      	</div>
		  	</div>
		  	<div class="media">
		    	<div class="media-left media-middle"> 
		    		<a href="html/news2.html"> <img class="media-object" src="img/news2.jpg"> </a> 
		    	</div>
				<div class="media-body">
					<h5 class="media-heading"><a href="html/news2.html">镐京，浩惊 | 你们要的男神</a></h5><span>运动会开始不久，新晋男神镐京学院的1416号选手——张浩,悄悄地你来了，不经意间</span>
				</div>
			</div>
			<div class="media">
			  		<div class="media-left media-middle">
			  			<a href="html/news2.html"> <img class="media-object" src="img/news3.jpg"></a>
			  		</div>
				  	<div class="media-body">
				   		<h5 class="media-heading"><a href="html/news3.html">我们相拥于暮春——看科大的运动会！</a></h5>春末夏初，绚丽的季节，依然是她的本色，而我们要自信地展示我们的模样，在四月
				   	</div>
			</div>
 		</div>
 	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 footer"> &copy;点心网络工作室 </div>
</div>
</body>
</html>