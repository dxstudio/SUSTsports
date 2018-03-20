<?php
	$con=mysql_connect("localhost","root","dianxinstudio");
	mysql_query("set names utf8");
	if(!$con)
	{
		die("Could not access mysql:" .mysql_error());
	}
	mysql_select_db("sports",$con);

?>