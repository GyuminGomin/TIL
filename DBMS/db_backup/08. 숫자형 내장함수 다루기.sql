-- 숫자 내장함수

-- ABS(숫자) : 절대값
SELECT abs(-30);

-- CEILING(숫자) : 올림
SELECT ceil(4.3);

-- FLOOR(숫자) : 내림
SELECT floor(4.3);

-- ROUND(숫자) : 반올림
SELECT round(4.3);

-- CONV(숫자, 원래진수, 변환진수) : 진수변환
SELECT conv('FE', 16, 10); -- 16진수 FE를 10진수로 변환
SELECT conv('11111111', 2, 8); -- 2진수를 8진수로 변환

-- PI() : 원주율
SELECT PI();

-- MOD(숫자, 나눌 수) : 나머지 구하기
SELECT mod(157, 10), 157 % 10, 157 mod 10;

-- POW(숫자1, 제곱) : 제곱수 구하기
SELECT pow(2, 8);

-- SQRT(숫자) : 제곱근 구하기
SELECT sqrt(16);

-- RAND() : 랜덤한 숫자 구하기 (0~1 미만의 실수)
SELECT rand(), ceil(rand()*45), floor(rand()*6)+1;

-- 날짜 및 시간 함수

-- ADDDATE(날짜, 차이) : 날짜 더하기
SELECT adddate('2023-12-20', interval 31 day);
SELECT adddate('2023-12-20', interval 2 month);

-- SUBDATE(날짜, 차이) : 날짜 빼기
SELECT subdate('2023-12-20', interval 31 day);
SELECT subdate('2023-12-20', interval 2 month);

-- ADDTIME(날짜, 시간) : 시간 더하기
-- SUBTIME(날짜, 시간) : 시간 빼기
SELECT addtime('2023-12-20 10:32:00', '1:1:1');
SELECT subtime('2023-12-20 10:32:00', '1:1:1');
SELECT addtime('10:32:00', '5:15:30');
SELECT subtime('10:32:00', '5:15:30');

-- 현재 시각 구하기
SELECT now(), localtime(), localtimestamp(), current_timestamp(), sysdate(); -- 동일한 현재 날짜/시각 구하기
SELECT curdate(), current_date(), current_date; -- 동일한 현재 날짜 구하기
SELECT curtime(), current_time(), current_time; -- 동일한 현재 시각 구하기

-- 현재시간에서 연, 월, 일, 시, 분, 초, 마이크로초 구하기
SELECT year(now()), month(now()), day(now()), hour(now()), minute(now()), second(now()), microsecond(now());

-- 현재시간에서 날짜, 시간 추출하기
SELECT date(now()), time(now());

-- DATEDIFF(날짜1, 날짜2) : 날짜 차이 구하기
-- TIMEDIFF(날짜1, 날짜2) : 시간 차이 구하기
SELECT datediff('2024-03-18', now());
SELECT timediff('2023-12-20 16:30:00', now());

-- DAYOFWEEK(날짜) : 요일 구하기 (1: sunday ~ 7 : saturday)
SELECT dayofweek(now());

-- LAST_DAY(날짜) : 마지막 날 구하기
SELECT last_day('2024-02-01');

-- MAKETIME(시, 분, 초) : 시간형식 만들기
SELECT maketime(10, 48, 00);

-- QUARTER(날짜) : 분기 구하기 (1~3월 1분기, 4~6월 2분기, 7~9월 3분기, 10~12월 4분기)
SELECT quarter(now());

