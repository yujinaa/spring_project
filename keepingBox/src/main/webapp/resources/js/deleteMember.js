const withdrawalBtn = document.getElementById("withdrawal-btn");

const pwd = document.getElementById('delete-pwd');
const pwdChk = document.getElementById('delete-pwd-check');
withdrawalBtn.addEventListener("click", (e) => {
	e.preventDefault();
	let RegExp = /^[a-zA-Z0-9]{4,12}$/;


	if (pwd.value === "") {
		alert('비밀번호를 입력해 주세요.');
		pwd.focus();
		return false;
	}
	if (!RegExp.test(pwd.value)) {
		alert('비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력해 주세요.');
		pwd.focus();
		return false;
	}
	if (pwdChk.value === "") {
		alert('비밀번호를 입력해 주세요.');
		pwdChk.focus();
		return false;
	}

	if (pwd.value !== pwdChk.value) { // 비밀번호와 비밀번호 확인이 동일한지
		alert('비밀번호가 다릅니다. 다시 확인해 주세요.');
		return false;
	}

	if (confirm("회원 탈퇴시 더 이상 서비스를 이용할 수 없습니다. 진행하시겠습니까?")) {
		//alert("탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.");
	} else {
		alert("탈퇴할 수 없습니다");
		return false;
	}
	withdrawalForm.submit();
});



//탈퇴시 비밀번호 확인 input 실시간 감지
$("#delete-pwd-check").on('input', function(e) {
	e.preventDefault();
	var inputPwd = $("#delete-pwd").val();
	var checkPwd = $("#delete-pwd-check").val();/* 비교 결과 */
	if (inputPwd == checkPwd) {
		checkPwd = inputPwd;
		alert("비밀번호가 일치합니다.");
	}
});




/*
	const email = document.getElementById('delete-email');

	let emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if (email.value == "" || email.value == null) {
		alert("이메일을 입력해 주세요");
		email.focus();
		return false;
	} else if (!emailRule.test(email.value)) {
		alert('올바른 이메일 형식이 아닙니다.');
		return false;
	}
	else if (confirm("회원 탈퇴시 더 이상 서비스를 이용할 수 없습니다. 진행하시겠습니까?")) {
		alert("탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.");
	} else {
		alert("탈퇴를 취소합니다.");
		return false;
	}
*/
