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
## mysql 설정
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

## sql 문 간단하게 확인 후, Host Os에서 접속 가능하게 설정
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

## SQL 명령어의 범주

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

## MySQL의 데이터 타입

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