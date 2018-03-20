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

	$id=$_POST['id'];
	$sql="update athlete set competition='{$competition}', sex='{$sex}',date='{$date}',time='{$time}',number='{$number}',name='{$name}',academy='{$academy}',academyID='{$academyID}',score='{$score}',rank='{$rank}',severtime='{$severtime}'where id={$id}";

	if(mysql_query($sql))
	{
		echo "<script>location='background.php'</script>";
	}
	else
	{
		echo "<script>location='edit.php?id={$row['id']}'</script>";
	}
	$sql1="select sum(score) AS total,academyID from athletescore group by academyID";
	$rst=mysql_query($sql1);

	while($row=mysql_fetch_assoc($rst)){
	$sql2="update academy set score={$row['total']} where academyID={$row['academyID']}";
	mysql_query($sql2);}
?>