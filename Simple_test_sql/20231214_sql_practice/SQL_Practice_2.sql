use cloud_digital;

-- 51. 사원들의 이름, 직무를 첫 자만 대문자로 검색하라
select concat(upper(substr(ename, 1, 1)), lower(substr(ename,2))) '이름',
 concat(upper(substr(job, 1, 1)), lower(substr(job,2))) '직무' from emp;
-- 52. 사원들의 이름, 직무를 연결하여 검색하라
select concat(ename, " " ,job) from emp;
-- 53. 사원들의 이름과 이름의 첫 2자를 검색하라
select ename, substr(ename, 1,2) from emp;
-- 54. 사원들의 이름, 직무 그리고 직무의 2번째부터 3자리를 검색하라
select ename, job, substr(job, 2,3) from emp;
-- 55. 사원들의 이름과 이름의 길이를 검색하라
select ename, length(ename) from emp;
-- 56. 사원들의 직무와 직무의 자리수를 검색하라
select job, length(job) from emp;
-- 57. 사원들의 이름에 'A'가 몇 번째 있는지 검색하라
select instr(ename, 'A'), ename from emp; -- 없으면 0, 있으면 위치
-- 58. 사원들의 직무에 'A'가 몇 번째 있는지 검색하라
select instr(job, 'A') from emp;
-- 59. 사원의 이름을 15자리로 하고, 뒤에 '&'를 채워 검색하라
select rpad(ename, 15, '&'), length(rpad(ename, 15, '&')) from emp;
-- 60. 사원의 직무를 20자리로 하고, 앞에 '%'를 채워 검색하라
select lpad(job, 20, '%') from emp;
-- 61. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리에서 반올림함)
select empno, ename, round(sal, -2) from emp; -- 정수 2번째 자리에서 반올림
-- 62. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리까지만 표시함)
select empno, ename, truncate(sal, -2) from emp; -- 정수 2번째 자리에서 버림
-- 63. 사원번호와 급여를 100으로 나눈 나머지를 검색하라
select empno, mod(sal, 100) from emp; -- sal을 100으로 나눈 나머지
-- 64. 사원번호, 이름과 입사일자, 입사일자 100일 후의 일자를 구하라
select empno, ename, hiredate, date_add(hiredate, interval 100 day) from emp;
-- 65. 사원번호, 이름, 입사일자 그리고 근무 일자를 계산하여 구하라
select empno, ename, hiredate, datediff(now(), hiredate) from emp; -- 두 일자 차이
-- 66. 사원들의 입사일자에 3달째 되는 일자를 구하라
select date_add(hiredate, interval 3 month) from emp;
-- 67. 사원들의 입사일자 다음 토요일의 일자를 구하라
select 
case dayofweek(hiredate)
	when 1 then date_add(hiredate, interval 6 day)
    when 2 then date_add(hiredate, interval 5 day)
    when 3 then date_add(hiredate, interval 4 day)
    when 4 then date_add(hiredate, interval 3 day)
    when 5 then date_add(hiredate, interval 2 day)
    when 6 then date_add(hiredate, interval 1 day)
    else hiredate
end as '입사일자 다음 토요일'
from emp; -- 1 = sunday, 7 = saturday
-- 68. 사원들의 입사월의 마지막 날짜를 구하라
select last_day(hiredate) from emp; -- last_day : 월 별 마지막 날짜 구하기
-- 69. 사원들의 입사일자를 년을 기준으로 반올림하여 구하라
select (round(hiredate, 'YEAR') from emp; -- oracle에서만 사용 가능
select date(concat(year(hiredate)+1, '-01-01')) from emp;
select if (dayofyear(hiredate) >= 183, date(concat(year(hiredate) + 1, '-01-01')), date(concat(year(hiredate), '-01-01'))) from emp;
-- 70. 사원들의 입사일자를 년을 기준으로 절사하여 구하라
select truncate(hiredate, 'YEAR') from emp; -- oracle에서만 사용 가능
select date(concat(year(hiredate), '-01-01')) from emp;
-- 71. 매니저 없는 사원의 경우 '상급자 없음'을 나타내도록 하는 질의문을 작성하시오
select if (mgr is null, '상급자 없음', mgr) from emp;
select ifnull(mgr, '상급자 없음') from emp;
-- 72. 커미션이 포함한 급여를 사원번호, 이름과 함께 구하라
select empno, ename, sal+comm from emp; -- null이 함께 계산되면 null이 되므로
select empno, ename, sal + ifnull(comm, 0) from emp;
-- 73. 커미션을 포함한 연봉(급여x12)을 사원번호, 이름과 함께 구하라
select empno, ename, sal*12 + ifnull(comm, 0) from emp;
-- 74. 매니저가 NULL인 경우 'CEO'로 바꾸어 사원번호, 이름, 매니저를 구하라
select empno, ename, ifnull(mgr, 'CEO') from emp;
-- 75. 10, 20번 부서 사원들 중 최고 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
select empno, ename, sal from emp where sal IN (select max(sal) from emp where deptno IN (10, 20));
-- 76. 30번 부서의 사원 중 최저 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
select empno, ename, sal from emp where sal IN (select min(sal) from emp where deptno IN (30));
-- 77. 전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp where comm IN (select max(comm) from emp);
-- 78. 전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp where comm IN (select min(comm) from emp); -- comm 이 null인 경우 0으로 생각
select empno, ename, comm from emp where comm IN (select min(comm) from emp) or comm is null;
-- 79. 전체 사원의 이름 중 최고값과 최저값을 검색하라
select max(ename), min(ename) from emp;
-- 80. 전체 사원의 입사일자 중 최고값과 최저값을 검색하라
select max(hiredate), min(hiredate) from emp;
-- 81. 사원번호의 최고값과 최소값을 검색하라
select max(empno), min(empno) from emp;
-- 82. 매니저 컬럼의 데이터 개수를 검색하라
select count(mgr) from emp;
-- 83. 이름의 개수를 검색하라
select count(ename) from emp;
-- 84. 사원테이블의 튜플 수를 검색하라
select count(*) from information_schema.columns where table_name='emp'; -- 튜플 수 검색
-- 85. 부서 테이블의 튜플 수를 검색하라
select count(*) from information_schema.columns where table_name='dept';
-- 86. 커미션의 개수를 검색하라
select count(comm) from emp;
-- 87. 부서별 사원들의 인원수를 검색하라
select deptno, count(empno) from emp group by deptno;
-- 88. 매니저별 사원들의 인원수를 검색하라
select mgr, count(empno) from emp group by mgr;
-- 89. 부서별 사원들의 평균 급여를 검색하라
select deptno, avg(sal) from emp group by deptno;
-- 90. 부서별 사원들의 급여의 표준편차를 검색하라
select deptno, std(sal) from emp group by deptno;
-- 91. 부서별 직무별 사원의 급여 합을 검색하라
select deptno, job, sum(sal) from emp group by deptno, job order by deptno;
-- 92. 부서별 직무별 사원들의 평균 급여를 검색하라
select deptno, job, avg(sal), count(empno) from emp group by deptno, job order by deptno;
-- 93. 부서별 직무별 사원들의 입사일자의 최고값과 최저값을 검색하라
select deptno, job, max(hiredate), min(hiredate), count(empno) from emp group by deptno, job order by deptno; 
-- 94. 부서별 사원들의 인원수를 인원수가 많은 순으로 검색하라
select deptno, count(empno) from emp group by deptno order by count(empno) DESC;
-- 95. 부서별 사원들의 평균 급여를 평균 급여 순으로 검색하라
select deptno, avg(sal) from emp group by deptno order by avg(sal);
-- 96. 부서별 직무별 사원의 급여 합을 많은 순으로 검색하라
select deptno, job, sum(sal) from emp group by deptno, job order by deptno, sum(sal) DESC;
-- 97. 부서별 직무별 사원들의 평균 급여를 평균 급여가 많은 순으로 검색하라
select deptno, job, avg(sal) from emp group by deptno, job order by deptno, avg(sal) DESC;
-- 98. 사원번호, 이름, 부서명을 검색하라
select a.empno, a.ename, b.dname from emp a join dept b on a.deptno = b.deptno;
-- 99. 부서지역이 NEW YORK인 사원의 이름을 검색하라
select a.ename, b.loc from emp a join dept b on a.deptno = b.deptno where b.loc IN ('NEW YORK');
-- 100. ADAMS 사원이 근무 중인 부서명과 지역을 검색하라
select a.ename, b.dname, b.loc from emp a join dept b on a.deptno = b.deptno where a.ename IN ('ADAMS');
-- 101. 급여가 2000 이상인 사원들의 사원명과 지역을 검색하라
select a.ename, b.loc, a.sal from emp a join dept b on a.deptno = b.deptno where a.sal >= 2000;
-- 102. 직무가 SALESMAN이면서 CHICAGO에 근무 중인 사원명을 검색하라
select a.ename, a.job, b.loc from emp a join dept b on a.deptno = b.deptno where a.job IN ('SALESMAN') and b.loc IN ('CHICAGO');
-- 103. NEW YORK과 DALLAS에 근무하는 사원들의 사번과 이름을 사원번호순으로 검색하라
select a.empno, a.ename, b.loc from emp a join dept b on a.deptno = b.deptno where b.loc IN ('NEW YORK', 'DALLAS');
-- 104. 부서명이 ACCOUNTING 이거나, 지역이 CHICAGO인 사원의 사원번호와 이름을 검색하라
select a.empno, a.ename, b.dname, b.loc from emp a join dept b on a.deptno = b.deptno where b.dname IN ('ACCOUNTING') or b.loc IN ('CHICAGO');
-- 105. 사원번호, 이름, 급여, 급여등급을 검색하라
select a.empno, a.ename, a.sal, (select b.grade from salgrade b where a.sal between b.losal and b.hisal) from emp a; -- null 계산 따로 해줘야 할까?
select a.empno, a.ename, a.sal, ifnull((select b.grade from salgrade b where a.sal between b.losal and b.hisal), 0) from emp a;
-- 106. 각 사원의 사원번호와 이름, 매니저 사원번호와 이름을 검색하라
select a.*, b.* from emp a join emp b on a.mgr = b.empno order by a.mgr; -- 이때 a는 사원, b는 관리자
select a.*, b.* from emp a join emp b on a.empno = b.mgr order by a.mgr; -- 이때 a는 관리자, b는 사원
select a.empno, a.ename, a.mgr, b.ename from emp a join emp b on a.mgr = b.empno;
-- 107. BLAKE 사원보다 많은 급여를 받는 사원의 이름을 검색하라
select a.ename from emp a where a.sal > (select b.sal from emp b where b.ename IN ('BLAKE'));
-- 108. FORD 사원과 같은 부서에 근무하는 사원의 이름을 검색하라
select a.ename from emp a where a.deptno IN (select b.deptno from emp b where b.ename IN ('FORD')); -- FORD는 빼줘야 함, mysql은 minus와 intersect 연산자가 없음
select a.ename from emp a where a.deptno IN (select b.deptno from emp b where b.ename IN ('FORD')) and a.ename not in ('FORD');
-- 109. FORD 사원과 같은 급여를 받는 사원의 사원번호를 검색하라
select a.empno from emp a where a.sal IN (select b.sal from emp b where b.ename IN ('FORD')); -- FORD는 빼줘야 함
select a.empno from emp a where a.sal IN (select b.sal from emp b where b.ename IN ('FORD')) and a.ename not in ('FORD');
-- 110. 부서별 인원수를 부서명과 함께 검색하라
select count(a.empno), b.dname from emp a join dept b on a.deptno = b.deptno group by a.deptno;
-- 111. 부서명이 'SALES'이면서 직무가 'MANAGER'인 사원의 사원번호, 이름을 이름순으로 검색하라
select a.empno, a.ename, b.dname, a.job from emp a join dept b on a.deptno = b.deptno where b.dname IN ('SALES') and a.job IN ('MANAGER') order by a.ename;
-- 112. SCOTT 사원보다 많은 급여를 받는 사원 정보를 검색하라
select * from emp a where a.sal > (select b.sal from emp b where b.ename IN ('SCOTT'));
-- 113. ALLEN 사원보다 적은 급여를 받는 사원 정보를 검색하라
select * from emp a where a.sal < (select b.sal from emp b where b.ename IN ('ALLEN'));
-- 114. 20번 부서 사원의 직무와 같은 직무를 하고 있는 다른 부서의 사원 정보를 검색하라
select distinct(job) from emp where deptno = 20; -- 20번 부서의 직무 정보
select * from emp a where a.job not in (select b.job from emp b where b.deptno = 20);
-- 115. 전체 사원의 평균 급여보다 급여가 많은 사원 정보를 검색하라
select avg(sal) from emp; -- 전체 사원의 평균 급여
select * from emp a where a.sal > (select avg(b.sal) from emp b);
-- 116. 급여가 모든 부서들의 평균 급여보다 많은 사원 정보를 검색하라
select deptno, avg(sal) from emp group by deptno; -- 부서마다의 평균 급여, 집계함수의 중첩은 불가능
select deptno, avg(sal), sum(sal) from emp group by deptno with rollup; -- 마지막 열에 전체 합계 / 전체 행 갯수
select * from emp a where sal > ALL (select avg(sal) from emp group by deptno);
-- 117. 20번 부서의 최대 급여보다 최대 급여가 큰 부서의 번호와, 최대 급여를 검색하라
select a.deptno, max(a.sal) from emp a where a.sal > (select max(b.sal) from emp b where b.deptno = 20 group by b.deptno) group by a.deptno;
-- 118. CHICAGO에 위치하는 부서에 근무하는 사원 정보를 검색하라(서브쿼리 이용)
select * from emp a where a.deptno IN (select b.deptno from dept b where b.loc = 'CHICAGO');