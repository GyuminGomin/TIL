-- 데이터베이스 선택
use sqldb;

-- DDL 테이블 생성
create table testTBL (id int, userName char(3), age int);

-- DML 데이터 삽입
INSERT INTO testTBL (id, userName, age) values (1,'홍길동', 30);
INSERT INTO testTBL (id, userName) values (2,'홍길순');
INSERT INTO testTBL values (3,'홍길서', 32);
INSERT INTO testTBL (userName, id, age) values ('홍길남', 4, 30);

-- DQL 데이터 조회
select * from testTBL;

-- DDL 두번째 테이블 생성
create table testTBL2 (
	id int auto_increment primary key,
    userName char(3),
    age int
);

-- DML 두번째 테이블 데이터 삽입
INSERT INTO testTBL2 values (NULL,'홍길동', 30);
INSERT INTO testTBL2 values (NULL,'홍길순', 31);
INSERT INTO testTBL2 values (NULL,'홍길서', 32);
INSERT INTO testTBL2 values (NULL,'홍길남', 33);

-- DDL 테이블 정보 변경
ALTER TABLE testTBL2 auto_increment=100;
INSERT INTO testTBL2 values (NULL,'홍길덩', 34);

-- 자동 증가 값을 변경하기 (서버 변수 변경)
SET @@auto_increment_increment=3;
INSERT INTO testTBL2 values (NULL,'홍길두', 35);
INSERT INTO testTBL2 values (NULL,'홍길한', 36);
INSERT INTO testTBL2 values (NULL,'홍길희', 37);

-- DQL 데이터 조회
select * from testTBL2;

-- 증가값 복구
SET @@auto_increment_increment=1;

-- 샘플 데이터 생성하기
create table testTBL3 (
	id int,
    firstName varchar(50),
    lastName varchar(50)
);

-- insert into ~ select (대량의 샘플데이터 가져오기)
insert into testTBL3 
	select emp_no, first_name, last_name from employees.employees;

-- 데이터 수정하기
update testTBL3
	set lastName = '없음'
    where firstName = 'Kyoichi';
select * from testTBL3 where firstName = 'Kyoichi';

-- where 조건절을 생략하게 될 경우, 전체 행 값이 변경된다. (주의)
update buytbl
	set price = price * 1.5;
select * from buytbl;

-- 삭제
delete from testTBL3 where firstName = 'Georgi';

-- 상위 5건만 삭제하기
select * from testTBL3 where firstName='Bezalel';
delete from testTBL3 where firstName = 'Bezalel' LIMIT 5;

-- autocommit 설정 확인 및 변경
-- 명령문이 실행될 때 자동으로 commit 수행 여부
select @@autocommit; -- 1 : true -> 자동 커밋 설정 상태
set @@autocommit := 0; -- 0 : false -> 자동 커밋 설정 해제
set @@autocommit := true;
set @@autocommit := false;

select * from testTBL3;
update testTBL3 set firstName = '없음';
-- tcl : 현재 세션에서 실행된 작업 이전 commit 시점으로 되돌림
-- autocommit을 해제한 시점으로 되돌아감
rollback; 
update testTBL3 set firstName = '없음';
commit; -- 현재 세션에서 실행된 작업을 적용
-- 여기서 rollback을 하더라도 변경이 되지 않는다. (제일 마지막 커밋한 시점으로 돌아가기 때문에)

-- 테이블 삭제하기
create table testTBL4(
	select * from employees.employees
);
create table testTBL5(
	select * from employees.employees
);
create table testTBL6(
	select * from employees.employees
);

select * from testTBL4;
-- 모든 행을 삭제 (데이터 구조는 남아있음 DML, commit하지 않았을 때 롤백 가능)
delete from testTBL4;
rollback;
-- 모든 데이터를 삭제 (데이터 구조는 남아있음 DDL, commit을 포함하므로 rollback되지 않음)
truncate table testTBL5;
select * from testTBL5;
rollback;
-- 모든 데이터를 삭제 (테이블 자체를 삭제 DDL, 데이터 구조가 남아있지 않음)
DROP TABLE testTBL6;
select * from testTBL6; -- DDL : 커밋을 포함
rollback;

-- 오토 커밋 원상 복구
set @@autocommit := true;

