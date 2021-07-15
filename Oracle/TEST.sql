CREATE TABLE USERLIST(
	userId			NUMBER(3),
	userName		VARCHAR2(20)	NOT NULL,
	hireDate		DATE	DEFAULT sysdate,
	userEmail		VARCHAR2(20),
	birthDay		VARCHAR2(10)	NOT NULL,
	PRIMARY KEY(userId)
)

DROP TABLE USERLIST

select max(rownum) from USERLIST

select * from USERLIST

insert INTO USERLIST(userId,userName,userEmail,birthDay) VALUES (1,'오세황','osh0325@naver.com','19980325')

VALUES

COMMIT

SELECT * FROM USERLIST where userName = '오세황' and substr(birthDay, 3,6) = '980325'

SELECT substr(birthDay, 3,5) FROM USERLIST

CREATE TABLE BOARDLIST(
	boardId			NUMBER(4),
	boardTitle		VARCHAR2(50)	NOT NULL,
	boardWriter		VARCHAR2(20)	NOT NULL,
	boardCreateDate		DATE	DEFAULT sysdate,
	boardViewCount		number(4)	DEFAULT 0,
	boardLike				NUMBER(3) DEFAULT 0,
	boardSubject		VARCHAR2(3000),
	PRIMARY KEY(boardId)
)

DROP TABLE BOARDLIST

SELECT * FROM  BOARDLIST

insert into BOARDLIST(boardId,boardTitle,boardWriter,boardSubject) VALUES (1,'Title1','오세황','subject1'); commit;
