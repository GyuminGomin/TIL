-- 서브쿼리를 사용해 다른 db의 데이터 가져오기
insert into indextbl
	select first_name, last_name, hire_date
    from employees.employees
    limit 500;
select * from indextbl;
select * from indextbl where first_name = 'Mary';

-- 인덱스 생성
create index idx_indextbl_firstname on indextbl(first_name);

-- 뷰
create view uv_memberTBL
as select memberName, memberAddress from membertbl;

select * from uv_membertbl;

-- stored procedure (스토어드 프로시저) 여러가지 sql문을 실행하게 해주는 함수 같은 것

-- 구분문자를 ;에서 //로 대신함
DELIMITER // 
create procedure myproc() -- 프로시저 생성
	begin
		select * from membertbl where memberName = '지운이';
		select * from producttbl where productName = '냉장고';
	end //
DELIMITER ;
-- 구분문자 원상복귀

call myproc(); -- 프로시저 호출

-- 탈퇴회원 테이블 만들기
CREATE TABLE `deletedmembertbl` (
  `memberId` char(8) NOT NULL,
  `memberName` char(5) NOT NULL,
  `memberAddress` char(20) DEFAULT NULL,
  deletedDate Date
);
select * from deletedmembertbl;

-- 트리거 생성
DELIMITER //
create trigger trg_deletedMemberTbl
	after delete on membertbl -- 멤버 테이블에서 삭제가 될 때 작동
    for each row -- 모든 행에 대하여 적용
begin
	-- 이전 테이블 내용을 탈퇴회원테이블(백업)에 삽입
	insert into deletedMemberTbl
		values (OLD.memberId, OLD.memberName, OLD.memberAddress, CURDATE());
end //
DELIMITER ;

-- 회원 탈퇴
select * from membertbl;
delete from membertbl where memberName = '상달이';
select * from deletedmembertbl;

select * from producttbl;
delete from producttbl; -- import 하면 다시 삭제된 db가 다시 되돌아온다 (백업 폴더에 있는 shopdb.sql)