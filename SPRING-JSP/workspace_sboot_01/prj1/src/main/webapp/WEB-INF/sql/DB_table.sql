create table login(
  login_no      number(3),
  login_id      varchar2(20)   not null unique,
  pwd           varchar2(20)   not null,
  primary key(login_no)
);

insert into login values(1,'abc','123');
insert into login values(2,'xyz','123');
insert into login values(3,'king','k123');
COMMIT;