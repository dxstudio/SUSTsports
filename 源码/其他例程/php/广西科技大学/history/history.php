<?php 
	error_reporting(0); //关闭错误提示
	$history = fopen("../rank/history.txt","r");
	$num = 0;
	if ($history == FALSE) {
		echo "数据读取失败，请刷新页面！";
	}
	else{
		while(!feof($history)){
			list($XueYuan[$num],$Name[$num],$XiangMu[$num],$MingCi[$num],$DeFen[$num]) = fscanf($history, "%s %s %s %s %f");
			$num++;
			
		}
		for ($i=$num-1; $i >= 0; $i--) { 
			if ($i > $num-22) {		
				if ($DeFen[$i] != "" || $DeFen[$i] != 0) { //分数为0 则不显示，表示删除
					print_r('<p class="detail">恭喜'.$XueYuan[$i].'<b style="font-weight: normal;color:#007EFF;">'.$Name[$i].'</b>同学，在'.$XiangMu[$i].'比赛中取得<b>'.$MingCi[$i].'</b>的好成绩，为自己学院夺得<b style="font-weight: normal;color:#F15757;">'.$DeFen[$i].'</b>分。</p>');
				}
			}
		}

	}
fclose($history);
 ?>