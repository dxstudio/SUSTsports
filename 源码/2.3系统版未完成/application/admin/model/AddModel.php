<?php
namespace app\admin\model;
use think\Model;
class AddModel extends Model
{
    public function athlete()
    {	
        return $this->fetch('athlete');
    }
}
