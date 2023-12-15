# java와 db 연동

1. https://dev.mysql.com/downloads/ 에서 Connector/J 선택
2. Platform Independent > ZIP 파일 다운 
3. 압축을 C:/Program Files/mysql 폴더에 해제
4. 다운로드 받은 파일을 보면 mysql-connector-j-버전.jar 파일이 존재함
    - 이 파일을 현재 자바 프로젝트의 Configure Classpath로 설정
        - .vscode/settings.json 파일에 라이브러리 탑재 완료

# 실습하기 위한 db 설정
- mysql 쿼리 실행
    - user > root
    - password > 1234
    - hostname > localhost:3306

``` sql
CREATE SCHEMA sqldb;

CREATE TABLE usertbl
( userID	CHAR(8)		NOT NULL PRIMARY KEY, -- 사용자 아이디
  name		VARCHAR(10) NOT NULL,  -- 이름
  birthYear INT 		NOT NULL,  -- 생년
  addr		CHAR(2)		NOT NULL,  -- 주소
  mobile1	CHAR(3),  -- 국번 010
  mobile2	CHAR(8),  -- 국번제외 전화번호
  height	SMALLINT, -- 키
  mDate		DATE      -- 회원가입일
);

CREATE TABLE buytbl
( num    	 INT 	 AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번
  userID 	 CHAR(8) NOT NULL,  -- 회원ID
  prodName	 CHAR(6) NOT NULL,  -- 상품명
  groupName  CHAR(4),  -- 분류
  price		 INT NOT NULL,  -- 가격
  amount     SMALLINT NOT NULL,   -- 수량
  FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
```


