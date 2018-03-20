<?php 
	//error_reporting(0); //关闭错误提示
	$XueYuan = test_input($_GET["XueYuan"]);
	$XiangMu = test_input($_GET["XiangMu"]);
	$MingCi = test_input($_GET["MingCi"]);
	$DeFen = test_input($_GET["DeFen"]);
	$Name = $_GET["Name"];
	$PassWord = test_input($_GET["PassWord"]);
	$file_name = $XueYuan;
	$num = 0;
	$num_history = 0;

	if (strcmp($PassWord,"yiban2015") == 0) {
		$file_name=iconv("utf-8","gb2312",$file_name);
		$record = fopen("../rank/{$file_name}.txt", "r+");
		$history = fopen("../rank/history.txt", "r");

		//读取排行榜
		$rank = fopen("../rank/rank.txt","r+");
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
		fclose($rank);


		//读取分数组成文件数据到数组
		while(!feof($record)){
				list($Name_file[$num],$XiangMu_file[$num],$MingCi_file[$num],$DeFen_file[$num]) = fscanf($record, "%s %s %s %f");
				$num++;
			}
		fclose($record);

		//读取获奖记录文件数据到数组
		while(!feof($history)){
				list($XueYuan_history[$num_history],$Name_history[$num_history],$XiangMu_history[$num_history],$MingCi_history[$num_history],$DeFen_history[$num_history]) = fscanf($history, "%s %s %s %s %f");
				$num_history++;
			}
		fclose($history);
		
		//从数组写入数据到分数组成文件，总分数减去需要删除的项目的分数
		$record = fopen("../rank/{$file_name}.txt", "w+");
		if ($record != FALSE) {		
			for ($i = 0; $i < $num; $i++) { 
				if ($DeFen != "" && $DeFen_file[$i] != "" && $Name_file[$i] != "0") {
					if (strcmp($Name, $Name_file[$i]) == 0 && strcmp($XiangMu, $XiangMu_file[$i]) == 0 && strcmp($MingCi, $MingCi_file[$i]) == 0 && strcmp($DeFen, $DeFen_file[$i]) == 0) {
							$arr["$XueYuan"] -= $DeFen; //排行榜分数减
							arsort($arr);
							echo '<p class="detail">删除成功!</p>';
					}
					else{
						fprintf($record, "%s %s %s %f\n",$Name_file[$i],$XiangMu_file[$i],$MingCi_file[$i],$DeFen_file[$i]);
					}
				}
			}
		}
		fclose($record);

		//从数组写入数据到获奖记录文件
		$history = fopen("../rank/history.txt", "w+");
		if ($history != FALSE) {		
			for ($i = 0; $i < $num_history; $i++) { 
				if ($DeFen != "" && $DeFen_history[$i] != "" && $Name_history[$i] != "0") {
					if (strcmp($Name, $Name_history[$i]) == 0 && strcmp($XiangMu, $XiangMu_history[$i]) == 0 && strcmp($MingCi, $MingCi_history[$i]) == 0 && strcmp($DeFen, $DeFen_history[$i]) == 0) {

					}
					else{
						fprintf($history, "%s %s %s %s %f\n",$XueYuan_history[$i],$Name_history[$i],$XiangMu_history[$i],$MingCi_history[$i],$DeFen_history[$i]);
					}
				}
			}
		}
		fclose($history);

		//写入文件并输出排行榜
		$num_2 = 1;
		$rank = fopen("../rank/rank.txt","w+");
			while(list($key, $val) = each($arr)){		
				fprintf($rank, "%s %f\n",$key,$val);
				print_r('<p class="detail">第'.$num_2.'名&nbsp;&nbsp;'.$key."&nbsp;&nbsp;&nbsp;&nbsp;".$val."分</p>");
				$num_2++;
				//$arr["$school"] = "$point";
			}

		}
		fclose($rank);
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