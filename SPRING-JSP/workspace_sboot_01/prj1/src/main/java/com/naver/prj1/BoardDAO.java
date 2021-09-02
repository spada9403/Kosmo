package com.naver.prj1;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    int insertBoard(BoardDTO boardDTO);
    List<Map<String,String>> getBoardList(BoardSearchDTO boardSearchDTO);
    BoardDTO getBoard(int b_no);
    int updateReadCount(int b_no);
    int updateBoard(BoardDTO boardDTO);
    int deleteBoard(int b_no);
    BoardDTO pwdMatch(BoardDTO boardDTO);
    int getChildrenCnt(BoardDTO boardDTO);
    int downPrintNo(BoardDTO boardDTO);
    int updatePrintNo(BoardDTO boardDTO);
    int searchBoardCnt(BoardSearchDTO boardSearchDTO);
}
