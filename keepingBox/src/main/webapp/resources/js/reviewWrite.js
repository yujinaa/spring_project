// 등록하기 (+글자수)
const registBtn = document.getElementById("regist-btn");
registBtn.addEventListener("click", function(e) {
    e.preventDefault();
    const content = document.getElementById("reviewContent");
    if(content.value.length < 10) {
		alert("10자 이상 입력해 주세요.");
        content.focus();
        return false;
    } else {
        if(confirm("후기를 등록하시겠습니까?")) {
            alert("후기가 등록되었습니다.");
        } else {
            content.focus();
            return false;
        } 
    }
});