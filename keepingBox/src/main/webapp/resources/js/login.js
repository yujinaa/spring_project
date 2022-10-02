// let loginId = document.getElementById('id');
// let loginPwd = document.getElementById('pwd');
// let loginBtn = document.getElementById('btn');
let id = document.getElementById('id');
let pwd = document.getElementById('pwd');
let loginBtn = document.getElementById('btn');

// html button에 onclick="login();"
// function login() {
//     if(loginId.value == "") {
//         alert('아이디를 입력하세요');
//         loginId.focus();
//         return false;
//     } else if (loginPwd.value == "") {
//         alert('비밀번호를 입력하세요')
//         loginPwd.focus();
//         return false;
//     } else {
//         location.href = 'main.html';

//     }
    
// }

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
