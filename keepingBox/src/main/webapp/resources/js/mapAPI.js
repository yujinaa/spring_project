/**
 * 
 */

const mapBtnG = document.getElementById("mapBtn1");
const mapBtnP = document.getElementById("mapBtn2");
const mapBtnB = document.getElementById("mapBtn3");

//지도 띄우기
var mapContainer = document.getElementById('kakaoMap1');
mapOption = {
	center: new kakao.maps.LatLng(37.5709, 126.9779), //중심좌표
	level: 3
};
var map = new kakao.maps.Map(mapContainer, mapOption);

//지역별 지점 띄우기
mapBtnG.addEventListener("click", () => {
	var mapContainer = document.getElementById('kakaoMap1');
	mapOption = {
		center: new kakao.maps.LatLng(37.5709, 126.9779),
		level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);
	// 마커가 표시될 위치입니다 
	var markerPosition = new kakao.maps.LatLng(37.5709, 126.9779);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
})

mapBtnP.addEventListener("click", () => {
	var mapContainer = document.getElementById('kakaoMap1');
	mapOption = {
		center: new kakao.maps.LatLng(37.3927, 127.0904),
		level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);
	// 마커가 표시될 위치입니다 
	var markerPosition = new kakao.maps.LatLng(37.3927, 127.0904);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
})

mapBtnB.addEventListener("click", () => {
	var mapContainer = document.getElementById('kakaoMap1');
	mapOption = {
		center: new kakao.maps.LatLng(37.4716, 126.8127),
		level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);
	// 마커가 표시될 위치입니다 
	var markerPosition = new kakao.maps.LatLng(37.4716, 126.8127);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});

	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
})



