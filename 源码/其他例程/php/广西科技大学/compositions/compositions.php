<?php 
	$XueYuan = test_input($_GET["XueYuan"]);
	//echo "$XueYuan";
	$XueYuan =iconv("utf-8","gb2312",$XueYuan);
	$compositions = fopen("../rank/{$XueYuan}.txt","r");
	if ($compositions == FALSE) {
		echo "获取信息失败，请刷新网页再试一次";
	}
	else{
		while(!feof($compositions)){
			list($Name, $XiangMu, $MingCi, $point) = fscanf($compositions, "%s %s %s %f");
			//$arr[] = ["$school" => "$point"];
			if ($point != "" || $point != 0) { //分数为0 则不显示，表示删除
				print_r('<p class="detail">'.$Name."&nbsp;&nbsp;&nbsp;&nbsp;".$XiangMu."&nbsp;&nbsp;&nbsp;&nbsp;".$MingCi."&nbsp;&nbsp;&nbsp;&nbsp;".$point."分</p>");
			}
			
		}
	}
	fclose($compositions);
	function test_input($data) {
	  $data = trim($data);
	  $data = stripslashes($data);
	  $data = htmlspecialchars($data);
	  return $data;
	}
 ?>