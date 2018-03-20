<?php
	header('content-type:text/html;charset=utf-8');
	include "config.php";
	$administrator=$_POST['administrator'];
	$password=$_POST['password'];
	$sql="select * from administrator where administrator='{$administrator}' and password='{$password}'";
	$rst=mysql_query($sql);
	$row=mysql_fetch_assoc($rst);

	if($row)
	{	
		setcookie('administrator',$administrator,time()+600,'/');
		setcookie('userid',$row['id'],time()+600,'/');
		echo "<script>location='background.php'</script>";
	}
	else{
		echo "<script>alert('login failed');location='backgroundLogin.php'</script>";
	}
?>