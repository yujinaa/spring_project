var path = "${pageContext.request.contextPath }";
 
$(document).ready(function() {
var msg = "${msg}";
if(msg != ""){
alert(msg);    
}
});
 
function fnSubmit() {
 
var email =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
 
if ($("#me_name").val() == null || $("#me_name").val() == "") {
alert("이름을 입력해주세요.");
$("#me_name").focus();
 
return false;
}
 
if ($("#me_tel").val() == null || $("#me_tel").val() == "") {
alert("이메일을 입력해주세요.");
$("#me_tel").focus();
 
return false;
}
 
if(!email.test($("#me_tel").val())){
alert("이메일 형식에 맞게 입력해주세요.");
return false;
}
 
if (confirm("아이디를 찾으시겠습니까?")) {
 
$("#createForm").submit();
 
return false;
}
}
 