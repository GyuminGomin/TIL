SELECT * FROM shopdb.membertbl;
-- 테이블 생성하기
Create table `shopdb`.`productTBL` (
	productName CHAR(4) NOT NULL,
    cost INT NOT NULL,
    makeDate DATE NULL,
    company CHAR(5) NULL,
    amount INT NOT NULL,
    primary key(productName)
);

Create table `shopdb`.`membertbl` (
	memberId CHAR(4) NOT NULL,
    memberName CHAR(4) NOT NULL,
    memberAddress CHAR(20) NULL,
    primary key(memberId)
);

Create table `shopdb`.`indextbl` (
	first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    hird_date DATE NOT NULL
);