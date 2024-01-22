use develop_jsp;

show tables;

CREATE TABLE IF NOT EXISTS member (
	num INT PRIMARY KEY auto_increment,
    name VARCHAR(50),
    addr VARCHAR(300)
);