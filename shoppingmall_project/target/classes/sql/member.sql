create table member(
	id	VARCHAR2(30) primary key,
	pw	VARCHAR2(100) not null,
	name VARCHAR2(30)	NOT NULL,
	phone	VARCHAR2(30)	NOT NULL,
	email	VARCHAR2(30)	NOT NULL,
	pcode	VARCHAR2(30)	NULL,
	addr	VARCHAR2(100)	NULL,
	daddr	VARCHAR2(100)	NULL,
);

