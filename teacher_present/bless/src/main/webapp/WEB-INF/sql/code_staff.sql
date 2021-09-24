



create table staff (
staff_no number(3),
staff_name varchar2(14) not null,
jumin_no char(14) not null unique,
school_code number(3) not null,
religion_code number(3) not null,
graduate_day char(10) not null,
foreign key(religion_code) references code_religion(religion_code),
foreign key(school_code) references code_school(school_code),
primary key(staff_no)
);
create sequence staff_seq start with 1 increment by 1

insert into staff values(staff_seq.NEXTVAL,'오세황','098765-1234567',1,1,'1998-03-25')

create table staff_skill (
staff_skill_no number(3),
staff_no number(3) not null,
skill_code number(3) not null,
primary key(staff_skill_no),
foreign key(staff_no) references staff(staff_no),
foreign key(skill_code) references code_skill(skill_code)
);
create sequence staff_skill_seq start with 1 increment by 1;