$(document).ready(function($) {
	Reload ();
	$('#Button').click(function() {
		var XueYuan = $("#selected").val();//获取学院
		var XiangMu = $("#selected2").val();//获取项目
		var MingCi = $("#selected3").val();//获取名次
		var DeFen = $("#num2").val();//获取得分
		var Name = $("#name").val();//获取姓名
		var PassWord = $("#password").val();//获取密码
		//alert(XueYuan+FenShu+XiangMu+MingCi+DeFen);
		if (DeFen == "" || Name == "") {
			alert("请输入得分和姓名！");
		}
		else{
			$('#rank').load('back.php?XueYuan='+XueYuan+'&XiangMu='+XiangMu+'&MingCi='+MingCi+'&DeFen='+DeFen+'&Name='+Name+'&PassWord='+PassWord);
		};
		
	});
	//删除功能
	$('#Button_2').click(function() {
		var XueYuan = $("#selected").val();//获取学院
		var XiangMu = $("#selected2").val();//获取项目
		var MingCi = $("#selected3").val();//获取名次
		var DeFen = $("#num2").val();//获取得分
		var Name = $("#name").val();//获取姓名
		var PassWord = $("#password").val();//获取密码
		if (DeFen == "" || Name == "") {
			alert("请输入得分和姓名！");
		}
		else{
			$('#rank').load('delete.php?XueYuan='+XueYuan+'&XiangMu='+XiangMu+'&MingCi='+MingCi+'&DeFen='+DeFen+'&Name='+Name+'&PassWord='+PassWord);
		};
	});
	$('#Button_3').click(function() {
		var record_Bre = $('#record_Bre').val();
		$.post('../record_breaking/record_breaking.php', {mode: '1',info: record_Bre}, function(success) {
			alert("添加成功！");
		});
	});
	$('#Button_4').click(function() {
		$.post('../record_breaking/record_breaking.php', {mode: '3',info: '0'}, function(success) {
			alert("删除成功！");
		});
		
	});

});
function Reload () {
	$('#rank').load('../rank_view.php');
}

