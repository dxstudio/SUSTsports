<?php
namespace app\index\controller;
use think\Controller;
use think\Db;
use app\index\model\UserBasic;
use app\index\model\Athlete;
class UserController extends Controller
{
    public function index()
    {
        return $this->fetch('ath_step2');
    }
	/**
	 *@param ，
	 *@version 17点07分
	 *
	 */
    public function login()
    {
        //登录后判断是否已注册联系信息
    }
    public function signup($credit_id='',$tel='',$email='')
    {	
        //参数
        // $map1 = [
        //     'credit_id' =>'201706010116'
        // ];

        $loginUser = UserBasic::get(['credit_id'=>$credit_id]);
        //判断当前应用状态进程
        if('1'==$_POST['match_status']){
            $is_join = $_POST['is_join'];
            $loginUser->user_email = $_POST['email'];
            $loginUser->user_tel = $_POST['tel'];
        }
        else{
            $is_join = 1;
            $loginUser->user_email = $email;
            $loginUser->user_tel = $tel;
            
        }
        $loginUser->sign_time = date("Y-m-d H:i:s",time());
        $loginUser->save();

        if(empty($is_join)){
            //观众

        }
        else
        {   
            //由于教职工需要区分年龄，故分别处理
            if("大学生"==$loginUser->user_type){
                //获取相同组别下相同性别的运动员号当前最大值
                $max_ath_id = Db::name('athlete')
                    ->where('group_id', $loginUser->unit_id)
                    ->where('ath_sex', $loginUser->user_sex)
                    ->max('ath_id');
            }
            
            
            else{
                //获取相同组别下相同性别相同年龄段的运动员号当前最大值
                $max_ath_id = Db::name('athlete')
                    ->where('group_id', $loginUser->unit_id)
                    ->where('ath_sex', $loginUser->user_sex)
                    ->where('ath_type', $loginUser->user_type."组")
                    ->max('ath_id');
                
            } 
            
            switch ($loginUser->user_type) {
                case '青年教工':
                    $start_id = '00';
                    break;
                case '中年教工':
                    $start_id = '20';
                    break;
                case '老年教工':
                    $start_id = '40';
                    break;    
                default:
                    $start_id = '00';
                    break;
            }
            //根据性别设置起始id
            $start_id =('男'==$loginUser->user_sex) ? $start_id:$start_id+50;
            $ath_id = empty($max_ath_id) ? ($loginUser->unit_id.$start_id):sprintf("%04d", $max_ath_id+1); 

            //新增运动员
            $athlete = new Athlete;
            $athlete->ath_id = $ath_id;
            $athlete->ath_type = $loginUser->user_type."组";
            $athlete->credit_id = $loginUser->credit_id;
            $athlete->group_id = $loginUser->unit_id;
            $athlete->ath_name = $loginUser->real_name;
            $athlete->ath_sex = $loginUser->user_sex;
            $athlete->update_time = date("Y-m-d H:i:s",time());
           
            //异常处理
            if ($athlete->save()) {
                // return $athlete->ath_type . $athlete->ath_name . ':' . $athlete->ath_id . '新增成功';
                return $this->fetch('stu_step2');
            } else {
                return $athlete->getError();
            }
            
        }
        //return $this->fetch('stu_step2');
    }
}
