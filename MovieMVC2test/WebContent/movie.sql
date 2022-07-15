drop table movie;
drop table schedule;
drop table Room;
drop table ticket;
drop table member;

-- 01 액션 02 로멘스 03 코미디 04 스릴러 05 애니메이션
CREATE TABLE movie(
	movieNo number primary key, --영화 번호
	movieName VARCHAR2(20), --영화 제목
	category number, --장르
	runtime number, --120분
	img VARCHAR2(50), --이미지 파일 불러오기 위한 제목
	info VARCHAR2(200) --영화 정보
);

INSERT INTO movie VALUES(10000, '어벤저스', 01, 120, '1.jpg', '재밌다');
INSERT INTO movie VALUES(10001, '노팅힐', 02, 120, '2.jpg', '감동적이다');
INSERT INTO movie VALUES(10002, '아이언맨', 01, 120, '3.jpg', '멋있다');
INSERT INTO movie VALUES(10003, '겨울왕국2', 05, 130, '4.jpg', '재밌다');
INSERT INTO movie VALUES(10004, '엑시트', 03, 140, '5.jpg', '킬링타임');
INSERT INTO movie VALUES(10005, '반도', 04, 155, '6.jpg', '잘생겼다');
INSERT INTO movie VALUES(10006, '23아이덴티디', 04, 150, '7.jpg', '꿀잼');

CREATE TABLE MEMBER(
	id VARCHAR2(20) PRIMARY KEY, --아이디
	pw VARCHAR2(20), --비밀번호
	email VARCHAR2(50), --이메일
	tel VARCHAR2(20), --전화번호
	birth DATE --생년월일
);

insert into member values('test','1234','test@test.com','010-1234-1234','2002-05-12');

CREATE TABLE SCHEDULE( --상영관(ROOM) --관람시간 영화관이랑 연결해주는 테이블
	schNo NUMBER PRIMARY KEY, --스케줄 번호
	movieNo NUMBER, -- 영화 번호
	runDay DATE, --상영 날짜
	runtime NUMBER, --상영 시간 : 몇분짜리 영화인지
	roomNo NUMBER -- 상영관 번호
);

insert into schedule values(1,10000,TO_DATE('2020/11/11 11:50','yyyy/mm/dd hh24:mi'),120,1);
insert into schedule values(2,10000,TO_DATE('2020/11/11 1:50','yyyy/mm/dd hh24:mi'),120,1);
insert into schedule values(3,10000,TO_DATE('2020/11/11 3:10','yyyy/mm/dd hh24:mi'),120,1);
insert into schedule values(4,10000,TO_DATE('2020/11/11 8:50','yyyy/mm/dd hh24:mi'),120,1);
insert into schedule values(5,10000,TO_DATE('2020/11/11 9:50','yyyy/mm/dd hh24:mi'),120,1);

--INSERT INTO SCHEDULE VALUES(1, 10000, TO_DATE('2020/1q1/11 11:50', 'yyyy/mm/dd hh24:mi'), 120)

CREATE TABLE ROOM( --상영관
	roomNo NUMBER, --상영관 번호
	schNo NUMBER, --스케줄 번호
	seatCnt NUMBER -- 그 상영관에 얼마나 좌석이 예매가 되어있는지 카운트
);

--티켓이 insert 될 때마다 seatCnt(예매한 좌석수 ) 갯수도 증가해야한다 
update room set seatCnt = seatCnt +1 where schNo = 1;

--영화 구매했을때 저장되는 테이블
CREATE TABLE TICKET(
	ticketNo NUMBER PRIMARY KEY, --티켓 번호
	bookDate DATE, --결제한 날짜
	schNo NUMBER, --스케줄 번호
	seatNo NUMBER, --내가 선택한 좌석 번호
	id VARCHAR2(20) --회원아이디
);

SELECT schno, movieName, decode(category, 01, '액션', 02, '로멘스', 03,'코미디', 04, '스릴러', 05, '애니메이션'),
m.runtime, img, info, to_char(runday, 'mm/dd') AS 날짜
FROM movie m , schedule s WHERE m.movieNo = s.movieNo AND m.movieNo = 10000;

select * from schedule;
select * from movie;
select * from ticket;
select * from room;
select * from member;

INSERT INTO ticket VALUES(1,SYSDATE,1,15,'test');
INSERT INTO ticket VALUES(2,SYSDATE,1,14,'test');

insert into room values(1,2,1);

update room set seatCnt = seatCnt + 1 where schNo = 1; 

SELECT m.movieName, m.category, m.img, m.info, m.runtime, m.movieNo, s.schNo, r.roomNo, s.runDay, r.seatcnt FROM movie m, schedule s, room r WHERE m.movieNo = s.movieNo AND r.schNo = s.schNo AND m.movieNo = 10000;

SELECT * FROM ticket WHERE schNo = 1;