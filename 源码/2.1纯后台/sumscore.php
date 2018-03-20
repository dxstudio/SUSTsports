<?php
include "config.php";


$sql="select sum(score) AS total,academyID from athletescore group by academyID";
$rst=mysql_query($sql);

while($row=mysql_fetch_assoc($rst)){
$sql="update academy set score={$row['total']} where academyID={$row['academyID']}";
mysql_query($sql);
}
