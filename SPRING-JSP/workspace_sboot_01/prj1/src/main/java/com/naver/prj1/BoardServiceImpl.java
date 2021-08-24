package com.naver.prj1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


    // 서비스 클래스인 BoardServiceImpl 클래스 선언
    //     서비스 클래스에는 @Service 와 @Transactional 를 붙인다
    //     @Service                =>       서비스 클래스 임을 지정하고 bean태그로 자동 등록된다.
    //     @Transactional        =>        서비스 클래스의 메소드 내부에서 일어나는 모든 작업에는 [트랜잭션]이 걸린다.

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    // 속성변수 boardDAO 선언하고, BoardDAO 인터페이스를 구현한 클래스를 객체화해서 저장한다.
    //     @Autowired 역활         =>      속성변수에 붙은 자료형인 [인터페이스를]를 구현한 [클래스]를 객체화하여 저장한다.

    @Autowired
    private BoardDAO boardDAO;

    // 1개 게시판 글 입력 적용 행의 개수    리턴하는 메소드 선언
    public int insertBoard(BoardDTO boardDTO){
        // BoardDAOImpl 객체의 insertBoard 메소드 호출하여 게시판 글 입력 후 입력 적용 행의 개수 얻기
        int boardRegCnt = this.boardDAO.insertBoard(boardDTO);
        // 1개 게시판 글 입력 적용 행의 개수 리턴하기
        return boardRegCnt;
    };
    public List<Map<String,String>> getboardList(int pageNum){
        List<Map<String,String>> list = this.boardDAO.getboardList(pageNum);

        return list;
    }
}
