■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
<165> 게시판에 입력되는 데이터를 저장하려면 테이블 구조는 어떻게 설계 해야할까?
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		CREATE TABLE BOARD(
				B_NO					NUMBER(9),																		-->	게시판 글 고유 번호

				SUBJECT				VARCHAR2(50)				NOT NULL,									-->	글 제목
				WRITER				VARCHAR2(30)				NOT NULL,									-->	글쓴이 이름
				CONTENT				VARCHAR2(2000)			NOT NULL,									-->	글 내용
				PWD						VARCHAR2(12)				NOT NULL,									-->	암호
				EMAIL					VARCHAR2(30),																	-->	이매일

				REG_DATE			DATE								DEFAULT SYSDATE,					-->	등록일
				READCOUNT			NUMBER(5)						DEFAULT 0,								-->	조회수

				GROUP_NO			NUMBER(9)						NOT NULL,									-->	게시판 글의 소속 그룹번호
				PRINT_NO 			NUMBER(9)						NOT NULL,									-->	같은 그룹번호 내애서 화면 출력 순서번호.

				PRINT_LEVEL		NUMBER(9)						NOT NULL,									-->	같은 그룹번호 내에서 댓글 들여쓰기 레벨 단계 번호.

				PRIMARY KEY(B_NO)
		)
================================================================================
		<세끼문제> 정렬에 관련된 컬럼은?
				 --> GROUP_NO,	PRINT_NO
				 		--> 먼저 그룹번호를 내림차순으로 정렬하고 같은 그룹번호 내에서 화면 출력 순서를 오름차순으로 정렬할 것이다.

		<세끼문제> 부모자식 관계를 표현하는데 사용되는 데이터가 있는 컬럼??
				--> PRINT_LEVEL
						-->자식은 부모보다 1단계 오른쪽으로 밀려 들어가게 만든다.
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
<166> 게시판이 오픈 된 후 처음으로 누군가 아래처럼 글을 올렸다. INSERT 구문을 쓰면?
				글제목 => 11월 모두 취업합시다.
				글내용 => 모두다 화이팅!
    		글쓴이 => 희원
    		이매일 => HWON@NAVER.COM
    		비밀번호 => 1234
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		INSERT INTO BOARD(
				B_NO,
				SUBJECT,
				WRITER,
				CONTENT,
				PWD,
				EMAIL,
				GROUP_NO,
				PRINT_NO,
				PRINT_LEVEL
		) VALUES (
				(SELECT NVL(MAX(B_NO),0)+1 FROM BOARD),
				'11월 모두 취업합시다.',
				'희원',
				'모두다 화이팅!',
				'1234',
				'HWON@NAVER.COM',
				(SELECT NVL(MAX(B_NO),0)+1 FROM BOARD),
				0,
				0
		)
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
<167> 누군가 게시판에 번호 1번에 아래처럼 댓글을 올렸다. 이때 댓글 올리는 과정중에 발생되는 SQL 구문 모두 써라.
				글제목 => 맞습니다. 열공합시다.
				글내용 => 우리모두 화이팅
    		글쓴이 => 영민
    		이매일 => MIN@NAVER.COM
    		비밀번호 => 2345
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE	B_NO = 1;
		UPDATE BOARD SET PRINT_NO = PRINT_NO+1
		WHERE (SELECT GROUP_NO FROM BOARD WHERE B_NO = 1) = GROUP_NO
						AND PRINT_NO > (SELECT PRINT_NO FROM BOARD WHERE B_NO = 1);

		INSERT INTO BOARD(
				B_NO,
				SUBJECT,
				WRITER,
				CONTENT,
				PWD,
				EMAIL,
				GROUP_NO,
				PRINT_NO,
				PRINT_LEVEL
		) VALUES (
				(SELECT NVL(MAX(B_NO),0)+1 FROM BOARD),
				'맞습니다. 열공합시다.',
				'영민',
				'우리모두 화이팅',
				'2345',
				'MIN@NAVER.COM',
				(SELECT GROUP_NO FROM BOARD WHERE B_NO = 1),
				(SELECT (PRINT_NO)+1 FROM BOARD WHERE B_NO = 1),
				(SELECT (PRINT_LEVEL)+1 FROM BOARD WHERE B_NO = 1)
		);
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
<168> 게시판의 모든 글을 출력하면? -> 출력되는 데이터는 단순역순번호, 제목, 글쓴이, 작성일(년-월-일), 조회수 이다.
				<정렬기준> 그룹번호 내림차순, 출력 순서번호 오름차순
				<들여쓰기> PRINT_LEVEL 컬럼안의 데이터를 가지고 들여쓰기를 표현하십쇼.
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		SELECT
				X.CNT - ROWNUM+1	"NO_DESC",
				E.*
		FROM
				(
				SELECT
						LPAD(' ',PRINT_LEVEL*5, ' ')||DECODE(PRINT_NO,0,'','ㄴ')||SUBJECT"제목",
						WRITER "글쓴이",
						TO_CHAR(REG_DATE,'YYYY-MM-DD')"작성일",
						READCOUNT "조회수"
				FROM
						BOARD
				ORDER BY
						GROUP_NO DESC,
						PRINT_NO ASC
		) E, (SELECT COUNT(*) "CNT" FROM BOARD) X