-- 문자열 함수

-- ASCII : 아스키 코드 리턴
SELECT ASCII('A');
-- CHAR : 아스키 코드를 문자열로 리턴
SELECT CHAR(65);

-- LENGTH : 문자열의 길이
SELECT length('ABC');
SELECT length('가나다'); -- UTF-8 인코딩에 의해 한글은 3Byte로 인식
SELECT char_length('가나다'); -- 문자열 길이 갯수만큼
SELECT bit_length('가나다'); -- 9Byte = 72Bit

-- CONCAT(문자열1, 문자열2) : 문자열 이어주기
SELECT concat('가나다','라마바');
-- CONCAT_WS(구분자, 문자열1, 문자열2, ...) : 구분자로 문자 이어주기
SELECT concat_ws('+','가나다','라마바','아자차');


-- ELT(위치, 문자열1, 문자열2) : 해당 위치의 문자열 찾기
SELECT elt(3, '하나','둘','셋');
-- FIELD(찾을 문자열, 문자열1, 문자열2, ...) : 해당 문자열이 같은 문자열 위치 찾기
SELECT field('셋','하나','둘','셋');
-- FIND_IN_SET(찾을 문자열, 문자열목록) : 이어진 문자에서 구분자를 찾아 몇번째에 위치하는지 리턴
SELECT find_in_set('둘','하나,둘,셋');
-- INSTR(기준 문자열, 부분 문자열) : 기준 문자열에서 부분 문자열의 위치를 반환
-- LOCATE(부분 문자열, 기준 문자열) : INSTR과 완전동일한 매개변수 위치만 다른 것
SELECT instr('하나둘셋', '둘');
SELECT locate('셋', '하나둘셋');

-- FORMAT(숫자, 소수점 자리수) : 몇번째 자리까지 리턴을 하겠냐는 것 (천단위로 끊어줌)
SELECT FORMAT(1234567.1234567, 2);

-- LEFT(문자열, 길이) : 왼쪽에서부터 문자열 길이만큼 반환
-- RIGHT(문자열, 길이) : 오른쪽에서부터 문자열 길이만큼 반환
SELECT LEFT('가나다라마바사', 3);
SELECT RIGHT('가나다라마바사', 3);

-- UPPER(문자열) : 대문자로 변경
-- LOWER(문자열) : 소문자로 변경
SELECT upper('hello, world!');
SELECT lower('HELLO, WORLD!');

-- 문자열 채우기
-- LPAD(문자열, 길이, 채울문자열)
SELECT lpad('홍길동',5,'#');
SELECT rpad('홍길동',5,'#');

-- 공백 제거하기
-- LTRIM(문자열)
SELECT ltrim('   BTS   ');
SELECT rtrim('   BTS   ');

-- REPEAT(문자열, 반복횟수) : 문자열 반복하기
SELECT repeat('#',10);

-- REPLACE(문자열, 변경할 문자열, 바꿀 문자열) : 문자열 변경하기
SELECT replace('SQL,MYSQL','SQL','에스큐엘');

-- REVERSE(문자열) : 문자열 뒤집기
SELECT reverse('BANANA');

-- SPACE(공백길이) : 공백길이 리턴
SELECT concat('BTS', space(14), 'BTS');

-- SUBSTRING(문자열, 시작위치, 길이) : 시작위치부터 길이만큼 문자 반환
SELECT substr('Hello World', 7, 5);
SELECT substring('Hello World', -7, 5); -- 음수 시작위치는 뒤에서부터 검색





