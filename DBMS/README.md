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
