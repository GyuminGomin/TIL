use develop_jsp;

show tables;

CREATE TABLE IF NOT EXISTS member (
	num INT PRIMARY KEY auto_increment,
    name VARCHAR(50),
    addr VARCHAR(300)
);

/*
	INSERT	SELECT	UPDATE	DELETE
	Create	Read	Update	Delete
*/
-- table에 값 삽입 - INSERT
-- num, name, addr
insert into member values(null, '홍길동', '한양');
insert into member(name,addr) values('김유신','김해');

select * from member;

commit;