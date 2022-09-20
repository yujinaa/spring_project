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

//db로부터 댓글 가져오기

function replyData(){
    $.ajax({
       url : "replyData/" + ${detailWriteData.writeNum}, 
	   type : "GET", 
       dataType : "json",
       success : function(reply){
          let html = ""
          reply.forEach(function(data){
             let date = new Date(data.replyDate)
             let replyDate = date.getFullYear()+"년"+(date.getMonth()+1)+"월"
             replyDate += date.getDate()+"일"+date.getHours()+"시"
             replyDate += date.getMinutes()+"분"+date.getSeconds()+"초"
             html += "<div align='left'><b>작성자 : </b>"+data.replyer+"님 / "
             html += "<b>작성일</b> : "+replyDate+"<br>"
             html += "<b>제목</b> : "+data.title+"<br>"
             html += "<b>내용</b> : "+data.replyContent+"<hr></div>"
          })
          $("#replyGet").html(html);
       },
		error : function(){
          alert('댓글을 가져올 수 없습니다');
       }
    }) 
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
			alert("댓글이 등록되었습니다.");
			slide_hide();
			replyData();
		},
		error : function() {
			alert("댓글을 등록할 수 없습니다.");
		}
		})
}
 