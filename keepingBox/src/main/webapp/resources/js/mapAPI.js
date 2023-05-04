/**
 * 
 */

const mapBtnG = document.getElementById("mapBtn1");
const maptBtnP = document.getElementById("mapBtn2");
const mapBtnB = document.getElementById("mapBtn3");
var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(33.450701,
		126.570667),
	level: 3
};

var map = new kakao.maps.Map(container, options);
