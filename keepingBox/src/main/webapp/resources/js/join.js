function register() {
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
    if(id.value === "") {
        alert('아이디를 입력해 주세요.');
        id.focus();
        return false;
    }

    if(!RegExp.test(id.value)) {
        alert('아이디는 4~12자의 영문 대소문자와 숫자로만 입력해 주세요.');
        return false;
    }

    // ----------------- pwd 유효성검사 -----------------
    if(pwd.value === "") {
        alert('비밀번호를 입력해 주세요.');
        pwd.focus();
        return false;
    }
    if(!RegExp.test(pwd.value)) {
        alert('비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력해 주세요.');
        return false;
    }

    if(pwdChk.value === "") {
        alert('비밀번호를 입력해 주세요.');
        pwdChk.focus();
        return false;
    }
    if(pwd.value === id.value) { // 비밀번호와 아이디가 동일한지
        alert('비밀번호와 아이디는 동일하면 안됩니다.');
        return false;
    }
    if(pwd.value !== pwdChk.value) { // 비밀번호와 비밀번호 확인이 동일한지
        alert('비밀번호가 다릅니다. 다시 확인해 주세요.');
        return false;
    }

    // ----------------- name 유효성검사 -----------------
    if(name.value === "") {
        alert('이름을 입력해 주세요.');
        name.focus();
        return false;
    }
    if(!n_RegExp.test(name.value)) {
        alert('한글로만 입력해 주세요.');
        return false;
    }

    // ----------------- phone 유효성검사 -----------------
    if(phone.value === "") {
        alert('휴대폰 번호를 입력해 주세요.');
        phone.focus();
        return false;
    }
    if(!p_RegExp.test(phone.value)) {
        alert('숫자만 입력해 주세요.');
        return false;
    }
    
    // ----------------- email 유효성검사 -----------------
    if(email.value === "") {
        alert('이메일을 입력해 주세요.');
        email.focus();
        return false;
    }
    if(!e_RegExp.test(email.value)) {
        alert('올바른 이메일 형식이 아닙니다.');
        return false;
    }

    alert('회원가입이 완료되었습니다.');
}