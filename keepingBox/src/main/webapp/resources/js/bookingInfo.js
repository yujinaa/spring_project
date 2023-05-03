// 예약취소, 메인으로 돌아가기 클릭 시
const cancelBtn = document.getElementById("cancel-btn");
const mainBtn = document.getElementById("main-btn");
const payBtn = document.getElementById("pay-btn");

cancelBtn.addEventListener("click", () => {
    if(confirm("예약을 취소하시겠습니까?")) {
    alert("취소되었습니다.");
return true;
    } else {
	alert('예약을 취소할 수 없습니다.');
        return false;
    }
});
/*
payBtn.addEventListener("click", () => {
	alert("예약 완료를 위해 결제 페이지로 이동합니다")
});
*/

        var IMP = window.IMP;
        IMP.init("");
  function requestPay() {

        IMP.request_pay({
            pg: 'kakao',
            pay_method: 'card',
            merchant_uid: 'merchant_' + new Date().getTime(),

            name: '주문명 : 주문명 설정',
            amount: 1004,
            buyer_email: 'booking.email',
            buyer_name: 'booking.name',
            buyer_tel: 'info.phone',
        }, function (rsp) {
            console.log(rsp);
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
               console.log("결제성공 " + msg);
                $.ajax({
                    type: "GET", 
                    url: "/booking/payment", 
                    data: {
                        "amount" : pay
                    },
                });
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }
            alert(msg);
            document.location.href="/index"; 
        });
        }