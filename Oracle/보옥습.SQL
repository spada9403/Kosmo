■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
<104> 고객번호, 고객명, 담당직원번호, 담당직원명, 담당직원소속부서명, 담당직원연봉등급,
				담당직원직속상관명, 담당직원직속상관직급, 직속상관연봉등급   출력하라.
	 단, 고객은 다 나와야하고 null은  없음  으로 표시
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
SELECT
C.CUS_NO,
C.CUS_NAME,
NVL(TO_CHAR(C.EMP_NO),'없음'),
NVL(E.EMP_NAME,'없음'),
NVL(D.DEP_NAME,'없음'),
NVL(TO_CHAR(S.SAL_GRADE_NO),'없음'),
NVL(E2.EMP_NAME,'없음'),
NVL(E2.JIKUP,'없음'),
NVL(TO_CHAR(S2.SAL_GRADE_NO),'없음')
FROM	CUSTOMER C, EMPLOYEE E, DEPT D, SALARY_GRADE S, EMPLOYEE E2, SALARY_GRADE S2
WHERE
C.EMP_NO	= E.EMP_NO(+) AND E.DEP_NO	=	D.DEP_NO(+) AND E.SALARY BETWEEN S.MIN_SALARY(+) AND (S.MAX_SALARY(+)-1)
AND E.MGR_EMP_NO = E2.EMP_NO(+) AND E2.SALARY BETWEEN S2.MIN_SALARY(+) AND (S2.MAX_SALARY(+)-1)


SELECT
C.CUS_NO,
C.CUS_NAME,
NVL(TO_CHAR((SELECT E.EMP_NO FROM EMPLOYEE E WHERE E.EMP_NO = C.EMP_NO)),'없음'),
NVL((SELECT E.EMP_NAME FROM EMPLOYEE E WHERE E.EMP_NO = C.EMP_NO),'없음'),
NVL((SELECT D.DEP_NAME FROM DEPT D, EMPLOYEE E WHERE E.EMP_NO	=	C.EMP_NO AND D.DEP_NO = E.DEP_NO),'없음'),
NVL(TO_CHAR((SELECT S.SAL_GRADE_NO FROM SALARY_GRADE S WHERE (SELECT E.SALARY FROM EMPLOYEE E WHERE E.EMP_NO = C.EMP_NO) BETWEEN S.MIN_SALARY AND (S.MAX_SALARY-1))),'없음'),
NVL((SELECT E2.EMP_NAME FROM EMPLOYEE E, EMPLOYEE E2 WHERE E.EMP_NO = C.EMP_NO AND E2.EMP_NO = E.MGR_EMP_NO),'없음'),
NVL((SELECT E2.JIKUP FROM EMPLOYEE E, EMPLOYEE E2 WHERE E.EMP_NO = C.EMP_NO AND E2.EMP_NO = E.MGR_EMP_NO),'없음'),
NVL(TO_CHAR((SELECT S.SAL_GRADE_NO FROM SALARY_GRADE S WHERE (SELECT E2.SALARY FROM EMPLOYEE E, EMPLOYEE E2 WHERE E.EMP_NO = C.EMP_NO AND E2.EMP_NO = E.MGR_EMP_NO) BETWEEN S.MIN_SALARY AND (S.MAX_SALARY-1))),'없음')
FROM CUSTOMER C


class X {	public static int a;	public static void modify(int a) {		a++;	}}public class XExe {	public static void main(String[] args) {		X.modify(X.a);		System.out.println(X.a);	}}	What is the result?	A. 0	B. 1	C. Compilation fails.	D. An exception is thrown at runtime.





	class X {	public static void modify(String s) {		s += "world!";	}}public class XExe {	public static void main(String[] args) {		String s = new String("Hello");		X.modify(s);		System.out.println(s);	}}	What is the result?	A. Hello	B. Hello world!	C. Compilation fails.	D. An exception is thrown at runtime.


■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	SELECT
	E.EMP_NO,
	E.EMP_NAME,
	E.SALARY,
	(SELECT COUNT(*) + 1 FROM EMPLOYEE E2 WHERE E2.SALARY > E.SALARY)
	FROM
	EMPLOYEE E
	ORDER BY 4

	SELECT
	E.EMP_NO,
	E.EMP_NAME,
	E.SALARY,
	ROWNUM "연봉순위"
	FROM
	(SELECT * FROM EMPLOYEE ORDER BY SALARY DESC) E
	ORDER BY 4
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
위의 문제는 ROWNUM을 사용하면 안된다. 이유는 랭킹은 같을수도 있는데,
ROWNUM은 중복되지 않는 일련번호가 나오기 때문이다.
■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
		SELECT
				C.CUS_NO,
				C.CUS_NAME,
				C.TEL_NUM,
				(	SELECT e.emp_name FROM EMPLOYEE E WHERE E.EMP_NO = C.EMP_NO	)
		FROM CUSTOMER C



SELECT
		D.DEP_NO,
		D.DEP_NAME,
		COUNT(DISTINCT E.EMP_NO),
		COUNT(C.CUS_NO)
FROM
		DEPT D, EMPLOYEE E, CUSTOMER C
WHERE
		D.DEP_NO = E.DEP_NO(+) AND E.EMP_NO = C.EMP_NO(+)
	GROUP BY D.DEP_NO,
		D.DEP_NAME


SELECT
		D.DEP_NO,
		D.DEP_NAME,
		(SELECT COUNT(*) FROM EMPLOYEE E WHERE E.DEP_NO = D.DEP_NO),
		(SELECT COUNT(*) FROM EMPLOYEE E, CUSTOMER C WHERE E.DEP_NO = D.DEP_NO AND E.EMP_NO = C.EMP_NO)
FROM
		DEPT D