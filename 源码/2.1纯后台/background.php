<?php
	header("content-type=text/html;charset=utf-8");
	include "config.php";
	if(!$_COOKIE['userid'])
	{
		echo "<script>location='backgroundLogin.php'</script>";

	}
	$sql="select * from athletescore order by id";
	$rst=mysql_query($sql);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>background</title>
	<style type="text/css">
		td{
			text-align: center;
		}
	</style>
</head>
<body>
<center>
	<h3>List | <a href="add.php">Add</a></h3>
	<table width="500px" border="1" cellspacing="0">
		<tr>
			<th>id</th>
			<th>competition</th>
			<th>sex</th>
			<th>date</th>
			<th>time</th>
			<th>number</th>
			<th>name</th>
			<th>academy</th>
			<th>academyID</th>
			<th>score</th>
			<th>rank</th>
			<th>severtime</th>
			<th>edit</th>
			<th>delete</th>
			<th>breakrecord</th>
		</tr>
		<?php
			while ($row=mysql_fetch_assoc($rst)) {
				echo "<tr>";
				echo "<td>{$row['id']}</td>";
				echo "<td>{$row['competition']}</td>";
				echo "<td>{$row['sex']}</td>";		
				echo "<td>{$row['date']}</td>";
				echo "<td>{$row['time']}</td>";
				echo "<td>{$row['number']}</td>";
				echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['academyID']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['severtime']}</td>";
				echo "<td><a href='edit.php?id={$row['id']}'><img src='images/edit.png' height='22px'</a></td>";
				echo "<td><a href='delete.php?id={$row['id']}'><img src='images/delete.png' height='22px'</a></td>";
				echo "<td><a href='breakrecord.php?id={$row['id']}'><img src='images/breakrecord.png' height='22px'</a></td>";
				echo "</tr>";
			}
		?>
	</table>
</center>
</body>
</html>