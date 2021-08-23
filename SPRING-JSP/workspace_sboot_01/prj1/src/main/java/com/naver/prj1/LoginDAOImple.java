package com.naver.prj1;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// DAO 클래스인 LoginDAOImpl 클래스 선언
// @Repository 를 붙임으로써 DAO 클래스 임을 지정하게 되고,
// Spring에서 인식해서 객체화 한다.
@Repository
public class LoginDAOImple implements LoginDAO {

// SqlSessionTemplate 객체를 생성해 속변 sqlSession에 저장
// @Autowired 어노테이션을 붙이면 속성변수 자료형에 맞는 SqlSessionTemplate 객체를 생성한 후
// 객체의 메위주를 속성변수에 저장한다.
    @Autowired
    private SqlSessionTemplate sqlSession;
    // 로그인 아이디와 암호 존재의 개수를 리턴하는 메소드 선언.
    public int getLogin_idCnt( Map<String,String> id_pwd_map ) {

        // SqlSessionTemplate 객체의 selectOne 메소드 호출로
        // mybatis 프레임워크가 관리하는 SQL 구문을 호출하여
        // 1행의 데이터인 [로그인 아이디, 암호 존재 개수]를 얻기
        int login_idCnt = this.sqlSession.selectOne(
            // SQL 구문 설정 XML 파일(=mapper_login.xml) 에서
            // <mapper namespace="com.naver.prj1.LoginDAO"> 태그 내부의 
            // <select id="getLogin_idCnt" ~> 태그 내부의
            // 1행 리턴 select 쿼리문 을 실행하고 얻은 데이터를 int로 리턴한다.

            // 실행할 SQL 구문의 위치를 지정하기. (xml 파일 내부의 select문이 있는곳의 위치)
            // 실행할 SQL 구문의 위치 문자열 패턴은 아래와 같다.
            // xml 파일 중에 "mapper 태그의 namespace명.mapper태그내부의호출할SQL구문을소유한 태그의 id값"
            "com.naver.prj1.LoginDAO.getLogin_idCnt", 
            //<select id="getLogin_idCnt"~> 태그 내부에 전달되는 데이터 설정(=호출할 SQL구문에서 사용할 데이터 지정)
            id_pwd_map
        );
        return login_idCnt;
    }

}
