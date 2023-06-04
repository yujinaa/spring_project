// 회원정보 수정하기
const saveBtn = document.getElementById("save-btn");

const pwd = document.getElementById('pwd');
const pwdChk = document.getElementById('pwdchk');
const name = document.getElementById('name');
const phone = document.getElementById('phone');
const email = document.getElementById('email');
saveBtn.addEventListener("click", function(e) {
	e.preventDefault();
	// ----------------- 유효성검사 정규식 -----------------
	let RegExp = /^[a-zA-Z0-9]{4,12}$/; // pwd
	let n_RegExp = /^[가-힣]{2,15}$/; //이름
	let p_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/; // 휴대폰
	let e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일


	// ----------------- pwd 유효성검사 -----------------
	if (pwd.value === "") {
		alert('비밀번호를 입력해 주세요.');
		pwd.focus();
		return false;
	}
	if (!RegExp.test(pwd.value)) {
		alert('비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력해 주세요.');
		return false;
	}

	if (pwdChk.value === "") {
		alert('비밀번호 재확인을 위해 입력해 주세요.');
		pwdChk.focus();
		return false;
	}

	if (pwd.value !== pwdChk.value) { // 비밀번호와 비밀번호 확인이 동일한지
		alert('비밀번호가 일치하지 않습니다. 다시 확인해 주세요.');
		return false;
	}

	// ----------------- name 유효성검사 -----------------
	if (name.value === "") {
		alert('이름을 입력해 주세요.');
		name.focus();
		return false;
	}
	if (!n_RegExp.test(name.value)) {
		alert('한글로만 입력해 주세요.');
		return false;
	}

	// ----------------- phone 유효성검사 -----------------
	if (phone.value === "") {
		alert('휴대폰 번호를 입력해 주세요.');
		phone.focus();
		return false;
	}
	if (!p_RegExp.test(phone.value)) {
		alert('숫자만 입력해 주세요.');
		return false;
	}

	// ----------------- email 유효성검사 -----------------
	if (email.value === "") {
		alert('이메일을 입력해 주세요.');
		email.focus();
		return false;
	}
	if (!e_RegExp.test(email.value)) {
		alert('올바른 이메일 형식이 아닙니다.');
		return false;
	}
	if (confirm("정보를 수정하시겠습니까?")) {
		alert('수정되었습니다.');
	} else {
		alert('정보를 수정할 수 없습니다.');
		return false;
	}
	modifyFoam.submit();
});
$('#pwdchk').on('input', function() {
	var chkInfo = $("#pwdchk").val();
	var checkPwd = $("#pwdchk-info");  /* 비교 결과 */
	if (pwd.value == pwdChk.value) {
		checkPwd.html("비밀번호가 일치합니다.");
		$("#pwdchk").css("border", "1.5px solid #3781E3");/*일치할 경우 테두리 색 변경*/
		$("#pwdchk-info").css("color", "#3781E3");/*일치할 경우 글자 색 변경*/
	}
});