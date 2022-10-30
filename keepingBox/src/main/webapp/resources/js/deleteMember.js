const pwdCheck = document.getElementById("pwd");
const withdrawalBtn = document.getElementById("withdrawal-btn");

withdrawalBtn.addEventListener("click", function() {
    if(pwdCheck.value == null || pwdCheck.value === "") {
        alert("비밀번호를 입력해 주세요");
        pwdCheck.focus();
        return false;
    } else {
        if(confirm("정말로 탈퇴하시겠습니까?")) {
            alert("탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.");
        } else {
            pwdCheck.focus();
            return false;
        }    
    }
});