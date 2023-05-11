// 시작일자에서 오늘 이전으로 선택 안되게
let nowUtc = Date.now(); // 현재까지의 밀리초 (Number 형으로)
let timeOff = new Date().getTimezoneOffset() * 60000; // 분단위를 밀리초로 반환
let today = new Date(nowUtc - timeOff).toISOString().split("T")[0];
document.getElementById("start-day").setAttribute("min", today);
document.getElementById("end-day").setAttribute("min", today);

// 사이즈, 날짜별 요금 계산
const intMoney = document.getElementById("intmoney");
const stringSize = document.getElementById("stringsize");

function checkPrice() {
	const startDay = document.getElementById("start-day").value;
	const endDay = document.getElementById("end-day").value;
	const ar1 = startDay.split("-");
	const ar2 = endDay.split("-");
	const da1 = new Date(ar1[0], ar1[1], ar1[2]);
	const da2 = new Date(ar2[0], ar2[1], ar2[2]);
	const dateDiff = Math.abs((da2 - da1) / (24 * 60 * 60 * 1000));

	if (startDay && endDay) {
		intMoney.value = ((dateDiff * 2) * stringSize.value).toLocaleString() + '원';
	}
	if (startDay && endDay && dateDiff == 0) {
		intMoney.value = (stringSize.value).toLocaleString() + '원';
	}
}

// 예약하기 클릭 시
const nextBtn = document.getElementById("next-btn");
nextBtn.addEventListener("click", () => {
	const stringCity = document.getElementById("stringcity");
	if (stringCity.value == "" || stringSize.value == "" || intMoney.value < 5000) {
		alert("위 항목들을 선택해 주세요.");
		return false;
	} else if (confirm("예약하시겠습니까?")) {

		alert("예약되었습니다.");
	} else {
		alert('예약을 취소합니다.');
		return false;
	}
});

var csDate = $('.start-date').val();
var ceDate = $('.end-date').val();
var cnName = $('#book-name').val();
var csCity = $('#stringcity').val();
var csSize = $('#stringsize').val();
$('#money-btn').click(function() {
		$('#next-btn').attr("disabled", true); /*결제 버튼 눌러야 버튼 활성화 되면서 색상 변경*/
		$('#next-btn').css("color", "#fafafa");
		$('#next-btn').css("background", "#3781E3");
		var IMP = window.IMP;
		IMP.init("");   /* imp~*/

		var bookCity = $('select[name="city"]').val();
		console.log(bookCity);

		var bookSize = $('select[name="size"]').val();
		console.log(bookSize);

		var bookMoney = $('input[name="price"]').val();
		bookMoney = parseInt(bookMoney) * 1000;   /*dto에 String 타입이라 int형으로 형변환해야 제대로 뜸*/
		console.log(bookMoney);

		var bookName = $('input[name="name"]').val();
		console.log(bookName);
		/* 
		function requestPay() {
		html5_inicis : 이니시스, kakaopay
		*/

		IMP.request_pay({
			pg: 'html5_inicis',
			pay_method: 'card',
			merchant_uid: 'merchant_' + new Date().getTime(),

			name: '예약 지점명 : ' + bookCity + '점',
			amount: bookMoney,
			buyer_email: "",  /*필수 항목이라 "" 로 남겨둠*/
			buyer_name: bookName,
		}, function(rsp) {
			console.log(rsp);
			if (rsp.success) {
				var msg = '결제가 완료되었습니다.';
				console.log("결제성공 " + msg);

				$.ajax({
					type: "GET",
					url: "bookingPay" + res.imp_uid,
					data: {
						amount: bookMoney,
						imp_uid: rsp.imp_uid,
						merchant_uid: rsp.merchant_uid
					}
				});
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
			alert(msg);
			/*
			document.location.href="index"; 
			*/
		});
});
