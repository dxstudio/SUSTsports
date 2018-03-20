
<!DOCTYPE html>
<html>
<head>
	<title>add</title>
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

<h3>Add score</h3>
<div>
<form action="checkAdd.php" method="post">
		<b>please input:</b><br>
		competition:<br><input type="text" name="competition"><br>
		sex:<br><input type="text" name="sex"><br>
		date:<br><input type="text" name="date"><br>
		time:<br><input type="text" name="time"><br>
		number:<input type="text" name="number">
		name:<br><input type="text" name="name"><br>
		academy:<br><input type="text" name="academy"><br>
		academyID:<br><input type="text" name="academyID"><br>
		
		score:<br><input type="text" name="score"><br>
		rank:<br><input type="text" name="rank"><br>
		
		<input type="submit" name="sub" value="add">
		<input type="reset" value="reset"><br>
		<a href="background.php">return background</a>
</form>
</div>
</body>
</html>