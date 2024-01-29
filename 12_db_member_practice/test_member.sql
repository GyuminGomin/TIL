-- num(int) / id / pass / name / addr / phone / gender / age(int)
CREATE TABLE test_member(
	num INT PRIMARY KEY auto_increment,
	id VARCHAR(30) UNIQUE NOT NULL,
	pass VARCHAR(30) NOT NULL,
	name VARCHAR(50),
	addr TEXT,
	phone VARCHAR(20),
	gender VARCHAR(10),
	age int(3)
);

-- 관리자 계정 추가 - id : admin , pass - admin , name - MASTER
INSERT INTO test_member 
VALUES(null,'admin','admin','MASTER',
	   '부산광역시','01011111111','남성',30);
	   
SELECT * FROM test_member;

-- 회원정보 추가
INSERT INTO test_member
VALUES
(null, 'id003', 'pw003', '김', '부산', '01011111112', '남성', 30),
(null, 'id004', 'pw004', '김잉', '부산', '01011111113', '남성', 30),
(null, 'id005', 'pw005', '김항', '부산', '01011111114', '남성', 30),
(null, 'id006', 'pw006', '김홍', '부산', '01011111115', '남성', 30),
(null, 'id007', 'pw007', '김쟁', '부산', '01011111116', '남성', 30),
(null, 'id008', 'pw008', '김단', '부산', '01011111117', '남성', 30),
(null, 'id009', 'pw009', '김힘', '부산', '01011111118', '남성', 30),
(null, 'id010', 'pw010', '김기', '부산', '01011111119', '남성', 30),
(null, 'id011', 'pw011', '김대', '부산', '01011111120', '남성', 30),
(null, 'id012', 'pw012', '김대안', '부산', '01011111121', '남성', 30),
(null, 'id013', 'pw013', '김대수', '부산', '01011111122', '남성', 30),
(null, 'id014', 'pw014', '김대두', '부산', '01011111123', '남성', 30),
(null, 'id015', 'pw015', '김대네', '부산', '01011111124', '남성', 30),
(null, 'id016', 'pw016', '김대제', '부산', '01011111125', '남성', 30),
(null, 'id017', 'pw017', '김대등', '부산', '01011111126', '남성', 30),
(null, 'id018', 'pw018', '김대핰', '부산', '01011111127', '남성', 30),
(null, 'id019', 'pw019', '김대닠', '부산', '01011111128', '남성', 30),
(null, 'id020', 'pw020', '김대님', '부산', '01011111129', '남성', 30),
(null, 'id021', 'pw021', '김대하', '부산', '01011111130', '남성', 30),
(null, 'id022', 'pw022', '김대지', '부산', '01011111131', '남성', 30),
(null, 'id023', 'pw023', '김대대', '부산', '01011111132', '남성', 30),
(null, 'id024', 'pw024', '김대해', '부산', '01011111133', '남성', 30),
(null, 'id025', 'pw025', '김대햄', '부산', '01011111134', '남성', 30),
(null, 'id026', 'pw026', '김대댄', '부산', '01011111135', '남성', 30),
(null, 'id027', 'pw027', '김대대', '부산', '01011111136', '남성', 30),
(null, 'id028', 'pw028', '김대최', '부산', '01011111137', '남성', 30),
(null, 'id029', 'pw029', '김대채', '부산', '01011111138', '남성', 30),
(null, 'id030', 'pw030', '김대칠', '부산', '01011111139', '남성', 30),
(null, 'id031', 'pw031', '김대도', '부산', '01011111140', '남성', 30),
(null, 'id032', 'pw032', '김대챈', '부산', '01011111141', '남성', 30),
(null, 'id033', 'pw033', '김대챟', '부산', '01011111142', '남성', 30),
(null, 'id034', 'pw034', '김대맨', '부산', '01011111143', '남성', 30),
(null, 'id035', 'pw035', '김조길', '부산', '01011111144', '남성', 30);

commit;

-- 회원 정보 검색
SELECT * FROM test_member WHERE name LIKE CONCAT('%','홍','%');

-- 공지형 게시판
CREATE TABLE IF NOT EXISTS notice_board (
	notice_num INT PRIMARY KEY AUTO_INCREMENT, 		-- 공지 글 번호
	notice_category VARCHAR(20) NOT NULL,			-- 공지 분류
	notice_author VARCHAR(50) NOT NULL,				-- 작성자
	notice_title VARCHAR(200) NOT NULL,				-- 제목
	notice_content TEXT NOT NULL,					-- 내용
	notice_date TIMESTAMP NOT NULL DEFAULT now()	-- 작성 시간
);

-- 질문과 답변 - 자유 게시판 table
CREATE TABLE IF NOT EXISTS qna_board (
	qna_num INT PRIMARY KEY AUTO_INCREMENT,			-- 글번호
	qna_name VARCHAR(20) NOT NULL,					-- 작성자
	qna_title VARCHAR(200) NOT NULL,				-- 글 제목
	qna_content TEXT NOT NULL,						-- 글 내용
	qna_writer_num INT NOT NULL,					-- 글 작성자 회원 번호
	qna_readcount INT DEFAULT 0,					-- 조회수
	qna_date TIMESTAMP DEFAULT now()				-- 글 작성 시간
);

-- 조회수 증가
UPDATE qna_board SET qna_readcount = qna_readcount + 1 WHERE qna_num = 1;

commit;

INSERT INTO qna_board (qna_name, qna_title, qna_content, qna_writer_num) SELECT qna_name, qna_title, qna_content, qna_writer_num FROM qna_board; -- 샘플 데이터 삽입

-- 원본글(질문글)일 경우 자신의 게시글 번호를 저장
-- 답변글일 경우 자신이 답변하는 원본글의 번호를 저장
-- 동일한 그룹 번호일 경우 묶어서 출력
ALTER TABLE qna_board ADD COLUMN qna_re_ref INT NOT NULL DEFAULT 0 AFTER qna_content;

-- 기존에 등록된 행정보에 자기 글 번호로 qna_re_ref 컬럼 수정
UPDATE qna_board SET qna_re_ref = qna_num;

SELECT * FROM qna_board ORDER BY qna_re_ref DESC;

INSERT INTO qna_board VALUES(null, '김홍', '44번의 답변글','없음',44,99,0,now());

-- view 화면에서 출력될 답변 글의 깊이
ALTER TABLE qna_board ADD COLUMN qna_re_lev INT NOT NULL DEFAULT 0 AFTER qna_re_ref;

-- 원본글과 답변글 끼리의 정렬 순서 기준
ALTER TABLE qna_board ADD COLUMN qna_re_seq INT NOT NULL DEFAULT 0 AFTER qna_re_lev;

UPDATE qna_board SET qna_re_lev = qna_re_lev + 1, qna_re_seq = qna_re_seq + 1  WHERE qna_num = 60;

SELECT * FROM qna_board ORDER BY qna_re_ref DESC, qna_re_seq ASC;

INSERT INTO qna_board(qna_name, qna_title, qna_content, qna_writer_num) VALUES('김항', '첫질문', '첫질문이담', 90);

-- 동일한 트랜잭션 내에서만 적용됨 (내가 INSERT한 ID 값만 가져온다) (MYSQL에만 있다)
SELECT LAST_INSERT_ID();

rollback;