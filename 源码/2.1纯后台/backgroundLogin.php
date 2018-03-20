
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>background login</title>
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
<h3>Administrator login</h3>
<div>
	<form action="checkLogin.php" method="post">
		name:<input type="text" name="administrator"><br>
		password:<input type="password" name="password"><br>
		<input type="submit"  value="login">
		<input type="reset" value="reset">
	</form>
</div>
</body>
</html>