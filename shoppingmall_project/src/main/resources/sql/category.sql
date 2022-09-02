create table category(
	catecode	VARCHAR2(30) primary key NOT NULL,	-- '규칙에 의거해 부여한 코드',
	catename	VARCHAR2(20)	NOT NULL,	--'실제 표시되는 이름',
	catecoderef	VARCHAR2(30) NULL,	--'상위 카테고리가 무엇인지 알려주는 코드'
    foreign key(catecoderef) references category(catecode) 
);

--확인용 임시데이터 만들기
--insert into category (catecode,catename) values('100','아우터');
--insert into category (catecode,catename,catecoderef) values('101','가디건/집업','100');
--insert into category (catecode,catename,catecoderef) values('102','자켓/베스트','100');

--insert into category (catecode,catename) values('200','탑');
--insert into category (catecode,catename,catecoderef) values('201','티셔츠','200');
--insert into category (catecode,catename,catecoderef) values('202','니트','200');
