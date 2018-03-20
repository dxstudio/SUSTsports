<?php
	include "config.php";
	$sql="select * from academy order by score DESC";
	$rst=mysql_query($sql);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" />
	<title>rank</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../css/rank.css" rel="stylesheet">
	<script src="../js/jquery.min.js"></script>
   	<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<center>
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
</center>
</body>
</html>