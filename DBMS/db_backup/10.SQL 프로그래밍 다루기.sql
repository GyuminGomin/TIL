-- SQL 프로그래밍

-- stored procedure (스토어드 프로시저) : 보통 여러 개의 쿼리문의 동작을 절차로 묶어서 저장
-- CALL을 통하여 호출

-- 프로시저 생성
DELIMITER //
	CREATE procedure func() -- 프로시저 이름()
		BEGIN
			-- 실행할 쿼리문들
		END //
DELIMITER ;

-- 실행
CALL func(); -- 프로시저 이름()

-- IF ~ ELSE 문
DELIMITER //
	CREATE procedure func() -- 프로시저 이름()
		BEGIN
			-- 실행할 쿼리문들
            DECLARE var1 INT; -- var1 변수를 선언
            SET var1 = 100; -- 변수에 값을 대입
            IF var1 = 100 THEN 
				SELECT '100입니다.';
			ELSE
				SELECT '100이 아닙니다.';
			END IF;
		END //
DELIMITER ;

CALL func();


use employees;
DELIMITER //
	CREATE procedure func2() 
		BEGIN
			DECLARE hireDate DATE; -- 입사일
            DECLARE curDate DATE; -- 현재일
            DECLARE days INT; -- 근무일수
            SELECT hire_date INTO hireDate FROM employees WHERE emp_no = 10001; -- 사원 입사일 대입
            SELECT current_date() INTO curDate; -- 현재 날짜 대입
            SET days = datediff(curDate, hireDate); -- 근무일수 대입
            
            IF (days/365) >= 5 THEN
				SELECT concat('입사일로부터 ', days, '일이 지났습니다. 5년을 넘으셨습니다.');
			ELSE
				SELECT concat('입사일로부터 ', days, '일이 지났습니다. 5년을 넘지 못하셨습니다.');
			END IF;
		END //
DELIMITER ;

DROP procedure IF EXISTS func; -- 기존에 존재하면 삭제

CALL func2();

-- 매개변수를 전달받는 프로시저
-- 매개변수 선언 형식 : 'IN 매개변수명 데이터타입'

-- 사원번호를 매개변수로 받는 저장 프로시저
DELIMITER //
	CREATE procedure func3(IN empno int)
		BEGIN
			SELECT * FROM employees WHERE emp_no = empno;
        END //
DELIMITER ;

CALL func3(10002);

-- usertbl 테이블 회원 이름을 전달받아서 연령대를 출력하는 프로시저
use sqldb;
desc usertbl;
DELIMITER //
	CREATE procedure func4(IN empname varchar(5))
		BEGIN
			DECLARE yearBirth int; -- 연도
            DECLARE age int; -- 나이
            DECLARE result text; -- 출력 연령대
			SELECT birthYear INTO yearBirth FROM usertbl WHERE name = empname;
            SET age = YEAR(now()) - yearBirth;
            IF age >= 60 THEN
				SET result = "60대 이상입니다.";
			ELSEIF age BETWEEN 50 AND 59 THEN
				SET result = "50대 입니다.";
            ELSEIF age BETWEEN 50 AND 59 THEN
				SET result = "50대 입니다.";
			ELSEIF age BETWEEN 40 AND 49 THEN
				SET result = "40대 입니다.";
			ELSEIF age BETWEEN 30 AND 39 THEN
				SET result = "30대 입니다.";
			ELSEIF age BETWEEN 20 AND 29 THEN
				SET result = "20대 입니다.";
			ELSE
				SET result = "20살 미만입니다.";
			END IF;
            SELECT result;
        END //
DELIMITER ;
SELECT * FROM usertbl;
CALL func4('조용필');

-- 반복문 (구구단 만들기)
DELIMITER //
	CREATE procedure whileTest(IN num int)
		BEGIN
			DECLARE str TEXT; -- 구구단 문자열
            DECLARE i int; -- 구구단 곱할 수
            SET str = '';
            SET i = 1;
            while (i < 10) DO
				SET str = concat(str,' ',num,'*',i,'=',num*i);
                SET i = i + 1;
			end while; -- 반복문 종료
            SELECT str;
        END //
DELIMITER ;

Drop procedure if exists whileTest;

CALL whileTest(2);

-- 오류 처리
-- DECLARE 액션 HANDLER FOR 오류조건 처리할문장;
DROP PROCEDURE IF EXISTS errorProc;
DELIMITER //
	CREATE procedure errorProc()
		BEGIN
			-- 오류 처리
			DECLARE continue -- continue는 계속하겠다, EXIT는 나가겠다
            HANDLER FOR 1146 -- 1146 : Table이 존재하지 않는다는 오류
            SELECT '테이블이 존재하지 않습니다.' as msg; 
            SELECT * FROM notable; -- 존재하지 않는 테이블
        END //
DELIMITER ;

CALL errorProc();

-- 동적 SQL문
-- PREPARE STATEMENT 문과 EXECUTE 문
CREATE TABLE mytbl(
	id int primary key auto_increment,
    mDate DATETIME
);

-- 현재 날짜와 시간
SET @curDate = current_timestamp();
-- 준비된 SQL문 : 향후에 입력될 값을 ?로 비워놓는다.
prepare myQuery FROM 'INSERT INTO mytbl VALUES (NULL, ?)';
-- 실행 : using을 이용하여 와일드카드(?)에 대응하는 값을 전달
execute myQuery using @curDate;
select * from mytbl;
-- 준비된 쿼리문 제거
DEALLOCATE PREPARE myQuery;

