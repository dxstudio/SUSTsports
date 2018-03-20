<?php
	header('content-type=text/html;charset=utf-8');
	include "config.php";
	$id=$_GET['id'];
//抓取破纪录运动员的信息并记录到record_break中
	$sql="select * from athletescore where id={$id} ";
	$rst=mysql_query($sql);
	$row=mysql_fetch_assoc($rst);

	$competition=$row['competition'];
	$sex=$row['sex'];
	$number=$row['number'];
	$name=$row['name'];
	$academy=$row['academy'];
	$score=$row['score'];

	$sql="insert into record_break (name,sex,number,academy,competition,score) values('{$name}', '{$sex}', '{$number}', '{$academy}', '{$competition}', '{$score}' )";
	mysql_query($sql);
//抓取记录中的信息
	$sql="select record from record where competition='{$competition}'";
	$rst=mysql_query($sql);
	$row=mysql_fetch_assoc($rst);

	$record=$row['record'];

	$sql="update record_break set record='{$record}' ";
	mysql_query($sql);
	mysql_close($con);






?>