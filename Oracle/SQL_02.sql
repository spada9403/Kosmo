/*
drop sequence emp_sq;
drop sequence cus_sq;
drop table customer;
drop table salary_grade;
drop table employee;
drop table dept;
*/
/*
create table dept(
dep_no number(3) primary key,
dep_name varchar2(20)   not null unique,
loc varchar2(20)    not null
);
*/
CREATE TABLE dept (
       dep_no   NUMBER(3) ,
       dep_name VARCHAR2(20) NOT NULL
              UNIQUE,
              loc VARCHAR2(20) NOT NULL,
                     PRIMARY KEY(dep_no)
);

/*insert into 테이블명(컬럼명1, 컬럼명2, ~ 컬럼명n) values(입력데이터, 입력데이터, ~ 입력데이터n)
오라클에서 모든 문자데이터는 싱글 쿼터(') 로 감싼다.
자동으로 트랜잭션이 걸리므로 commit; 때려줘야한다.
*/
-- 4행 입력
INSERT
INTO   dept
       (
              dep_no,
              dep_name,
              loc
       )
       VALUES
       (
              10,
              '충무부',
              '서울'
       );

INSERT
INTO   dept
       (
              dep_no,
              dep_name,
              loc
       )
       VALUES
       (
              20,
              '영업부',
              '부산'
       );

INSERT
INTO   dept
       (
              dep_no,
              dep_name,
              loc
       )
       VALUES
       (
              30,
              '전산부',
              '대전'
       );

INSERT
INTO   dept
       (
              dep_no,
              dep_name,
              loc
       )
       VALUES
       (
              40,
              '자재부',
              '광주'
       );

-- dept 테이블의 모든 컬럼과 모든 행을 검색하기
SELECT *
FROM   dept; --WHERE dep_no=10; <-- dep_no=10 인 행만 검색.
-- employee 테이블에서 pk 값으로 사용할 시퀀스(sequence) 생성하기 (일련 번호 자동 생성기)
CREATE SEQUENCE emp_sq
       START WITH 1   -- 1부터 증가
       INCREMENT BY 1 -- 1씩 증가
       MINVALUE 1     -- 최소값 1
       MAXVALUE 999;  -- 최대값 999
-- 직원정보가 저장되는 테이블.
CREATE TABLE employee (
       emp_no    NUMBER(3) ,            --[직원번호]가 저장되는 컬럼 선언.
       emp_name  VARCHAR2(20) NOT NULL, --[직원명]이 저장되는 컬럼 선언.
       dep_no    NUMBER(3),             --[소속부서번호]가 저장되는 컬럼 선언.
       jikup     VARCHAR2(20) NOT NULL, --[직급]이 저장되는 컬럼 선언.
       salary    NUMBER(9) DEFAULT 0,   --[연봉]이 들어가는 컬럼 선언. 값을 안주면 디폴트 값 0.
       hire_date DATE DEFAULT SYSDATE,  -- 입사일 저장
       jumin_num CHAR(13) NOT NULL
              UNIQUE,                          --[주민번호]가 저장되는 컬럼 선언.
              phone_num  VARCHAR2(20) NOT NULL, --[전화번호]가 저장되는 컬럼 선언.
              mgr_emp_no NUMBER(3),             --[직속상관직원번호]가 저장되는 컬럼 선언.
                     PRIMARY KEY(emp_no),       --[직원번호] 칼람에  pk 제약조건
                     FOREIGN KEY(dep_no)
                            REFERENCES dept(dep_no), --[소속부서번호] 칼럼에 fk w제약조건 주기. dept 테이블에 dep_no컬럼 참조.
       CONSTRAINT employee_mgr_emp_no_fk FOREIGN KEY(mgr_emp_no)
              REFERENCES employee(emp_no)
              --[직속상관직원번호] 칼럼에 fk w제약조건 주기. employee 테이블에 emp_no 참조.
              --employee_mgr_emp_no_fk 는 제약 조건에 붙이는 이름이다.
);

-- alter 셀수정 커맨드를 이용해서 foreign key 끄기.(임시 무력화)
-- craete -> 객체생성 , alter -> 객체수정.
ALTER TABLE employee disable CONSTRAINT employee_mgr_emp_no_fk;

----------------------------------------------●날짜 데이터는 '년-월-일'  로 입력 가능하게 하기--------------------------------------------
ALTER session SET nls_date_format = 'yyyy-mm-dd' ;
INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '홍길동',
              10,
              '사장',
              5000,
              '1980-01-01',
              '7211271109410',
              '01099699515',
              NULL
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '한국남',
              20,
              '부장',
              3000,
              '1988-11-01',
              '6002061841224',
              '01024948424',
              1
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '이순신',
              20,
              '과장',
              3500,
              '1989-03-01',
              '6209172010520',
              '01026352672',
              2
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '이미라',
              30,
              '대리',
              2503,
              '1983-04-01',
              '8409282070226',
              '01094215694',
              17
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '이순라',
              20,
              '사원',
              1200,
              '1990-05-01',
              '8401041483626',
              '01028585900',
              3
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '공부만',
              30,
              '과장',
              4003,
              '1995-05-01',
              '8402121563616',
              '01191338328',
              17
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '놀기만',
              20,
              '과장',
              2300,
              '1996-06-01',
              '8011221713914',
              '01029463523',
              2
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '채송화',
              30,
              '대리',
              1703,
              '1992-06-01',
              '8105271014112',
              '01047111052',
              17
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '무궁화',
              10,
              '사원',
              1100,
              '1984-08-01',
              '8303291319116',
              '01025672300',
              12
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '공부해',
              30,
              '사원',
              1303,
              '1988-11-01',
              '8410031281312',
              '01027073174',
              4
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '류별나',
              20,
              '과장',
              1600,
              '1989-12-01',
              '8409181463545',
              '01071628290',
              2
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '류명한',
              10,
              '대리',
              1800,
              '1990-10-01',
              '8207211661117',
              '01042072622',
              20
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '무궁화',
              10,
              '부장',
              3000,
              '1996-11-01',
              '8603231183011',
              '01098110955',
              1
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '채시라',
              20,
              '사원',
              3400,
              '1993-10-01',
              '8001172065410',
              '01044452437',
              3
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '최진실',
              10,
              '사원',
              2000,
              '1991-04-01',
              '8303101932611',
              '01027491145',
              12
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '김유신',
              30,
              '사원',
              4000,
              '1981-04-01',
              '7912031009014',
              '01098218448',
              4
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '이성계',
              30,
              '부장',
              2803,
              '1984-05-01',
              '8102261713921',
              '0165358075',
              1
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '강감찬',
              30,
              '사원',
              1003,
              '1986-07-01',
              '8203121977315',
              '01033583130',
              4
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '임꺽정',
              20,
              '사원',
              2200,
              '1988-04-01',
              '8701301040111',
              '01086253078',
              7
       );

INSERT
INTO   employee VALUES
       (
              emp_sq.NEXTVAL,
              '깨똥이',
              10,
              '과장',
              4500,
              '1990-05-01',
              '8811232452719',
              '01090084876',
              13
       );

-- 모든 행을 지울때 사용.
--delete from employee;
SELECT *
FROM   employee;

-- alter 셀수정 커맨드를 이용해서 foreign key 켜기.(활성화)
ALTER TABLE employee enable CONSTRAINT employee_mgr_emp_no_fk;

-- customer 테이블에서 pk 값으로 사용할 시퀀스(sequence) 생성하기 (일련 번호 자동 생성기)
CREATE SEQUENCE cus_sq
       START WITH 1     -- 1부터 증가
       INCREMENT BY 1   -- 1씩 증가
       MINVALUE 1       -- 최소값 1
       MAXVALUE 100000; -- 최대값 100000 << cus_no 에 들어가는 숫자이다. cus_no의 NUMBER()자료형도 MAX값에 맞게 고쳐야 한다.
CREATE TABLE customer(
       cus_no    NUMBER(6),
       cus_name  VARCHAR2(10) NOT NULL,
       tel_num   VARCHAR2(15),
       jumin_num CHAR(13) NOT NULL
              UNIQUE,
              emp_no NUMBER(3),
                     PRIMARY KEY(cus_no),
                     FOREIGN KEY(emp_no)
                            REFERENCES employee(emp_no)
);

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '류민이',
              '123-1234',
              '7001131537915',
              3
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '이강민',
              '343-1454',
              '6902161627914',
              2
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '이영희',
              '144-1655',
              '7503202636215',
              NULL
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '김철이',
              '673-1674',
              '7704301234567',
              4
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '박류완',
              '123-1674',
              '7205211123675',
              3
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '서캔디',
              '673-1764',
              '6507252534566',
              NULL
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '신똘이',
              '176-7677',
              '0006083648614',
              7
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '도쇠돌',
              '673-6774',
              '0008041346574',
              9
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '권홍이',
              '767-1234',
              '7312251234689',
              13
       );

INSERT
INTO   customer VALUES
       (
              cus_sq.NEXTVAL,
              '김안나',
              '767-1677',
              '7510152432168',
              4
       );

SELECT *
FROM   CUSTOMER;

CREATE TABLE salary_grade(
       sal_grade_no NUMBER(1),
       min_salary   NUMBER(9) NOT NULL,
       max_salary   NUMBER(9) NOT NULL,
              PRIMARY KEY(sal_grade_no)
);

INSERT
INTO   salary_grade VALUES
       (
              1,8000,10000
       );

INSERT
INTO   salary_grade VALUES
       (
              2,6000,7999
       );

INSERT
INTO   salary_grade VALUES
       (
              3,4000,5999
       );

INSERT
INTO   salary_grade VALUES
       (
              4,2000,3999
       );

INSERT
INTO   salary_grade VALUES
       (
              5,1000,1999
       );

SELECT *
FROM   salary_grade;

-- 커밋 꼭 해라 안하면 데이터 입력 안된다 그렇다고 막하지는 마라 수정하지 않는 이상 복구 불가다.
COMMIT;
/*
오라클 4대 천왕
1. 오라클 함수
2. join
3. subquery
4. group by
*/
-- select
SELECT *
FROM   EMPLOYEE;

-- *를 쓰면 create구문에서 썻던 칼럼 순서대로 나온다. 순서를 바꾸고 싶다면 직접 써야한다
SELECT emp_no,
       emp_name,
       dep_no,
       jikup,
       salary,
       hire_date,
       jumin_num,
       phone_num,
       mgr_emp_no
FROM   employee;

-- 별칭(=alias) 알리아스 AS 생략가능 / 더블 쿼트 생략가능(공백이 없을때만 가능하다.)
SELECT emp_no AS "직원번호" ,
       emp_name
              ||'님' "직원명" ,
       jikup AS "직급" ,
       salary
              ||'만원' "연봉" -- <- salary 값 뒤에 만원이 붙어나감. 연결연산자로 + 사용불가능 || 사용할것 오라클에서는 +를 사칙연산외엔 사용되지 않는다.
       ,
       hire_date AS "입사일"
FROM   EMPLOYEE;

-- 싱글쿼터 ' 는 테이블안의 문자데이타 혹은 출력에 나올 문자데이터에만 쓴다. (오로지 문자데이터 에만 사용)
-- 더블쿼터 " 는 칼람명 테이블명 알리아스에만 쓴다. (명칭에만 사용한다.)
-- employee 테이블에서 직원명, 직급, 연봉, 세금, 실수령액을 검색하면? (세금은 연봉의 12%)
SELECT emp_name "직원명",
       jikup "직급",
       salary * 0.12
              ||'만원' "세금" ,
       salary * 0.88
              ||'만원' "실수령액"
FROM   EMPLOYEE;

--employee 테이블에서 직급을 중복 없이 검색하면?
SELECT DISTINCT jikup
FROM            employee;

SELECT DISTINCT(jikup)
FROM            employee;

SELECT
              UNIQUE(jikup)
       FROM   employee;

       -- 문제를 보고 코딩을 해서 답을 찾지만 sql 코딩 구문을보고 무엇을 요구하는지 찾아낼수 있어야 한다. <답을 보고 문제를 알아맞춰야하는 이유는 문제가 고객의 요구사항이기 때문이다.>
       -- employee 테이블에서 부서번호와 직급을 중복 없이 검색하면?
       SELECT DISTINCT dep_no,
                       jikup
       FROM            EMPLOYEE;

       -- 부서번호와 직급을 동시에 같이 봤을때 중복되지 않는것이다. 즉. 부서번호와 직급은 여러번 나올수 있다. 하지만 부서번호 지급이 같은 행은 안나온다.
       -- SELECT DISTINCT dep_no, DISTINCT jikup FROM EMPLOYEE; X
       -- SELECT DISTINCT(dep_no, jikup) FROM EMPLOYEE; X
       SELECT
                     UNIQUE dep_no,
                     jikup
              FROM   EMPLOYEE;

              -- SELECT UNIQUE(dep_no, jikup) FROM EMPLOYEE; X
              -- employee 테이블에서 연봉이 3000 이상인 직원을 검색해서 검색하면?
              SELECT *
              FROM   employee
              WHERE  salary >= 3000; -- 행을 골라내는 키워드 where
              -- employee 테이블에서 연봉 오름차순으로 검색하면?
              SELECT   *
              FROM     employee
              ORDER BY SALARY; --ASC;
              -- order by 는 행의 순서를 내 뜻대로 바꿔줌. asc는 오름차순이라는 뜻이고 생략이 가능하다.
              SELECT   *
              FROM     employee
              ORDER BY SALARY DESC; -- DESC 내림차순이다.
              -- 컬럼명이 아닌 몇번째 컬럼인지 숫자로 써도 가능하다.(위치번호)
              -- <참고> 오라클은 인덱스 번호가 0이 아닌 1부터 시작한다.
              SELECT   *
              FROM     employee
              ORDER BY 5;

              SELECT   *
              FROM     employee
              ORDER BY 5 DESC;

              -- employee 테이블에서 부서번호 오름차순을 유지하면서 연봉 내림차순으로 검색하면?
              SELECT   *
              FROM     EMPLOYEE
              ORDER BY DEP_NO,
                       SALARY DESC; -- dep_no는 asc가 생략되어있는것이다. desc가 아니다!
              -- SELECT * FROM EMPLOYEE ORDER BY DEP_NO ASC ,SALARY DESC;
              -- employee 테이블에서 직급이 높은 순서 나열해서 검색하면?
              -- SELECT * FROM EMPLOYEE ORDER BY jikup DESC; <- 틀린답.
              -- 오라클은 1234,abcd,ㄱㄴㄷㄹ 밖에 못한다. 인간이 생각하는 직급 순서를 모른다.
              -- 추후 조건문을 사용하여 정렬의 기준을 바꾸어야 답이 나온다.
              SELECT   *
              FROM     employee
              ORDER BY DECODE(jikup, '사장',
                              1,
                              '부장',
                              2,
                              '과장',
                              3,
                              '대리',
                              4),
                       SALARY; -- asc가 생략되어있다.
              -- employee 테이블에서 부장만 검색하면?
              -- 직급이 부장인 행만 골라내는 것.
              SELECT *
              FROM   EMPLOYEE
              WHERE  JIKUP='부장'; -- 오라클은 == 이 없다. 오라클에서 비교연산자는 '=' 이다. 다른  프로그래밍 언어의 대입연산자 or 비교연산자 =,==과 햇갈리지 말자!
              -- employee 테이블에서 20번 부서의 과장만 검색하면?
              SELECT *
              FROM   EMPLOYEE
              WHERE  dep_no = 20
              AND    JIKUP  ='과장';

              -- 오라클에서 && 연산은 말그대로 and로 쓴다. || 연산도 똑같이 그냥 or 이다..
              -- employee 테이블에서 과장 중에 연봉 3400 이상을 검색하면?
              SELECT *
              FROM   EMPLOYEE
              WHERE  JIKUP   ='과장'
              AND    salary >=3400;

              -- employee 테이블에서 실수령 액이 4000만원 이상 받는 직원을 검색하면? 단 세금이 12% 가정.
              SELECT *
              FROM   EMPLOYEE
              WHERE  (
                            salary*0.88
                     )
                     >= 4000;

              -- 출력할때 말고도 where 절에 임시적으로 곱할수 있다.
              -- employee 테이블에서 세금을 제일 많이 내는 직원 순서로 나열하면서 부서번호가 내림차순이면서 사장이 아닌 직원을 검색하면?
              SELECT   *
              FROM     EMPLOYEE
              WHERE    JIKUP != '사장'
              ORDER BY (SALARY*0.12) DESC,
                       DEP_NO DESC;

              -- employee 테이블에서 20번 부서 중에 연봉 2000~ 3000 사이 검색하면?
              SELECT *
              FROM   EMPLOYEE
              WHERE  dep_no  = 20
              AND    SALARY >= 2000
              AND    SALARY <=3000;

              SELECT *
              FROM   EMPLOYEE
              WHERE  dep_no = 20
              AND    SALARY BETWEEN 2000 AND    3000;

              -- 이상 이하를 같이 검색할떄는 between 을 사용한다. 미만, 초과는 사용이 불가능하다..
              -- employee 테이블에서 직속 상관이 없는 직원을 검색하면?
              SELECT *
              FROM   EMPLOYEE
              WHERE  MGR_EMP_NO IS NULL;

              -- null 값은 실존 데이터가 아니므로 비교연산자 = 를 쓸수 없다. = 은 데이터를 찾는건데 null은 데이터가 아니므로 비교할수없다.
              -- null 을 찾는 방법은 IS 로 null인지 확인할수 있다.
              -- employee 테이블에서 지속 상관이 있는 직원을 검색하면?
              SELECT *
              FROM   EMPLOYEE
              WHERE  MGR_EMP_NO IS NOT NULL;

              -- 위의 null 문제와 마찬가지로 != 를 사용 할수 없으므로 null이 아닌 값을 찾을때는 IS NOT 을 쓴다.
              /*
              ********주의 select 는 절대 원본 테이블이 값을 변경시키지 않는다. 모든 사칙연산등의 연산들은 가상으로 일어난다!!*****
              */
              SELECT FLOOR(-3.1)
              FROM   dual;

              -- floor 는 소수점을 버려서 수가 낮아지는것. -3.1 -> -4가 된다.
              /*
              select emp_no,emp_name,jumin_num,
              CASE WHEN TO_DATE(SUBSTR(jumin_num,3,4),'MMDD')-SYSDATE < 0
              THEN TO_CHAR(TO_DATE(SUBSTR(jumin_num,3,4),'MMDD') +365,'YYYY-MM-DD')
              ELSE TO_CHAR(TO_DATE(SUBSTR(jumin_num,3,4),'MMDD'), 'YYYY-MM-DD')
              END "다가올 생일",
              FLOOR(
              CASE WHEN TO_DATE(SUBSTR(jumin_num,3,4),'MMDD')-SYSDATE < 0
              THEN TO_DATE(SUBSTR(jumin_num,3,4),'MMDD')-SYSDATE + 365
              ELSE  TO_DATE(SUBSTR(jumin_num,3,4),'MMDD')-SYSDATE
              END
              ) "생일까지 남은 일수"
              from
              employee
              ORDER BY "생일까지 남은 일수" ASC
              이 코드는 나쁜 코드는 아니지만 default 값을 너무 믿고 쓰지 말아라.(디폴트가 어떻게 동작하는지 확실하게 알고있다면 사용 해도 무관.)
              이 코드는 년도를 디폴드로 계산한다.
              */
              SELECT   emp_no,
                       emp_name,
                       jumin_num,
                       CASE
                                WHEN TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD')-SYSDATE < 0
                                THEN TO_CHAR(TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD') +365,'YYYY-MM-DD')
                                ELSE TO_CHAR(TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD'), 'YYYY-MM-DD')
                       END "다가올 생일",
                       FLOOR(
                       CASE
                                WHEN TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD')-SYSDATE < 0
                                THEN TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD')-SYSDATE +365
                                ELSE TO_DATE(TO_CHAR(SYSDATE,'yyyy')
                                                  ||SUBSTR(jumin_num,3,4),'YYYYMMDD')-SYSDATE
                       END ) "생일까지 남은 일수"
              FROM     employee
              ORDER BY "생일까지 남은 일수" ASC -- order by 뒤에 리얼컬럼명 , 순서번호 등이 와야하지만 리얼 컬럼명(변형된컬럼)을 써야 한다면 알리아스를 써줘도 된다.
              SELECT emp_no"직원번호",
                     emp_name"직원명",
                     jikup"직급",
                     TO_CHAR(salary, '099,999,999')
                            ||'만원' "연봉"
              FROM   employee
              SELECT *
              FROM   employee
              WHERE  TO_CHAR(TO_DATE(
                     CASE
                            WHEN SUBSTR(jumin_num,7,1) IN ('1',
                                                           '2')
                            THEN '19'
                            ELSE '20'
                     END
                            ||SUBSTR(jumin_num,1,6), 'YYYYMMDD'), 'DY') = '수'
              SELECT *
              FROM   employee
              WHERE  SUBSTR(jumin_num, 7,1) = '1'
              AND    SUBSTR(jumin_num,1,1)  = '7'
              SELECT e.emp_no"직원번호",
                     e.emp_name"직원명",
                     d.DEP_NAME"소속부서명"
              FROM   employee e,
                     DEPT d
              WHERE  e.dep_no = d.dep_no;

              SELECT e.emp_no"직원번호",
                     e.emp_name"직원명",
                     d.dep_name"소속부서명"
              FROM   employee e
                     INNER JOIN dept d
                     ON     e.dep_no = d.dep_no;

              SELECT c.cus_name"고객명",
                     c.tel_num"고객전화번호",
                     e.emp_name"담당직원명",
                     e.jikup"담당직원지급"
              FROM   customer c
                     INNER JOIN employee e
                     ON     c.emp_no = e.emp_no
              SELECT c.cus_name"고객명",
                     c.tel_num"고객전화번호",
                     e.emp_name"담당직원명",
                     e.jikup"담당직원지급"
              FROM   customer c
                     INNER JOIN employee e
                     ON     c.emp_no = e.emp_no
              WHERE  e.dep_no        = 10
              SELECT c.cus_name"고객명",
                     c.tel_num"고객전화번호",
                     e.emp_name"담당직원명",
                     e.jikup"담당직원지급"
              FROM   customer c,
                     employee e
              WHERE  c.emp_no  = e.emp_no
              AND    e.salary >= 3000
              SELECT   e.emp_name "직원명",
                       e.jikup "직원직급",
                       d.dep_name "직원부서명",
                       c.cus_name "담당고객명",
                       c.tel_num "고객전화번호."
              FROM     employee e
                       INNER JOIN dept d
                       ON       e.dep_no = d.dep_no
                       INNER JOIN customer c
                       ON       e.emp_no = c.emp_no
              ORDER BY e.emp_name ASC
              SELECT *
              FROM   EMPLOYEE
              SELECT   e.emp_name "직원명",
                       e.jikup "직원직급",
                       d.dep_name "소속부서명",
                       sg.sal_grade_no "연봉등급"
              FROM     (employee e
                       INNER JOIN dept d
                       ON       e.dep_no = d.dep_no)
                       INNER JOIN salary_grade sg
                       ON       e.salary BETWEEN sg.min_salary AND      sg.max_salary
              ORDER BY sg.sal_grade_no ASC,
                       DECODE(e.jikup, '사장',
                              1,
                              '부장',
                              2,
                              '과장',
                              3,
                              '대리',
                              4,
                              '주임',
                              5,6) ASC,
                       CASE
                                WHEN SUBSTR(e.jumin_num, 7,1 ) IN('1',
                                                                  '2')
                                THEN '19'
                                ELSE '20'
                       END
                                || SUBSTR(e.jumin_num,1,6)
              SELECT   e2.emp_name "직속상관명",
                       e2.jikup "직속상관직급",
                       e.emp_name "부하직원명",
                       e.jikup "부하직원직급"
              FROM     employee e,
                       employee e2
              WHERE    e2.emp_no = e.MGR_EMP_NO
              ORDER BY e2.emp_no;

              SELECT   e.emp_name "직속상관명",
                       e.jikup "직속상관직급",
                       e2.emp_name "부하직원명",
                       e2.jikup "부하직원직급"
              FROM     employee e
                       INNER JOIN employee e2
                       ON       e.emp_no = e2.MGR_EMP_NO
              ORDER BY e.emp_no
              SELECT e.emp_name "직원명",
                     e.jikup "직원직급",
                     d.dep_name "소속부서명",
                     s.SAL_GRADE_NO "연봉등급",
                     e2.emp_name "직속상관명",
                     e2.jikup "직속상관직급",
                     c.cus_name "고객명"
              FROM   employee e,
                     dept d,
                     salary_grade s,
                     employee e2,
                     customer c
              WHERE  (
                            e.dep_no = d.dep_no
                     )
              AND
                     (
                            e.salary BETWEEN s.min_salary AND    s.max_salary
                     )
              AND
                     (
                            e.mgr_emp_no = e2.emp_no
                     )
              AND
                     (
                            c.emp_no = e.emp_no
                     );

              SELECT e.emp_name "직원명",
                     e.jikup "직원직급",
                     d.dep_name "소속부서명",
                     s.sal_grade_no "연봉등급",
                     e2.emp_name "직속상관명",
                     e2.jikup "직속상관직급",
                     c.cus_name "고객명"
              FROM   (((employee e
                     INNER JOIN dept d
                     ON     e.dep_no = d.dep_no)
                     INNER JOIN salary_grade s
                     ON     e.salary BETWEEN s.min_salary AND    s.max_salary)
                     INNER JOIN employee e2
                     ON     e.mgr_emp_no = e2.emp_no)
                     INNER JOIN customer c
                     ON     c.emp_no = e.emp_no;


  select
					c.cus_name "고객명",
					c.cus_name "고객전화번호",
					c.cus_name "담당직원명",
					c.cus_name "담당직원직급"
		from
					customer c left outer join employee e
		on
					c.emp_no = e.emp_no(+);


select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.tel_num "고객전화번호",
					e.emp_name "담당직원명",
					e.jikup "담당직원직급"
		from
					customer c, employee e
		where
					c.emp_no = e.emp_no(+) AND e.dep_no(+) = 10;


		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.tel_num "고객전화번호",
					e.emp_name "담당직원명",
					e.jikup "담당직원직급"
		from
					customer c left outer join employee e
		on
					c.emp_no = e.emp_no AND e.dep_no = 10;



		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.tel_num "고객전화번호",
					e.emp_name "담당직원명",
					e.jikup "담당직원직급",
					s.sal_grade_no"담당직원연봉등급"
		from
					customer c, employee e, salary_grade s
		where
					c.emp_no = e.emp_no(+) AND e.salary between s.min_salary(+) and s.max_salary(+)
		ORDER BY c.cus_no;



		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.tel_num "고객전화번호",
					e.emp_name "담당직원명",
					e.jikup "담당직원직급",
					s.sal_grade_no"담당직원연봉등급" --, salary_grade s
		from
					(customer c left outer join employee e on c.emp_no = e.emp_no)
					left outer join salary_grade s on e.salary between s.min_salary and s.max_salary
		ORDER BY c.cus_no;


		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.jumin_num "고객주민번호"
		from
					customer c , employee e
		where
					floor(
					to_number(
					sysdate -
					to_date(
					case when
					substr(e.jumin_num,7,1) in('1','2') then '19'
					else '20' end||
					substr(e.jumin_num,1,6), 'yyyy-mm-dd'
					)
					) / 365
					+1) >= 40 AND c.emp_no = e.emp_no


		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.jumin_num "고객주민번호"
		from
					customer c , employee e
		where
					e.salary >= 3000 AND c.emp_no = e.emp_no


		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.jumin_num "고객주민번호"
		from
					customer c inner join employee e
		on
					e.salary >= 3000 AND c.emp_no = e.emp_no


			select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					NVL(c.emp_no ||'','없음') "담당직원번호",
					NVL(e.emp_name ||'','없음') "담당직원명",
					NVL(d.dep_name ||'','없음') "담당직원소속부서명",
					NVL(s.sal_grade_no ||'','없음') "담당직원연봉등급",
					NVL(e2.emp_name||'','없음') "담당직원직속상관명",
					NVL(e2.jikup||'', '없음') "담당직원직속상관직급",
					NVL(s.sal_grade_no||'', '없음') "직속상관연봉등급"
		from
					customer c , employee e, dept d, salary_grade s, employee e2, salary_grade s2
		where
					c.emp_no = e.emp_no(+)
					and e.dep_no = d.dep_no(+)
					and e.salary between s.min_salary(+) and s.max_salary(+)
					and e.mgr_emp_no = e2.emp_no(+)
					and e2.salary between s2.min_salary(+) and s2.max_salary(+)
		ORDER BY
					c.cus_no;



		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					NVL(c.emp_no ||'','없음') "담당직원번호",
					NVL(e.emp_name ||'','없음') "담당직원명",
					NVL(d.dep_name ||'','없음') "담당직원소속부서명",
					NVL(s.sal_grade_no ||'','없음') "담당직원연봉등급",
					NVL(e2.emp_name||'','없음') "담당직원직속상관명",
					NVL(e2.jikup||'', '없음') "담당직원직속상관직급",
					NVL(s.sal_grade_no||'', '없음') "직속상관연봉등급"
		from
					((((customer c left outer join employee e on c.emp_no = e.emp_no)
					left outer join dept d on e.dep_no = d.dep_no)
					left outer join salary_grade s on e.salary between s.min_salary and s.max_salary)
					left outer join employee e2 on e.mgr_emp_no = e2.emp_no)
					left outer join salary_grade s2 on e2.salary between s2.min_salary and s2.max_salary
		ORDER BY
					c.cus_no;




	select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.jumin_num "고객주민번호"
		from
					customer c , employee e
		where
					c.emp_no = e.emp_no
					AND
					(extract(year from sysdate)
					-
					extract(
						year from to_date(
							decode(substr(e.jumin_num,7,1),'1','19','2','19','20')
									|| substr(e.jumin_num,1,6), 'yyyymmdd'
						)
					)+1) >= 40


		select
					c.cus_no "고객번호",
					c.cus_name "고객명",
					c.jumin_num "고객주민번호"
		from
					customer c inner join employee e
					on floor(
					to_number(
					sysdate -
					to_date(
					case when
					substr(e.jumin_num,7,1) in('1','2') then '19'
					else '20' end||
					substr(e.jumin_num,1,6), 'yyyy-mm-dd'
					)
					) / 365
					+1) >= 40
					 AND c.emp_no = e.emp_no
SELECT * FROM EMPLOYEE WHERE EMP_NAME = '한국남'
