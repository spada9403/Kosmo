create table code_skill (
skill_code number(3),
skill_name varchar2(20) not null unique,
primary key(skill_code)
);
create sequence code_skill_seq start with 1 increment by 1;



insert into code_skill(skill_code,skill_name) values( code_skill_seq.NEXTVAL, 'Java' );
insert into code_skill(skill_code,skill_name) values( code_skill_seq.NEXTVAL,'JSP' );
insert into code_skill(skill_code,skill_name) values( code_skill_seq.NEXTVAL,'ASP' );
insert into code_skill(skill_code,skill_name) values( code_skill_seq.NEXTVAL,'PHP' );
insert into code_skill(skill_code,skill_name) values( code_skill_seq.NEXTVAL,'Delphi' );