<?php
namespace app\admin\controller;
use think\Controller;
class SystemController extends Controller
{
    public function index()
    {	
        return $this->fetch();
    }
}
