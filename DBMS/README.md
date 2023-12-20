# DBMS(Database Management System)

- MySQL : 오픈소스(무료) 1위 => 오라클에 합병 (무료+상용)
    - MariaDB : MySQL 개발자가 오픈소스로 만든 DBMS (MySQL)
- Oracle : 상용 시장 점유율 1위
- SQL Server : 마이크로소프트에서 만든 DBMS
- PostgreSQL : 오픈 소스시장 1위 (표준을 잘 지킴)
- SQLite : 모바일 시장, 파일형태의 경량급 DBMS
- H2 : in-memory Database

## DBMS의 특징
    - 무결성 (Integrity) : 데이터의 오류가 있어서는 안됨. 정확성과 일관성 보장. 제약조건 강제
    - 독립성 (Independancy) : 애플리케이션과 물리적 저장소 간에 추상화 계층 제공 (저장소가 변경되더라도 기존 프로그램에 영향을 미치지 않는다.)
    - 동시성 제어 (Concurrency Control): 여러 사용자가 동시에 데이터베이스에 접근해도 조화롭게 처리됨. (트랜잭션)
    - 보안 (Secure) : 데이터베이스에 접근하는 권한 제한. 허가된 사람만 접근 가능.
    - 트랜잭션 관리 : 하나 이상의 SQL문을 하나의 단위로 실행한다.
    - ACID 보장
        - 원자성 (Atomicity) : 전부 성공하거나 전부 실패하는 특성
        - 일관성 (Consistency) : 실행되기 전과 실행된 후에 정확한 규칙과 제약조건을 따라야 함
        - 고립성 (Isolation) : 여러 트랜잭션이 동시에 실행될 때, 서로 다른 트랜잭션 작업에 영향을 받지 않아야 함
        - 지속성 (Durability) : 성공적으로 반영되면, 영구히 데이터베이스에 반영되어야 함 (시스템 전원이 꺼져도 결과 유지)

## DBMS의 분류
`계층형(HDBMS), 망형(NetworkDBMS), 관계형(RDBMS), 객체지향형(ODBMS), 객체관계형(ORDBMS)`

- RDBMS
    - Table이라 불리는 최소단위로 구성
    - 테이블은 하나 이상의 열(Column)로 구성되어 있음

## SQL (Structure Query Language)
`RDBMS에서 사용되는 언어로 에스큐엘 또는 시퀄이라고 읽음`

- DBMS 제작회사와 독립적이며, 회사별로 별도의 SQL이 존재
- 표준 SQL문이 계속 발전 중

------
# mysql 설정
1. mysql 설치
    - `$ apt -y install mysql-server mysql-client`

2. 서비스 시작 및 등록
    - `$ systemctl status mysql`
    - `$ systemctl enable mysql`

3. mysql 버전 확인
    - `$ mysql --version`

4. 방화벽 허용 (3306port) 및 확인
    - `$ ufw allow mysql`
    - `$ ufw status`

5. mysql 접속 후 유저 확인후 새로 생성 후 종료
    - `$ mysql`
    ```
    mysql > select host, user from mysql.user;

    mysql > create user root@'%' identified by '1234'; 
    -- 1234비번으로 root 유저를 생성하는데 모든 PC의 IP에서 접속 가능 옵션 '%'

    mysql > grant all on *.* to root@'%' with grant option;
    -- with grant option은 권한을 부여할 수 있는 권한 옵션을 부여

    mysql > exit -- 종료
    ```

# sql 문 간단하게 확인 후, Host Os에서 접속 가능하게 설정
1. 데이터 베이스 조회
    ```
    mysql > show databases;
    ```
    
2. 데이터베이스 생성
    ```
    mysql > create database [지정할 db 이름]; -- ex. create database test_db;
    ```

3. 사용할 데이터 베이스 지정
    ```
    mysql > use [지정한 db 이름]; -- ex. use test_db;
    ```

4. 데이터베이스 삭제
    ```
    mysql > drop database [삭제할 db 이름]; -- ex. drop database test_db;
    ```

5. 종료 후 외부에서 접속 가능하게 설정 정보 변경
    - $ `nano -c /etc/mysql/mysql.conf.d/mysqld.cnf`
    - 31번째 행 bind-address = 127.0.0.1을 주석처리
        - 로컬이 아닌 외부에서도 접속가능하게 설정

6. mysql 데몬 재시작

### Host OS에서 접속하기
<a href="https://blog.naver.com/ool9898/223278111964">VMWare에 설치된 MySQL서버 HostOS에서 실행</a>

---

# SQL 명령어의 범주

1. DDL (데이터 정의 언어 : Data Definition Language)
    - 데이터의 구조를 정의하고 조작하는데 사용
    - CREATE, ALTER, DROP, TRUNCATE 등
    - 커밋이 포함되어 있음 (AutoCommit이 꺼져있더라도 수행이 됨)
    ``` sql
    -- 테이블 생성
    CREATE TABLE 테이블명 (열1, 데이터타입1...);
    -- 테이블 수정
    ALTER TABLE 테이블명 ADD COLUMN 새로운 열 데이터타입;
    -- 테이블 삭제
    DROP TABLE 테이블명;
    -- 테이블 구조 유지하면서 데이터 삭제
    TRUNCATE TABLE 테이블명;
    ```

2. DML (데이터 조작 언어 : Data Manipulation Language)
    - 데이터를 조작하는 데 사용
    - INSERT, UPDATE, DELETE (SELECT를 넣는 분류도 있음)
    - 트랜잭션이 발생함.
    ``` sql
    -- 데이터 삽입
    INSERT INTO 데이터베이스.테이블명 (열1, 열2, ...) VALUES (값1, 값2, ...);
    -- 데이터 수정
    UPDATE 데이터베이스.테이블명 SET 열1=값1 WHERE 조건식;
    -- 데이터 삭제
    DELETE FROM 데이터베이스.테이블명 WHERE 조건식; 
    ```

3. DQL (데이터 조회 언어 : Data Query Language)
    - 데이터를 조회하는 데 사용
    - SELECT

4. TCL (트랜잭션 제어 언어 : Transaction Control Language)
    - COMMIT, ROLLBACK, SAVEPOINT
    ``` sql
    -- 트랜잭션 완료
    COMMIT;
    -- 트랜잭션 취소(되돌리기)
    ROLLBACK;
    -- 일부데이터만 롤백가능하게 SAVEPOINT 설정
    SAVEPOINT 포인트명;
    ```

5. DCL (데이터 제어 언어 : Data Control Language)
    - 데이터베이스의 권한을 부여하거나 회수하는 데 사용
    - GRANT, REVOKE
    ``` sql
    -- 권한 부여
    GRANT 권한 ON 데이터베이스.테이블 TO 사용자;
    -- 권한 회수
    REVOKE 권한 ON 데이터베이스.테이블 FROM 사용자;
    ```

---

# MySQL의 데이터 타입

### 숫자 유형 타입
- 정수 타입
    - TINYINT
    `매우 작은 범위의 정수` (1바이트 -128 ~ 127)
    - SMALLINT
    `작은 범위의 정수` (2바이트 -32,768 ~ 32,767)
    - INT or INTEGER
    `표준 정수` (4바이트 약 -21억 ~ 21억)
    - BIGINT
    `큰 범위의 정수` (8바이트 -922경 ~ 922경)

- 부동 소수점 유형
    - FLOAT
    `4바이트의 소수` (소수점 7자리까지 표현)
    - DOUBLE
    `8바이트의 소수` (소수점 15자리까지 표현)
    - DECIMAL
    `정확한 10진수를 표현`

### 문자 유형 데이터 타입

- CHAR(N)
`고정 길이 문자` (1~255 까지 지정)
- VARCHAR(N)
`가변 길이 문자형` (1~65535 까지 지정)
- LONGTEXT
`최대 4GB 만큼의 TEXT 데이터 저장`

### 날짜와 시간 데이터 타입

- DATE
`날짜 YYYY-MM-DD` (1001-01-01 ~ 9999-12-31)
- TIME
`시간 HH:MM:SS`
- DATETIME
`날짜와 시간 합친 정보 YYYY-MM-DD HH:MM:SS`
- TIMESTAMP
`날짜 시각 정보를 저장`
- YEAR
`연도 정보 YYYY`

### 기타 유형
- 이진 데이터 타입
    - BINARY(N)
    `고정길이 이진 데이터` (1~255)
    - VARBINARY(N)
    `가변길이 이진 데이터` (1~255)
    - BLOB (Binary Large Object)
    `큰 사이즈의 이진 데이터` (최대 65,535)
    - LONGBLOB
    `최대 4GB만큼의 이진 데이터 값`

- 불리언 유형 타입
    - BOOLEAN
    `참, 거짓`
- 열거형 유형 타입
    - ENUM
    `가능한 값 중 하나를 선택`

---

# 조인(Join)
`두 개 이상의 테이블을 서로 묶어서 하나의 결과 집합으로 만들어 내는 것`

- 데이터베이스의 테이블은 일반적으로 중복과 공간 낭비를 피하거나 무결성 유지를 위해 테이블을 나누어 저장
- 분리된 테이블은 관계(Relation)을 가짐
- 보편적으로 1:N 관계

### Inner Join (내부 조인)
`두 테이블 간의 일치하는 행만 선택`
```
SELECT 컬럼명 FROM 테이블1
    INNER JOIN 테이블2 ON 조인할 조건
WHERE 조건;
```
### Outer Join (외부 조인)
`두 테이블 간의 일치하지 않는 행도 선택`
1. LEFT OUTER JOIN
    - 왼쪽 테이블의 모든 행을 선택
    - 오른쪽 테이블의 일치하는 행을 포함
2. RIGHT OUTER JOIN
    - 오른쪽 테이블의 모든 행을 선택
    - 왼쪽 테이블의 일치하는 행을 포함
3. FULL OUTER JOIN
    - 양쪽 테이블의 모든 행을 선택
    - 일치하지 않는 행의 열 값은 NULL로 채워짐
    - 모든 DBMS에서 지원하는 것은 아님
```
SELECT 컬럼명 FROM 테이블1
    <LEFT,RIGHT,FULL (선택)> OUTER JOIN 테이블2 ON 조인할 조건
WHERE 조건;
```

### Cross Join (Cartesian Product 데카르트 곱)
- 한쪽 테이블의 모든 행과 다른 데이터의 모든 행을 조인
- 두 테이블의 행수를 곱한 개수만큼 결과가 나옴
```
SELECT 컬럼명 FROM 테이블1
    <CROSS (생략가능)> JOIN 테이블2 ON 조인할 조건
WHERE 조건;
```

### SELF JOIN (자체 조인)
- 자기 자신과 조인
```
SELECT 컬럼명 FROM 테이블1 a
    INNER JOIN 테이블1 b ON 조인할 조건
WHERE 조건;
```

### UNION
`두 쿼리의 결과 값을 행(튜플, 레코드)으로 합치는 것`
- 두 쿼리의 열의 개수가 같아야 함
- 데이터 타입도 같거나 호환되는 형식이어야 함
- 참고
    - UNION을 사용하면 중복된 열은 제거됨
    - UNION ALL을 사용하면 중복된 열까지 조회
```
SELECT 쿼리문1 UNION SELECT 쿼리문2
```

---
# SQL 프로그래밍

<a href="./db_backup/10.SQL 프로그래밍 다루기.sql">SQL 프로그래밍</a>

### 스토어드 프로시저
`함수처럼 여러 개의 쿼리문의 동작을 절차로 묶어서 저장`
- 실행할 쿼리문 안에 등장하는 세미콜론(;)이 전체 구문의 종료로 인식되지 않게 변경
``` sql
DELIMITER //
	CREATE procedure func() -- 프로시저 이름()
		BEGIN
			-- 실행할 쿼리문들
		END //
DELIMITER ;

-- 실행
CALL func(); -- 프로시저 이름()

-- 삭제
DROP procedure IF EXISTS func; -- 프로시저 이름
```

---

# 제약조건
- 데이터의 무결성을 지키기 위해 제한된 조건
- 특정 데이터를 입력할 때 무조건적 입력이 아닌 조건이 만족이 되어야 입력할 수 있도록 제약할 수 있음

1. PRIMARY KEY
    - 기본식별자, 중복될 수 없음
    - NULL 값 입력될 수 없음
    - 고유한 값 식별
2. FOREIGN KEY
    - 테이블간의 관계를 정의
    - 다른 테이블의 기본 키와 관련됨
    - 외래키 관계를 설정하면 하나의 테이블이 다른 테이블에 의존하게 됨
    - 기준 테이블을 참조하여 데이터가 존재해야 입력 가능
3. UNIQUE (고유값)
    - 특정 열에 중복된 값을 허용하지 않음
    - 유일한 값을 입력해야 함
    - NULL값은 허용. NULL이 여러개 입력되는 것 허용
    - 대체키(AK : Alternate Key)라고도 부름
    - 이메일 주민번호 등
4. NOT NULL
    - NULL 값을 허용하지 않음
5. CHECK
    - 특정 열에 대한 조건을 정의
    - 유효성 검증에 사용
6. DEFAULT
    - 새로운 행이 삽입될 때 특정 열에 기본값을 설정

---

# INDEX
1. 인덱스를 생성하면 검색속도가 굉장히 빨라질 수 있다.
2. Primary Key, Unique 제약조건 설정한 열에 자동으로 인덱스 생성
3. 인덱스는 균형 트리 B-Tree(Balanced Tree) 데이터 구조를 갖는다.
4. 인덱스를 사용해야 할 경우
    - WHERE 절에서 자주 사용되는 열
    - JOIN에 자주 사용되는 열
    - 데이터 변경이 자주 일어나지 않는 열
    - 사용하지 않는 인덱스는 제거

- 클러스터형 인덱스
    - 검색 성능이 보조인덱스보다 좋다.
    - INSERT, UPDATE, DELETE를 많이 사용할 경우 느려짐
    - 테이블에 한 개만 생성 가능
- 보조 인덱스
    - 클러스터형 인덱스보다 검색 성능이 느리다.
    - 테이블에 여러개 생성 가능
    - 클러스터형 인덱스보다 DML 성능이 좋다.(INSERT, UPDATE, DELETE)
