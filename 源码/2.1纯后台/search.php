<?php
	include "config.php";
	
	$com = $_POST['date'];
	
	if($com == '第一天早上'){
	    $sql_1="select * from athlete where dateid = 1 and project = 铅球 and sex = 男";
	    $rst_1=mysql_query($sql_1);
		$sql_2="select * from athlete where dateid = 1 and project = 跳远 and sex = 女";
	    $rst_2=mysql_query($sql_2);
		$sql_3="select * from athlete where dateid = 1 and project = 接力投篮";
	    $rst_3=mysql_query($sql_3);
		$sql_4="select * from athlete where dateid = 1 and project = 三人踏板竞速 and sex = 男";
	    $rst_4=mysql_query($sql_4);
		$sql_5="select * from athlete where dateid = 1 and project = 三人踏板竞速 and sex = 女";
	    $rst_5=mysql_query($sql_5);
		$sql_6="select * from athlete where dateid = 1 and project = 4X100米 and sex = 男";
	    $rst_6=mysql_query($sql_6);
		$sql_7="select * from athlete where dateid = 1 and project = 4X100米 and sex = 女";
	    $rst_7=mysql_query($sql_7);
		$sql_8="select * from athlete where dateid = 1 and project = 1500米 and sex = 男";
	    $rst_8=mysql_query($sql_8);
		$sql_9="select * from athlete where dateid = 1 and project = 1500米 and sex = 女";
	    $rst_9=mysql_query($sql_9);
		$sql_10="select * from athlete where dateid = 1 and project = 100米 and sex = 男";
	    $rst_10=mysql_query($sql_10);
		$sql_11="select * from athlete where dateid = 1 and project = 100米 and sex = 女";
	    $rst_11=mysql_query($sql_11);
	}elseif($com == '第一天下午'){
		$sql_1="select * from athlete where dateid = 2 and project = 110米栏 and sex = 男";
	    $rst_1=mysql_query($sql_1);
		$sql_2="select * from athlete where dateid = 2 and project = 400米 and sex = 女";
	    $rst_2=mysql_query($sql_2);
		$sql_3="select * from athlete where dateid = 2 and project = 400米 and sex = 男";
	    $rst_3=mysql_query($sql_3);
		$sql_4="select * from athlete where dateid = 2 and project = 4X100米 and sex = 男";
	    $rst_4=mysql_query($sql_4);
		$sql_5="select * from athlete where dateid = 2 and project = 4X100米 and sex = 女";
	    $rst_5=mysql_query($sql_5);
		$sql_6="select * from athlete where dateid = 2 and project = 障碍接力";
	    $rst_6=mysql_query($sql_6);
		$sql_7="select * from athlete where dateid = 2 and project = 引体向上";
	    $rst_7=mysql_query($sql_7);
		$sql_8="select * from athlete where dateid = 2 and project = 跳远 and sex = 男";
	    $rst_8=mysql_query($sql_8);
		$sql_9="select * from athlete where dateid = 2 and project = 铅球 and sex = 女";
	    $rst_9=mysql_query($sql_9);
		$sql_10="select * from athlete where dateid = 2 and project = 跳高 and sex = 女";
	    $rst_10=mysql_query($sql_10);
		$sql_11="select * from athlete where dateid = 2 and project = 标枪 and sex = 男";
	    $rst_11=mysql_query($sql_11);
	}elseif($com == '第二天早上'){
		$sql_1="select * from athlete where dateid = 3 and project = 滚铁环";
	    $rst_1=mysql_query($sql_1);
		$sql_2="select * from athlete where dateid = 3 and project = 200米 and sex = 女";
	    $rst_2=mysql_query($sql_2);
		$sql_3="select * from athlete where dateid = 3 and project = 200米 and sex = 男";
	    $rst_3=mysql_query($sql_3);
		$sql_4="select * from athlete where dateid = 3 and project = 800米 and sex = 男";
	    $rst_4=mysql_query($sql_4);
		$sql_5="select * from athlete where dateid = 3 and project = 800米 and sex = 女";
	    $rst_5=mysql_query($sql_5);
		$sql_6="select * from athlete where dateid = 3 and project = 仰卧起坐";
	    $rst_6=mysql_query($sql_6);
		$sql_7="select * from athlete where dateid = 3 and project = 立定跳远";
	    $rst_7=mysql_query($sql_7);
		$sql_8="select * from athlete where dateid = 3 and project = 七人龙卷风";
	    $rst_8=mysql_query($sql_8);
		$sql_9="select * from athlete where dateid = 3 and project = 三级跳远 and sex = 男";
	    $rst_9=mysql_query($sql_9);
		$sql_10="select * from athlete where dateid = 3 and project = 跳高 and sex = 男";
	    $rst_10=mysql_query($sql_10);
		$sql_11="select * from athlete where dateid = 3 and project = 标枪 and sex = 女";
	    $rst_11=mysql_query($sql_11);
	}elseif($com == '第二天下午'){
		$sql_1="select * from athlete where dateid = 4 and project = 3000米";
	    $rst_1=mysql_query($sql_1);
		$sql_2="select * from athlete where dateid = 4 and project = 5000米 and sex = 男";
	    $rst_2=mysql_query($sql_2);
		$sql_3="select * from athlete where dateid = 4 and project = 十人十一足";
	    $rst_3=mysql_query($sql_3);
		$sql_4="select * from athlete where dateid = 4 and project = 三级跳远 and sex = 女";
	    $rst_4=mysql_query($sql_4);
	}
	
	

	
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>sports index</title>
	<style type="text/css">
		td{
			text-align: center;
		}
	</style>
</head>
<body>
<center>
	<br>
	
	<h2>recent score</h2>
	<table width="500px" border="1" cellspacing="0">
		<tr>
			<th>id</th>
			<th>ath_id</th>
			<th>name</th>
			<th>academy</th>
			<th>competition</th>
			<th>score</th>
			<th>rank</th>
			<th>time</th>
		</tr>
		<?php
 if($com == '第一天早上' || $com == '第一天下午'||$com == '第二天早上'){ //第一天和第二天早上
	while($row=mysql_fetch_assoc($rst_1)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>" ;
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_2)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_3)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_4)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_5)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_6)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_7)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_8)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_9)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_10)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	
	while($row=mysql_fetch_assoc($rst_11)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	}else{                                      //第二天下午
	while($row=mysql_fetch_assoc($rst_1)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	while($row=mysql_fetch_assoc($rst_2)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	while($row=mysql_fetch_assoc($rst_3)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	while($row=mysql_fetch_assoc($rst_4)){
				echo "<tr>";
				echo "<th align=center>{$row['competition']}</th>";
				echo "</tr>";
		        echo "<tr>"
				echo "<td>{$row['id']}</td>";
			    echo "<td>{$row['ath_id']}</td>";
			    echo "<td>{$row['name']}</td>";
				echo "<td>{$row['academy']}</td>";
				echo "<td>{$row['score']}</td>";
				echo "<td>{$row['rank']}</td>";
				echo "<td>{$row['time']}</td>";
		        echo "</tr>";
	}
		        
		?>
	</table>
	<a href="sum.php">sum</a>
	<a href="background.php">login</a>
</center>
</body>
</html>