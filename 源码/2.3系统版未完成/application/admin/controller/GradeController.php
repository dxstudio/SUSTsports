<?php
namespace app\admin\controller;
use think\Controller;
class GradeController extends Controller
{
    public function grade()
    {	
        return $this->fetch('grade');
    }
    public function point()
    {	
        return $this->fetch('point');
    }
}
