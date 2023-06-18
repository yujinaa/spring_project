let path = "${pageContext.request.contextPath }";
const deleteBtn = document.getElementById("delete_btn");
deleteBtn.addEventListener("click", (e) => {
	e.preventDefault();
	if (confirm("작성된 글을 삭제하시겠습니까?")) {
		alert("성공적으로 삭제되었습니다.");
	} else {
		alert("삭제되지 않았습니다.");
		return false;
	}
});

