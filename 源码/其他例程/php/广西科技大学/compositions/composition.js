$(document).ready(function($) {
	
	$('#Button').click(function() {
		var XueYuan = $("#selected").val();//获取学院值
		$('#loading').css('display', 'block');
		$('#record').load('compositions.php?XueYuan='+XueYuan,function(success) {
	  		Show_hint();
	  		$('#loading').css('display', 'none');
		});
	});
});

function Show_hint () {
	if ($('#record').text() == "") {
		$('#hint').css('display', 'block');
	} else{
		$('#hint').css('display', 'none');
	};
}