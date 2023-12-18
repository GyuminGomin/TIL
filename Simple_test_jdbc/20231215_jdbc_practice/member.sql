CREATE TABLE tbl_member(
	mNum INT PRIMARY KEY auto_increment,
	mName VARCHAR(50),
	mId VARCHAR(20) NOT NULL UNIQUE,
	mPw VARCHAR(30) NOT NULL,
	reg BIGINT DEFAULT 0
);

INSERT INTO tbl_member(mName,mId,mPw)
VALUES('관리자','root','root');

SELECT * FROM tbl_member;

commit;

-- 삭제한 멤버 테이블 (탈퇴한 회원의 정보를 임시 저장할 back_up_table 생성)
CREATE TABLE tbl_member_deleted LIKE tbl_member; -- 구조만 일치하는 테이블 생성 가능

DESC tbl_member_deleted;

-- 회원 탈퇴 시간에 대한 정보 추가
ALTER TABLE tbl_member_deleted ADD COLUMN deleteDate TIMESTAMP DEFAULT now();

commit;

-- mId : root' --
-- mPw : 'sdfasfcvioawefa(아무거나)'

SELECT * FROM tbl_member WHERE mId = 'root' -- ' AND mPw : 'sdfasfcvioawefa(아무거나)';

/*
SQL Injection
사용자가 입력할 수 있는 영역을 활용해서
개발자가 의도하지 않은 SQL문을 삽입하여 공격하는 방법 (Prepared Statement를 사용하면 해결 가능)
*/
-- PREPARE EXECUTE
PREPARE
  mQuery
FROM 'SELECT * FROM tbl_member WHERE mID = ? AND mPw = ?';

SET @mId = 'root';
SET @password = 'root';

EXECUTE mQuery USING @mId, @password;