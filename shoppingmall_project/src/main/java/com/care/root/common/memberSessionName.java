package com.care.root.common;
//로그인세션있는 사용자는 공통으로 쓰기 때문에 공통모듈로 따로 빼주었다.
public interface memberSessionName {
	//로그인 성공했을때 생성되는 세션
	static final String LOGIN = "loginSuccessUser";

}
