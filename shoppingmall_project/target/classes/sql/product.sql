create table product(
	prodnum	NUMBER	primary key not null,
	prodname	VARCHAR2(30)	NOT NULL,
    catecode	VARCHAR2(30)	NOT NULL,
	prodprice	NUMBER	NOT NULL,
	prodinfo	VARCHAR2(500)	NULL,
	prodstock	NUMBER	NULL,
	prodimg	VARCHAR2(500)	NULL
);