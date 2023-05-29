
	/*

$(".submitBtn").on("click", function(e) {
	e.preventDefault();

	let type = $(".search select").val();
	let keyword = $(".search input[name='keyword']").val();

	if (!type) {
		alert("검색 유형을 선택하세요.");
		return false;
	}

	if (!keyword) {
		alert("키워드를 입력하세요.");
		return false;
	}
	location.href = "review?num=1" + "&type=" + type + "&keyword=" + keyword;
	searchFoam.find($('select[name="size"]')).val(type);
	search.find("input[name='type']").val(type);
	search.find("input[name='keyword']").val(keyword);
	searchFoam.submit();

	console.log(type);
	console.log(keyword);
});
	 */


/*
$(".submitBtn").on("click", function(e) {
	$.ajax({
		type: 'GET',
		url: "review",
		data: $("form[name=search-form]").serialize(),
		success: function(result) {
			//테이블 초기화
			$('#boardtable > tbody').empty();
			if (result.length >= 1) {
				result.forEach(function(item) {
					str = '<tr>'
					str += "<td>" + item.idx + "</td>";
					str += "<td>" + item.writer + "</td>";
					str += "<td><a href = '/board/detail?idx=" + item.idx + "'>" + item.title + "</a></td>";
					str += "<td>" + item.date + "</td>";
					str += "<td>" + item.hit + "</td>";
					str += "</tr>"
					$('#boardtable').append(str);
				})
			}
		}
	})
}

 */