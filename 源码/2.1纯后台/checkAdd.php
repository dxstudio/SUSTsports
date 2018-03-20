<?php
header('content-type=text/html;charset=utf-8');
include "config.php";
	$competition=$_POST['competition'];
	$sex=$_POST['sex'];
	$date=$_POST['date'];
	$time=$_POST['time'];
	$number=$_POST['number'];
	$name=$_POST['name'];
	$academy=$_POST['academy'];
	$academyID=$_POST['academyID'];
	$score=$_POST['score'];
	$rank=$_POST['rank'];
	$severtime=time();

	$sql="insert into athlete(competition,sex,date,time,number,name,academy,academyID,score,rank,severtime) values({$competition},'{$sex}','{$date}','{$time}',{$number},{$name},{$academy},{$academyID},{$score},{$rank},{$severtime})";
	
	if(mysql_query($sql))
	{
		echo "<script>alert('add success');location='background.php'</script>";
	}
	else
	{
		echo "<script>alert('add failed');location='add.php'</script>";
	}

	$sql1="select sum(score) AS total,academyID from athletescore group by academyID";
	$rst=mysql_query($sql1);

	while($row=mysql_fetch_assoc($rst)){
	$sql2="update academy set score={$row['total']} where academyID={$row['academyID']}";
	mysql_query($sql2);}
?>