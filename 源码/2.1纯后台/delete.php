<?php
	header('content-type=text/html;charset=utf-8');
	include "config.php";
	$id=$_GET['id'];
	$sql="delete from athletescore where id={$id}";
	mysql_query($sql);

	echo "<script>location='background.php'</script>";

?>
