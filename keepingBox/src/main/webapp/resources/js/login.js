let id = document.getElementById('id');
let pwd = document.getElementById('pwd');
let loginBtn = document.getElementById('btn');

loginBtn.addEventListener('click', function() {
    if(id.value === "") {
        alert('아이디를 입력하세요');
        id.focus();
        return false;
    } else if (pwd.value === "") {
        alert('비밀번호를 입력하세요')
        pwd.focus();
        return false;
    } else {
        location.href = 'main.html';

    }
});
