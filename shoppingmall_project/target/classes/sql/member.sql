create table member(
	id	VARCHAR2(30) primary key NOT NULL,
	pw	VARCHAR2(100) not null,
	name VARCHAR2(30)	NOT NULL,
	phone	VARCHAR2(30)	NOT NULL,
	email	VARCHAR2(30)	NOT NULL,
	pcode	VARCHAR2(30)	NOT NULL,
	addr	VARCHAR2(100)	NOT NULL,
	daddr	VARCHAR2(100)	NOT NULL
);

-- 확인용 임시 값 넣어주었다
insert into member values('mimi','mimi','가나다','01012345678',
'ab@naver.com','10000','경기도 일산동구','아파트어디동어디호');
commit;