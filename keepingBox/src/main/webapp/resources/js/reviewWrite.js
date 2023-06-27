// 등록하기 (+글자수)
const content = document.getElementById("reviewContent");
const title = document.getElementById("title");
$("#regist-btn").on("click", function() {
	if (title.value == '') {
		alert("제목을 입력해 주세요.");
		title.focus();
		return false;
	} else if (content.value.length < 10) {
		alert("10자 이상 입력해 주세요.");
		content.focus();
		return false;
	} else {
		if (confirm("글을 등록하시겠습니까?")) {
			alert('새로운 글이 등록되었습니다.');
		} else {
			alert("글이 등록되지 않았습니다.");
			return false;
		}
	}
});