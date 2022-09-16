/**
 * 
 */
function slideClick() {
	$("#first").slideDown('slow');
	$("#modal_wrap").show();
}
function slide_hide() {
	$("#first").slideUp('fast');
	$("#modal_wrap").hide();
}
function reply() {
	let form = {};
	let arr = $("#frm").serializeArray()
	for (i = 0; i < arr.length; i++) {
		form[arr[i].name] = arr[i].value;
	}
	}
	$.ajax({
		url : "addReply",
		type : "POST",
		dataType : "json",
		data : JSON.stringify(form),
		contentType : "application/json;charset=utf-8",
		success : function(list) {
			alert("댓글이 등록되었습니다.");
			slide_hide();
		},
		error : function() {
			alert("댓글이 등록할 수 없습니다.");
		}
		});
