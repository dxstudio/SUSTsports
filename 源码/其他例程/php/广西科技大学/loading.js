$(document).ready(function($) {
	$('#rank').load('rank_view.php',function(success) {
  		Show_hint();
  		$('#loading').css('display', 'none');
});

	$('#history').load('history/history.php',function(success) {
		Show_hint_2();
  		$('#loading_2').css('display', 'none');
	});

	$.post('record_breaking/record_breaking.php', {mode: '2',info: '0'}, function(result) {
		$('#record_breaking').html(result);
	});

	$('#Button').click(function() {
		$('#loading').css('display', 'block');
		$('#rank').load('rank_view.php',function(success) {
	  		Show_hint();
	  		$('#loading').css('display', 'none');
		});

		$('#loading_2').css('display', 'block');
		$('#history').load('history/history.php',function(success) {
			Show_hint_2();
	  		$('#loading_2').css('display', 'none');
		});

	});

	

});

function Show_hint () {
	if ($('#rank').text() == "") {
		$('#hint').css('display', 'block');
	} else{
		$('#hint').css('display', 'none');
	};
}

function Show_hint_2 () {
	if ($('#history').text() == "") {
		$('#hint_2').css('display', 'block');
	} else{
		$('#hint_2').css('display', 'none');
	};
}	