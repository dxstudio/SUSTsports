<?php
header('content-type=text/html;charset=utf-8');
include "config.php";
include "sumscore.php";
	$sql="select * from academy order by academyID";
	$rst=mysql_query($sql);
	
	//$sql="select sum(score) AS total,academy from athlete GROUP BY academy order by score";

	//$rst=mysql_query($sql);



?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>sum</title>
</head>
<body>
<center>

	<table width="500px" border="1" cellspacing="0">
		<tr>
			
			<th>academy</th>
			<th>academyID</th>
			<th>score</th>
			
		</tr>
		<?php
			while($row=mysql_fetch_assoc($rst)){
				echo "<tr>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['academyID']}</td>";
				echo "<td>{$row['score']}</td>";
				
				echo "</tr>";
			}
		?>
	</table>
		
</center>
</body>
</html>