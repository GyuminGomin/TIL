-- Join

-- INNER JOIN
use sqldb;
select * from buytbl
	inner join usertbl on buytbl.userId = usertbl.userId;

select * from buytbl
	inner join usertbl on buytbl.userId = usertbl.userId
where buytbl.userId = 'JYP';

select buytbl.userId, name, prodName, addr, concat(mobile1, mobile2) as '연락처' from buytbl
	inner join usertbl on buytbl.userId = usertbl.userId;
    
-- 테이블 2개 명시하고, where 조건절을 사용할 경우 내부조인이 가능
-- 호환성의 문제로 표준문법인 inner join 사용을 권장 (오류가 날 수 있으므로)
select buytbl.userId, name, prodName, addr, concat(mobile1, mobile2) as '연락처' from buytbl, usertbl
where buytbl.userId = usertbl.userId;

-- 각 컬럼이 어느 테이블에 속했는지 명확하게 표시 (테이블이 길어져서 보기 힘들 수 있으므로 별칭을 사용)
select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	inner join usertbl U on B.userId = U.userId;

-- OUTER JOIN
select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	left outer join usertbl U on B.userId = U.userId;

select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	right outer join usertbl U on B.userId = U.userId;

-- mysql은 full outer join을 제공해주지 않는다.
select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	left outer join usertbl U on B.userId = U.userId
union
select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	right outer join usertbl U on B.userId = U.userId;

-- 구매 이력이 없는 회원 목록만 조회하기
select B.userId, U.name, B.prodName, U.addr, concat(U.mobile1, U.mobile2) as '연락처' from buytbl B
	right outer join usertbl U on B.userId = U.userId
where B.prodName is Null;

-- N:N 관계
-- 학생 테이블
CREATE TABLE stdtbl (
	stdName varchar(10) primary key not null, -- 학생 이름
    addr	varchar(10) not null			  -- 학생 주소
);
-- 동아리 테이블 생성
CREATE TABLE clubtbl (
	clubName varchar(10) primary key not null, -- 동아리 이름
    roomNO	 varchar(10) not null			   -- 동아리 번호
);
-- 학생 동아리 테이블 생성
CREATE TABLE stdclubtbl (
	num int 				primary key auto_increment not null, -- 일련번호
    stdName varchar(10) 	not null,							 -- 학생이름
    clubName varchar(10) 	not null,							 -- 동아리이름
    foreign key (stdName) references stdtbl(stdName),
    foreign key (clubName) references clubtbl(clubName)
);
-- 학생 데이터 삽입
INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'),('바비킴','서울');
-- 동아리 데이터 삽입
INSERT INTO clubtbl VALUES ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
-- 학생 동아리 데이터 삽입
INSERT INTO stdclubtbl VALUES (NULL, '김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'), (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');

SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S inner join stdclubtbl SC on S.stdName = SC.stdName
			  inner join clubtbl C on SC.clubName = C.clubName
ORDER BY S.stdName;

-- 동아리에 가입되지 않은 학생도 출력
SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S left outer join stdclubtbl SC on S.stdName = SC.stdName
			  left outer join clubtbl C on SC.clubName = C.clubName
ORDER BY S.stdName;

-- 아무학생도 가입되지 않은 동아리 조회하기
SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S inner join stdclubtbl SC on S.stdName = SC.stdName
			  right outer join clubtbl C on SC.clubName = C.clubName
ORDER BY S.stdName;

-- 동아리에 가입되지 않은 학생 + 한명도 없는 동아리도 조회
SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S left outer join stdclubtbl SC on S.stdName = SC.stdName
			  left outer join clubtbl C on SC.clubName = C.clubName
UNION
SELECT S.stdName, S.addr, C.clubName, C.roomNo
FROM stdtbl S inner join stdclubtbl SC on S.stdName = SC.stdName
			  right outer join clubtbl C on SC.clubName = C.clubName;

-- CROSS JOIN
SELECT * FROM buytbl, usertbl;
SELECT * FROM buytbl cross join usertbl;

-- SELF JOIN
CREATE TABLE empTbl (
	empName char(3),
    manager char(3),
    empTel varchar(8)
);
INSERT INTO empTbl VALUES('나사장',NULL,'0000');
INSERT INTO empTbl VALUES('김재무','나사장','2222');
INSERT INTO empTbl VALUES('김부장','김재무','2222-1');
INSERT INTO empTbl VALUES('이부장','김재무','2222-2');
INSERT INTO empTbl VALUES('우대리','이부장','2222-2-1');
INSERT INTO empTbl VALUES('지사원','이부장','2222-2-2');
INSERT INTO empTbl VALUES('이영업','나사장','1111');
INSERT INTO empTbl VALUES('한과장','이영업','1111-1');
INSERT INTO empTbl VALUES('최정보','나사장','3333');
INSERT INTO empTbl VALUES('윤차장','최정보','3333-1');
INSERT INTO empTbl VALUES('이주임','윤차장','3333-1-1');

SELECT A.empName, A.manager, B.empTel FROM empTbl A inner join empTbl B on A.manager = B.empName
WHERE A.empName = '우대리';

-- UNION : 중복된 데이터는 조회 x
-- 열의 개수와 데이터 타입이 같으면 병합 가능
SELECT * FROM stdtbl
UNION
SELECT * FROM stdtbl;

-- UNION ALL : 중복된 데이터도 조회
SELECT * FROM stdtbl
UNION ALL
SELECT * FROM stdtbl;

-- 전화번호가 없는 사람은 제외하고 조회
SELECT * FROM usertbl
WHERE name not in (SELECT name FROM usertbl WHERE mobile1 is null);

-- 전화번호가 없는 사람 조회
SELECT * FROM usertbl
WHERE name in (SELECT name FROM usertbl WHERE mobile1 is null);