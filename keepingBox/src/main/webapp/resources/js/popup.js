/*
쿠키 생성
*/
function setCookie(name, value, exDay) {
	var todayDate = new Date();
	todayDate.setDate(todayDate.getDate() + exDay);
	document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}


function closePop() {
	if (document.pop_form.chkbox.checked) {
		setCookie("popup", "done", 1);
	}
	document.all['layer_popup'].style.visibility = "hidden";
}
cookiedata = document.cookie;
if (cookiedata.indexOf("popup=done") < 0) {
	document.all['layer_popup'].style.visibility = "visible";
}
else {
	document.all['layer_popup'].style.visibility = "hidden";
}