<?php 
	error_reporting(0); //关闭错误提示
	//$FenShu = test_input($_GET["FenShu"]);
	$XueYuan = test_input($_GET["XueYuan"]);
	$XiangMu = test_input($_GET["XiangMu"]);
	$MingCi = test_input($_GET["MingCi"]);
	$DeFen = test_input($_GET["DeFen"]);
	$Name = $_GET["Name"];
	$PassWord = test_input($_GET["PassWord"]);
	$file_name = $XueYuan;
	$num=1;
	//echo "$FenShu,$XueYuan,$XiangMu,$MingCi,$DeFen";
	//echo "$PassWord";
	if (strcmp($PassWord,"12345678") == 0) {
		$rank = fopen("../rank/rank.txt","r+");
		
		//分数组成记录
		$file_name=iconv("utf-8","gb2312",$file_name);
		$record = fopen("../rank/{$file_name}.txt", "a+");
		fprintf($record, "%s %s %s %f\n",$Name,$XiangMu,$MingCi,$DeFen);
		fclose($record);

		//获奖记录
		$history = fopen("../rank/history.txt", "a+");
		fprintf($history, "%s %s %s %s %f\n",$XueYuan,$Name,$XiangMu,$MingCi,$DeFen);
		fclose($history);

		if ($rank == FALSE) {
			echo "数据读取失败，请刷新页面！";
		}
		else{
			//echo "成功";
			while(!feof($rank)){
				list($school, $point) = fscanf($rank, "%s %f");
				if ($point != "") {
					$arr["$school"] = "$point";
				}
			}
			$arr["$XueYuan"] += $DeFen;
			arsort($arr);
			//var_dump($arr);
			fclose($rank);
			
			//print_r(each($arr));
			
			$rank = fopen("../rank/rank.txt","w+");
			while(list($key, $val) = each($arr)){		
				fprintf($rank, "%s %f\n",$key,$val);
				print_r('<p class="detail">第'.$num.'名&nbsp;&nbsp;'.$key."&nbsp;&nbsp;&nbsp;&nbsp;".$val."分</p>");
				$num++;
				//$arr["$school"] = "$point";
			}

		}
		fclose($rank);
		echo '<p class="detail" style="color:blue;">添加成功!</p>';
	}
	else{
		echo '<p class="detail" style="color:red;">管理密码错误!</p>';
	}
function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
 ?>