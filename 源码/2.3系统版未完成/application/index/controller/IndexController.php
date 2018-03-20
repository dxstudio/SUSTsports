<?php
namespace app\index\controller;
use think\Controller;
class IndexController extends Controller
{
    public function index()
    {	
        return $this->fetch('index');
    }
    public function project_list()
    {	
        return $this->fetch();
    }
    public function match_list()
    {	
        return $this->fetch();
    }
    public function time_list()
    {	
        return $this->fetch();
    }
}
