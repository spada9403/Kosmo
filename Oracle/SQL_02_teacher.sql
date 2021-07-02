
drop table employee;
drop table dept;

create table dept(
    dep_no       number(3)
    ,dep_name    varchar2(20)    not null unique
    ,loc         varchar2(20)    not null
    , primary key(dep_no)
);
insert into dept(dep_no,dep_name,loc) values(10,'�ѹ���','����');
insert into dept(dep_no,dep_name,loc) values(20,'������','�λ�');
insert into dept(dep_no,dep_name,loc) values(30,'�����','����');
insert into dept(dep_no,dep_name,loc) values(40,'�����','����');

select * from dept;


create table employee(
      emp_no        number(3)
      ,emp_name		varchar2(20)	not null
      ,dep_no       number(3)
      ,jikup        varchar2(20)    not null
      ,salary       number(9)       default 0
      ,hire_date    date            default  sysdate
      ,jumin_num    char(13)        not null unique
      ,phone	    varchar2(15)	not null
	  ,mgr_emp_no	number(3)

      , primary key(emp_no)
      , foreign key(dep_no)  references dept(dep_no)
      , constraint  employee_mgr_emp_no_fk foreign key(mgr_emp_no)  references employee(emp_no)
);

select * from employee;

--------------------------------------------
--FK �������� ����
--------------------------------------------
alter table employee disable constraint employee_mgr_emp_no_fk;


--------------------------------------------
--�ܳ�¥ �����ʹ� '��-��-��'  �� �Է� �����ϰ� �ϱ�
--------------------------------------------
alter session set nls_date_format = 'yyyy-mm-dd' ;


insert into employee values( 1, 'ȫ�浿', 10, '����', 5000, '1980-01-01', '7211271109410', '01099699515', null );
insert into employee values( 2, '�ѱ���', 20, '����', 3000, '1988-11-01', '6002061841224', '01024948424', 1 );
insert into employee values( 3, '�̼���', 20, '����', 3500, '1989-03-01', '6209172010520', '01026352672', 2 );
insert into employee values( 4, '�̶̹�', 30, '�븮', 2503, '1983-04-01', '8409282070226', '01094215694', 17 );
insert into employee values( 5, '�̼���', 20, '���', 1200, '1990-05-01', '8401041483626', '01028585900', 3 );
insert into employee values( 6, '���θ�', 30, '����', 4003, '1995-05-01', '8402121563616', '01191338328', 17 );
insert into employee values( 7, '��⸸', 20, '����', 2300, '1996-06-01', '8011221713914', '01029463523', 2 );
insert into employee values( 8, 'ä��ȭ', 30, '�븮', 1703, '1992-06-01', '8105271014112', '01047111052', 17 );
insert into employee values( 9, '����ȭ', 10, '���', 1100, '1984-08-01', '8303291319116', '01025672300', 12 );
insert into employee values( 10, '������', 30, '���', 1303, '1988-11-01', '8410031281312', '01027073174', 4 );
insert into employee values( 11, '������', 20, '����', 1600, '1989-12-01', '8409181463545', '01071628290', 2 );
insert into employee values( 12, '������', 10, '�븮', 1800, '1990-10-01', '8207211661117', '01042072622', 20 );
insert into employee values( 13, '����ȭ', 10, '����', 3000, '1996-11-01', '8603231183011', '01098110955', 1 );
insert into employee values( 14, 'ä�ö�', 20, '���', 3400, '1993-10-01', '8001172065410', '01044452437', 3 );
insert into employee values( 15, '������', 10, '���', 2000, '1991-04-01', '8303101932611', '01027491145', 12 );
insert into employee values( 16, '������', 30, '���', 4000, '1981-04-01', '7912031009014', '01098218448', 4 );
insert into employee values( 17, '�̼���', 30, '����', 2803, '1984-05-01', '8102261713921', '0165358075', 1 );
insert into employee values( 18, '������', 30, '���', 1003, '1986-07-01', '8203121977315', '01033583130', 4 );
insert into employee values( 19, '�Ӳ���', 20, '���', 2200, '1988-04-01', '8701301040111', '01086253078', 7 );
insert into employee values( 20, '������', 10, '����', 4500, '1990-05-01', '8811232452719', '01090084876', 13 );

--------------------------------------------
--FK �������� Ű��
--------------------------------------------
alter table employee enable constraint employee_mgr_emp_no_fk;











