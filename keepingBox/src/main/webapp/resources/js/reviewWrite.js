// 등록하기 (+글자수)

//const registBtn = document.getElementById("regist-btn");
//registBtn.addEventListener("click", function(e) {
  //  e.preventDefault();
  //  const content = document.getElementById("reviewContent");
//    if(content.value.length < 10) {
		//alert("10자 이상 입력해 주세요.");
       // content.focus();
     //   return false;
   //} else {
    //    if(confirm("후기를 등록하시겠습니까?")) {
  //          alert("후기가 등록되었습니다.");
//return true;
    //    } 
  //  }

//});

//$("#regist-btn").on("click", function(e) {
		//	if ("#regist-btn".value === '') {
		//		alert("내용을 입력해 주세요.");
		//		return false;
		//	} else {
		//		alert('새로운 글이 등록되었습니다.');
		//	}
	//	});
	const content = document.getElementById("reviewContent");
	$("#regist-btn").on("click", function() {
    if(content.value.length < 10) {
        alert("10자 이상 입력해 주세요.");
        content.focus();
        return false;
    }else{
	alert('새로운 글이 등록되었습니다.');
}
});