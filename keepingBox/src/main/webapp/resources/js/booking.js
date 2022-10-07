function checkPrice() {
  const stringSize = document.getElementById("stringsize");
  const intMoney = document.getElementById("intmoney");

  const startDay = document.getElementById("start-day").value;
  const endDay = document.getElementById("end-day").value;
  const ar1 = startDay.split("-");
  const ar2 = endDay.split("-");
  const da1 = new Date(ar1[0], ar1[1], ar1[2]);
  const da2 = new Date(ar2[0], ar2[1], ar2[2]);
  const dateDiff = Math.abs((da2 - da1) / (24 * 60 * 60 * 1000));

  if(startDay && endDay) {
    intMoney.value = (dateDiff * stringSize.value).toLocaleString() +'원';
  }
}
// 시작일자에서 오늘 이전으로 선택 안되게
let nowUtc = Date.now(); // 현재까지의 밀리초 (Number 형으로)
let timeOff = new Date().getTimezoneOffset() * 60000; // 분단위를 밀리초로 반환
let today = new Date(nowUtc - timeOff).toISOString().split("T")[0];
document.getElementById("start-day").setAttribute("min", today);
document.getElementById("end-day").setAttribute("min", today);

/**
 * getTimezoneOffset(): 현지 시간과 표준 시간의 차이(분)를 반환
 * toISOString(): 시간을 문자열로 바꿔서 반환 (현재 날짜를 UTC로)
 * new Date(nowUtc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
 */

// 사이즈, 날짜별 요금 계산
