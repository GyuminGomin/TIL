-- 변수 사용하기
-- SET @변수이름 = 변수값; -> 변수 선언
-- select @변수이름; -> 변수 확인

set @myVar1 = 10;
set @myVar2 = 5;
set @myVar3 = 3.14;
set @myVar4 = '이름->';

select @myVar1;
select @myVar2 + @myVar3;

use sqldb;
select @myVar4, name from usertbl;

select concat(@myVar4, "김규민");

-- 데이터 타입 변환 함수
-- CAST, CONVERT
select avg(amount) `평균구매개수` from buytbl;

-- 정수로 타입 변환 (signed 는 부호가 있는것, unsigned 는 부호가 없는것)
-- cast(표현식 as 데이터타입)
-- convert(표현식, 데이터타입)
select cast(avg(amount) as signed Integer) as 평균구매개수 from buytbl;
select convert(avg(amount), signed Integer) as 평균구매개수 from buytbl;

select cast('2023-12-13' as DATE);
select cast('2023.12.13' as DATE);
select cast('2023@12@13' as DATE);
select cast('2023$12$13' as DATE);

-- 숫자 데이터를 문자 데이터로 변환하여 연결한 예시
desc buytbl;
select price * amount from buytbl; -- price : int, amount : smallint
-- TEXT형태로 바꾸기
select concat(cast(price as char(10)), "*", cast(amount as char(10)), "=") `단가 x 수량`, price*amount from buytbl;

-- 암시적인 타입 변환
select '100' + '200'; -- 정수로 암시적 형변환되어 연산
select concat('100', '200'); -- 문자열 연결
select concat(100, '200'); -- 정수가 문자열로 암시적 형변환되어 연결
select 1 > '2mega'; -- 0은 false (문자열이 정수 2로 변환되어 비교)
select 3 > '2mega'; -- 1은 true (3 > 2)
select 0 = 'mega'; -- 문자열은 비교시 0으로 변환됨 (숫자가 아무것도 없을 시)

-- 내장함수
-- 제어 흐름 함수
-- if(수식, 참일때, 거짓일때)
select if(100>200, '참', '거짓');
select if(100<200, '참', '거짓');

-- ifnull(수식1, 수식2) : 수식1이 null이 아니면 -> 수식1, 수식1이 null이면 -> 수식2 return
select ifnull(null, '널입니다');
select ifnull('널이아닙니다.', '널입니다');

-- nullif(수식1, 수식2) -> 두 수식이 같으면 null, 다르면 수식1
select nullif(100, 100);
select nullif(100, 200);

-- case 문 ~ when ~ then
select case 10
	when 1 then '일'
    when 10 then '십'
    else '모르는 수'
end as "case";