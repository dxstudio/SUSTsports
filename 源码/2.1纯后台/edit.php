
<?php
	header('content-type=text/html;charset=utf-8');
	include "config.php";
	$id=$_GET['id'];
	$sql="select * from athletescore where id={$id}";
	$rst=mysql_query($sql);
	$row=mysql_fetch_assoc($rst);
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Edit</title>
	<style type="text/css">
		h3{
			text-align: center;
		}
		div{
			width: 150px;
			margin: 0 auto;
		}
	</style>
</head>
<body>

<h3>Edit score</h3>
<div>
<form action="checkEdit.php" method="post">
		<b>please input:</b><br>
		<input type="hidden" name="id" value='<?php echo $row['id'] ?>'>
		competition:<br><input type="text" name="competition" value='<?php echo $row['competition'] ?>'><br>
		sex:<br><input type="text" name="sex" value='<?php echo $row['sex'] ?>'><br>
		date:<br><input type="text" name="date" value='<?php echo $row['date'] ?>'><br>
		time:<br><input type="text" name="time" value='<?php echo $row['time'] ?>'><br>
		number:<input type="text" name="number" value='<?php echo $row['number'] ?>'>
		name:<br><input type="text" name="name" value='<?php echo $row['name'] ?>'><br>
		academy:<br><input type="text" name="academy" value='<?php echo $row['academy'] ?>'><br>
		academyID:<br><input type="text" name="academyID" value='<?php echo $row['academyID'] ?>'><br>
		score:<br><input type="text" name="score" value='<?php echo $row['score'] ?>'><br>
		rank:<br><input type="text" name="rank" value='<?php echo $row['rank'] ?>'><br>
		<input type="submit" name="sub" value="submit">
		<input type="reset" value="reset">
</form>
</div>
</body>
</html>