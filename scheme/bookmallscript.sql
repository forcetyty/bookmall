set foreign_key_checks = 0; -- 중복 외래키 삭제 가능 명령어
set sql_safe_updates = 0;
show tables; -- table 생성 정보 확인


-- category 기본정보 입력
insert into category values('IT','HTML');
insert into category values('IT','JavaScript');
insert into category values('IT','JSP');
insert into category values('IT','SPRING');
insert into category values('IT','React');

insert into category values('Computer','OS');
insert into category values('Computer','Network');
insert into category values('Computer','DataBase');

-- category 테이블 확인
select * from category;

-- book 정보 입력
-- IT 00 -- html 0a / javascript 0b / jsp 0c / react 0d / spring 0e
-- computer 01 -- database 0a / network 0b / os 0c / 
insert into book values('000a01','HTML의 이해','15000','IT','html');
insert into book values('000b01','javascript 완벽가이드','20000','IT','javascript');
insert into book values('000C01','은노기 JSP','25000','IT','jsp');
insert into book values('000d01','React 입문','18000','IT','react');
insert into book values('000e01','Spring Boot','35000','IT','spring');

insert into book values('010a01','Oracle 입문','18000','computer','database');
insert into book values('010b01','후니의 시스코 네트워크','38000','computer','network');
insert into book values('010c01','OS의 이해','25000','computer','os');
insert into book values('010c02','OS Advance','45000','computer', 'os');

-- book 정보 입력 확인
select * from book;

-- member 정보 입력 - member = 회원 정보
insert into member values('good', '1234', 'tae', '01091459107', 'www@gmail.com');
insert into member values('brother', '1234', 'young', '01084211451', 'hhh@gmail.com');
insert into member values('pizza', '1234', 'hohoho', '01012349107', 'eee@gmail.com');
insert into member values('buger', '1234', 'ppppp', '01078949107', 'ppppp@gmail.com');
insert into member values('people', '1234', 'peo', '01078941234', 'oooooooo@gmail.com');

-- 회원정보 확인
select * from member; 

-- cart 정보 입력
insert into cart values(null,'good','010c02',2, now(), null);
insert into cart values(null,'good','000d01',1, now(), null);
insert into cart values(null,'brother','000a01',4, now(), null);
insert into cart values(null,'brother','000a01',1, '2019-09-14', null);
insert into cart values(null,'pizza','010c02',1, '2019-09-15', null);
insert into cart values(null,'buger','010b01',1, '2019-09-12', null);
insert into cart values(null,'people','000d01',5, '2019-09-16', null);


