<?php 
	error_reporting(0);
	$num = 1;
	$rank = fopen("rank/rank.txt","r");
	if ($rank == FALSE) {
		echo "数据读取失败，请刷新页面！";
	}
	else{
		//echo "成功";
		//$arr = array();
		while(!feof($rank)){
			list($school, $point) = fscanf($rank, "%s %f");
			//$arr[] = ["$school" => "$point"];
			if ($point != "" || $point != 0) { //分数为0 则不显示，表示删除
				//print_r('<p class="detail">第'.$num.'名&nbsp;&nbsp;'.$school."&nbsp;&nbsp;&nbsp;&nbsp;".$point."分</p>");
				if ($num == 1) {
					echo <<<END
					<div class="num1">
						<img src="image/num1.png" alt="第一名"/>
						<span>{$school}</span>
						<br/>
						<span>{$point}分</span>
					</div>
END;
				
				}
				if ($num == 2) {
					echo <<<END
					<div class="num2">
						<img src="image/num2.png" alt="第二名"/>
						<span>{$school}</span>
						<br/>
						<span>{$point}分</span>
					</div>
END;
				
				}
				if ($num == 3) {
					echo <<<END
					<div class="num3">
						<img src="image/num3.png" alt="第三名"/>
						<span>{$school}</span>
						<br/>
						<span>{$point}分</span>
					</div>
END;
				
				}
				if($num > 3){
					echo <<<END
					<div class="detail_num">
						<table>
							<tr>
							<td class="td_0">第{$num}名</td>
							<td class="td_xueyuan">{$school}</td>
							<td class="td_0">{$point}分</td>
							</tr>
						</table>
					</div>
END;
					
				}
				$num++;
			}
			
		}
		//asort($arr);
		//var_dump($arr);
	}
	fclose($rank);
 ?>