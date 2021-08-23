package com.naver.prj1;

public interface BoardService {
    // 게시판 글 입력 후 입력 적용 행의 개수 리턴하는 메소드 선언
    int insertBoard(BoardDTO boardDTO);
    int getMaxPkNum();
}
