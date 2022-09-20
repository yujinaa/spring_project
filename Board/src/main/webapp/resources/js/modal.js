function slideClick() {
	$("#first").slideDown('slow');
	$("#modal_wrap").show();
}
function slide_hide() {
	$("#first").slideUp('fast');
	$("#modal_wrap").hide();
}


function reply() {
	let replyList = {}
	let arr = $("#frm").serializeArray()
	console.log(arr)
	for (i = 0; i < arr.length; i++) {
		replyList[arr[i].name] = arr[i].value;
	}
	$.ajax({
		url : "addReply",
		type : "POST",
		dataType : "json",
		data : JSON.stringify(replyList),
		contentType : "application/json; charset=utf-8",
		success : function(list) {
			$("#title").val("")
			$("#replyContent").val("")
			alert("댓글이 등록되었습니다.");
			slide_hide();
			replyData();
		},
		error : function() {
			alert("댓글을 등록할 수 없습니다.");
		}
		})
}
 