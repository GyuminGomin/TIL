-- 영화 데이터베이스 만들기
create database movieDB;

use movieDB;

create table movieTBL (
	movie_id int,
    movie_title varchar(30),
    movie_director varchar(20),
    movie_star varchar(20),
    movie_script longtext, -- 최대 4GB의 TEXT 데이터
    movie_film longblob -- 최대 4GB의 이진 데이터
) default charset=utf8mb4; -- 한글 깨짐 문제 발생하지 않음, mb4 - 캐릭터 이모티콘같은 것 안 깨지게

insert into movieTBL values (1, '쉰들러리스트', '스필버그', '리암 니슨', load_file('/var/lib/mysql-files/Schindler.txt'), load_file('/var/lib/mysql-files/Schindler.mp4'));
insert into movieTBL values (2, '쇼생크탈출', '프랭크 다라본트', '팀 로빈스', load_file('/var/lib/mysql-files/Shawshank.txt'), load_file('/var/lib/mysql-files/Shawshank.mp4'));
insert into movieTBL values (3, '라스트모히칸', '마이클 만', '다니엘', load_file('/var/lib/mysql-files/Mohican.txt'), load_file('/var/lib/mysql-files/Mohican.mp4'));

select * from movieTBL;

-- 파일 내보내기
select movie_script from movieTBL where movie_id=2
	into outfile '/var/lib/mysql-files/out.txt'
    lines terminated by '\\n'; -- 줄바꿈이 나올 때마다 끊어줘라

-- 영상 내보내기
select movie_film from movieTBL where movie_id=3
	into dumpfile '/var/lib/mysql-files/out.mp4';
    
-- 영화 데이터 삽입 : longtext, longblob이 삽입되지 않을 때, 시스템 변수 확인하기
show variables;
select @@max_allowed_packet; -- 최대 허용 패킷 크기
select @@secure_file_priv; -- 허용된 경로 위치 (현재 mysql은 리눅스에 있고 /var/lib/mysql-files 가 허용된 경로)