<?php
namespace app\admin\controller;
use think\Controller;
use think\Db;
use app\index\model\Athlete;
use app\index\model\UserBasic;
use app\index\controller\UserController;
class MemberController extends Controller
{
    public function athlete()
    {	
        // $athlete_list = Athlete::all();
        $athlete_list = Db::name('athlete')
                        ->order('update_time', 'desc')
                        ->select();
        //查队名
        $this->assign('athlete_list', $athlete_list);
        $this->assign('count', count($athlete_list));
        return $this->fetch();
    }
    public function referee()
    {	
        return $this->fetch('referee');
    }
    public function group()
    {	
        return $this->fetch('group');
    }
    public function fetchAdd()
    {    	
        return $this->fetch('add');
    }
    public function fetchEdit()
    { 

        $map = [
                'credit_id' =>'201706010105'
            ];
        $result = Athlete::get($map);

        $unit_name = Db::name('unit_basic')
                   ->where('unit_id',$result->group_id)
                   ->value('unit_name');
        $result->group_name = $unit_name;         
        //匹配学生信息
        if(empty($result)) {
            $result['ath_name']='查无';
            $result['group_name']='此人'; 
        }
        $this->assign('athlete', $result);     
        return $this->fetch('edit');
    }
    public function edit()
    {
       
    }

    public function addAthlete()
    {
        $athlete= new UserController;
        $athlete->signup($_POST['credit_id'],$_POST['user_tel'],$_POST['user_email']);
        
    }
    public function serachUser(){
        $map = [
                'credit_id' =>$_POST['credit_id']
            ];
        $result = UserBasic::get($map);

        $unit_name = Db::name('unit_basic')
                   ->where('unit_id',$result->unit_id)
                   ->value('unit_name');
        $result->unit_name = $unit_name;         
        //匹配学生信息
        if(empty($result)) {
            $result['real_name']='查无';
            $result['unit_name']='此人'; 
        }
        else  echo json_encode($result);  
         
    }
}
