create table login(
  login_no      number(3),
  login_id      varchar2(20)   not null unique,
  pwd           varchar2(20)   not null,
  primary key(login_no)
);

insert into login values(1,'abc','123');
insert into login values(2,'xyz','123');
insert into login values(3,'king','k123');


create table board(
	b_no      number(9)                        --> 게시판 글 고유번호

	,subject   varchar2(50)     not null        --> 글 제목
	,writer    varchar2(30)     not null        --> 글쓴이 이름
	,content   varchar2(2000)   not null        --> 글 내용
	,pwd       varchar2(12)     not null        --> 암호
	,email     varchar2(30)                     --> 이메일

	,reg_date   date            default sysdate  --> 등록일
	,readcount  number(5)       default 0        --> 조회수

	,group_no   number(9)       not null         --> 게시판 글의 소속 그룹번호. 정렬 시 사용.
	,print_no   number(9)       not null         --> 같은 그룹번호 내에서 화면 출력 순서 번호.정렬 시 사용.

	,print_level number(9)      not null         -> 같은 그룹번호 내에서 댓글 들여쓰기 레벨 단계 번호. 부모 자식 관계를 알수 있다.
	
	, primary key(b_no)
)








COMMIT;