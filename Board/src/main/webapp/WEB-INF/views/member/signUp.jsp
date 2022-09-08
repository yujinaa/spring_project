<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">

	<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 400px;
	margin-top: 100px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
</head>

<body>
	<div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">Sign Up</h4>
        <form class="validation-form" action="signUp" method="post" novalidate>
            <div class="mb-3">
              <label for="name">아이디</label>
              <input type="text" class="form-control" name="userId" placeholder="ID" required>
              <div class="invalid-feedback">
                아이디는 필수 입력입니다!
              </div>
            </div>
            <div class="mb-3">
              <label for="pwd">비밀번호</label>
              <input type="password" class="form-control" name="userPwd"
								placeholder="PASSWORD" required>
              <div class="invalid-feedback">
                비밀번호는 필수 입력입니다!
              </div>
            </div>

          <div class="mb-3">
            <label for="name">이름</label>
            <input type="text" class="form-control" name="userName"
							placeholder="NAME" required>
            <div class="invalid-feedback">
              주소는 필수 입력입니다!
            </div>
          </div>
          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="email" class="form-control" name="userEmail"
							placeholder="my@example.com" required>
            <div class="invalid-feedback">
              이메일은 필수 입력입니다!
            </div>
          </div>          
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
        </form>
      </div>
    </div>
  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
</html>

</body>

</html>