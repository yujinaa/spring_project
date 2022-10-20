var path = "${pageContext.request.contextPath }"; 
 
function fnSubmit() {
 
var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
 
if ($("#me_id").val() == null || $("#me_id").val() == "") {
alert("아이디를 입력해주세요.");
$("#me_id").focus();
 
return false;
}
 
if ($("#me_name").val() == null || $("#me_name").val() == "") {
alert("이름을 입력해주세요.");
$("#me_name").focus();
 
return false;
}
 
 
if ($("#me_email").val() == null || $("#me_email").val() == "") {
alert("이메일을 입력해주세요.");
$("#me_email").focus();
 
return false;
}
 
if(!email_rule.test($("#me_email").val())){
alert("이메일 형식에 맞게 입력해주세요.");
return false;
}
 
 
if (confirm("비밀번호를 찾으시겠습니까?")) {
 
$("#createForm").submit();
 
return false;
}
}
 