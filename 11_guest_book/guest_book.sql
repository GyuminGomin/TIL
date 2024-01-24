show tables;

CREATE TABLE IF NOT EXISTS test_guestbook(
	num INT PRIMARY KEY auto_increment,	-- 방명록 글 번호
	guestName VARCHAR(20) NOT NULL,		-- 방명록 작성자
	password VARCHAR(30) NOT NULL,		-- 방명록 비밀번호
	message TEXT						-- 방명록 코멘트
);

DESC test_guestbook;

SELECT * FROM test_guestbook;

INSERT INTO test_guestbook(guestName, password, message) SELECT guestName, password, message FROM test_guestbook;

-- 1page, 한번에 게시물을 10개씩 출력 -- 1번째 인덱스부터 10개
SELECT * FROM test_guestbook ORDER BY num DESC limit 0, 10; 

-- 2page, 한번에 게시물을 10개씩 출력 -- 11번째 인덱스부터 10개
SELECT * FROM test_guestbook ORDER BY num DESC limit 10, 10;

SELECT count(num) FROM test_guestbook;