

$(".submitBtn").on("click", function(e) {
	e.preventDefault();

	let type = $(".search select").val();
	let keyword = $(".search input[name='keyword']").val();

	if (!type) {
		alert("검색 유형을 선택하세요.");
		return false;
	}

	if (!keyword) {
		alert("검색어를 입력하세요.");
		return false;
	}
	searchFoam.submit();
});






