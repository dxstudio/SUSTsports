<?php  //传入参数为1时，执行追加写入操作；入参数为2时，执行读取输出操作; 3时，清空文件.
	$mode = $_POST["mode"];
	$info = $_POST["info"];
	$num = 0;
	switch ($mode) {
		case '1':	
			$record_breaking = fopen("../rank/record_breaking.txt", "a+");
			fprintf($record_breaking, "%s\n",$info);
			fclose($record_breaking);
			break;
		case '2':
			$record_breaking = fopen("../rank/record_breaking.txt", "r+");
			while(!feof($record_breaking)){
				$info = fscanf($record_breaking, "%s");
				if ($info[$num] != "") { //分数为0 则不显示，表示删除
					print_r('<p class="record_breaking_p">'.$info[$num].'</p>');
					//$num++;
				}
			}
			fclose($record_breaking);
			break;
		case '3':
			$record_breaking = fopen("../rank/record_breaking.txt", "w+");
			fclose($record_breaking);
			break;
		default:
			echo "（破纪录）操作失败";
			break;
	}
 ?>