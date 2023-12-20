CREATE DATABASE tableDB;
use tableDB;
CREATE TABLE `usertbl` (
  `userID` char(8) NOT NULL primary key,
  `name` varchar(10) NOT NULL,
  `email` char(30) UNIQUE,
  `birthYear` int check (birthYear > 1900 and birthYear <= 2024),
  `addr` char(2) NOT NULL DEFAULT '서울',
  `mobile1` char(3) DEFAULT NULL,
  `mobile2` char(8) DEFAULT NULL,
  `height` smallint DEFAULT NULL,
  `mDate` date DEFAULT NULL
);

-- 테이블 생성 후 제약조건 추가
ALTER table usertbl
	ALTER COLUMN birthYear Set DEFAULT -1;
    
-- 뷰 생성
CREATE VIEW v_usertbl
	AS SELECT userid, name, addr from usertbl;

select * from v_usertbl;