let path = "${pageContext.request.contextPath }";
const doJoin = document.getElementById("join-btn");
doJoin.addEventListener("click", register);
const JoinformElement = document.querySelector("form");

function register(e) {
	e.preventDefault();
	// ----------------- 유효성검사 정규식 -----------------
	let RegExp = /^[a-zA-Z0-9]{4,12}$/; // id, pwd
	let n_RegExp = /^[가-힣]{2,15}$/; //이름
	let p_RegExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/; // 휴대폰
	let e_RegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일

	const id = document.getElementById('id');
	const pwd = document.getElementById('pwd');
	const pwdChk = document.getElementById('pwdchk');
	const name = document.getElementById('name');
	const phone = document.getElementById('phone');
	const email = document.getElementById('email');

	// ----------------- id 유효성검사 -----------------
	if (id.value === "") {
		alert('아이디를 입력해 주세요.');
		id.focus();
		return false;
	}

	if (!RegExp.test(id.value)) {
		alert('아이디는 4~12자의 영문 대소문자와 숫자로만 입력해 주세요.');
		return false;
	}

	// ----------------- pwd 유효성검사 -----------------
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
		alert('비밀번호 재확인을 위해 다시 입력해 주세요.');
		pwdChk.focus();
		return false;
	}
	if (pwd.value === id.value) { // 비밀번호와 아이디가 동일한지
		alert('비밀번호와 아이디는 동일하면 안됩니다.');
		return false;
	}
	if (pwd.value !== pwdChk.value) { // 비밀번호와 비밀번호 확인이 동일한지
		alert('비밀번호가 다릅니다. 다시 확인해 주세요.');
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
	if (confirm("회원가입 하시겠습니까?")) {
		JoinformElement.submit();
		alert('회원가입이 완료되었습니다.');
	} else {
		alert("회원가입을 할 수 없습니다.");
		return false;
	}
}
/*
메일 인증
*/

var code = "";  /*인증번호 저장할 곳*/
$('#auth_btn').click(function() {
	var email = $('#email').val();  /*입력한 이메일*/
	console.log('완성된 이메일 : ' + email); /* 이메일 오는지 확인*/
	var checkInput = $('.mail-check-input') /* 인증번호 입력 */

	if (email.value == '') {
		alert('이메일을 입력해 주세요.');
		email.focus();
		return false;
	}

	$.ajax({
		type: 'GET',
		url: 'mailCheck?email=' + email, /*url을 통해 데이터를 보낼 수 있도록 GET방식, url명을 "mailCheck"로 지정 */
		success: function(data) {
			console.log("data : " + data);
			checkInput.attr('disabled', false); /*데이터가 성공적으로 들어오면 인증번호 입력란이 활성화되도록*/
			code = data;
			alert('인증번호가 전송되었습니다.')
		},

	}
	);

	/* 인증번호 비교 */
	$('.mail-check-input').on('input', function() {
		var inputCode = $(".mail-check-input").val();   /*사용자가 입력한 전송 번호*/
		var checkResult = $("#mail-check-input-info");  /* 비교 결과 */

		if (inputCode == code) {  /*사용자가 입력한 전송코드가 발급된 인증번호와 같다면*/                          // 일치할 경우
			checkResult.html("인증번호가 일치합니다.");
			checkResult.attr("class", "correct");
			$(".mail-check-input").css("border", "1.5px solid #3781E3");/*일치할 경우 테두리 색 변경*/
			$(".mail-check-input").css("color", "#3781E3");/*일치할 경우 글자 색 변경*/
		} else {
			checkResult.html("인증번호를 다시 확인해주세요.");
			checkResult.attr("class", "incorrect");
			$(".mail-check-input").css("border", "1.5px solid red");
			$(".mail-check-input").css("color", "red");
		}
	});
})

$("#pwdchk").on('input', function(e) {
	e.preventDefault();
	var inPwd = $("#pwd").val();
	var chkPwd = $("#pwdchk").val();/* 비교 결과 */
	if (inPwd == chkPwd) {
		chkPwd = inPwd;
		alert("비밀번호가 일치합니다.");
	}
});