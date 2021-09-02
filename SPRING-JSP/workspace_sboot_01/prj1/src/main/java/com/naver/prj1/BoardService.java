package com.naver.prj1;

public interface BoardService {
    // 게시판 글 입력 후 입력 적용 행의 개수 리턴하는 메소드 선언
    int insertBoard(BoardDTO boardDTO);
    // public abstract int insertBoard(BoardDTO boardDTO) public 과 abstarct 는 생략이 가능하다.
    // Java interface 정의
    // public, static, final 의 성격을 가진 속성변수와
    // public, abstract 의 성격을 가진 메소드로 구성된 클래스와는 다른 단위 프로그램이다.
    BoardDTO getBoard(int b_no);
    int upDelBoard(BoardDTO boardDTO, String upDel);
}
