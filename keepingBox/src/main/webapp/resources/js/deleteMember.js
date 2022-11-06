const pwdCheck = document.getElementById("pwd");
const withdrawalBtn = document.getElementById("withdrawal-btn");

withdrawalBtn.addEventListener("click", function() {
    if(pwdCheck.value === "") {
        alert("이메일을 입력해 주세요");
        pwdCheck.focus();
        return false;
    } else {
        if(confirm("정말로 탈퇴하시겠습니까?")) {
            alert("탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.");
            return true;
        } else {
        alert("탈퇴할 수 없습니다");
            pwdCheck.focus();
            return false;
        }    
    }
});