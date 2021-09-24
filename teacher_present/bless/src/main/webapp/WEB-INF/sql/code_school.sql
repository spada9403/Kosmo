
create table code_school (
school_code number(3),
school_name varchar2(20) not null unique,
primary key(school_code)
);
create sequence code_school_seq start with 1 increment by 1;




insert into code_school(school_code,school_name) values( CODE_SCHOOL_SEQ.NEXTVAL,'고졸' );
insert into code_school(school_code,school_name) values( CODE_SCHOOL_SEQ.NEXTVAL,'전문대졸' );
insert into code_school(school_code,school_name) values( CODE_SCHOOL_SEQ.NEXTVAL,'일반대졸' );