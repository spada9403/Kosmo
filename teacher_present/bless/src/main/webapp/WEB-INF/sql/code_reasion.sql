create table code_religion (
religion_code number(3),
religion_name varchar2(20) not null unique,
primary key(religion_code)
);
create sequence code_religion_seq start with 1 increment by 1;

insert into code_religion(religion_code,religion_name) values( code_religion_seq.NEXTVAL,'기독교' );
insert into code_religion(religion_code,religion_name) values( code_religion_seq.NEXTVAL,'천주교' );
insert into code_religion(religion_code,religion_name) values( code_religion_seq.NEXTVAL,'불교' );
insert into code_religion(religion_code,religion_name) values( code_religion_seq.NEXTVAL,'이슬람' );
insert into code_religion(religion_code,religion_name) values(code_religion_seq.NEXTVAL, '무교' );