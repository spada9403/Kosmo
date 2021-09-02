package com.naver.prj1;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAOImpl implements BoardDAO{

        @Autowired
        SqlSessionTemplate sqlSession;

    public int insertBoard(BoardDTO boardDTO){
        int boardRegCnt = this.sqlSession.insert("com.naver.prj1.BoardDAO.insertBoard", boardDTO);
        return boardRegCnt;
    }
    public List<Map<String,String>> getBoardList(BoardSearchDTO boardSearchDTO){
        List<Map<String,String>> boardList = this.sqlSession.selectList("com.naver.prj1.BoardDAO.getBoardList", boardSearchDTO);
        return boardList;
    };
    public BoardDTO getBoard(int b_no){
        BoardDTO boardDTO = sqlSession.selectOne(
            "com.naver.prj1.BoardDAO.getBoard",
            b_no
        );
        return boardDTO;
    }
    public int updateReadCount(int b_no){
        int cnt = sqlSession.update("com.naver.prj1.BoardDAO.updateReadCount", b_no);
        return cnt;
    }
    public int updateBoard(BoardDTO boardDTO){
        int updateCnt = sqlSession.update("com.naver.prj1.BoardDAO.updateBoard", boardDTO);
        return updateCnt;
    }
    public int deleteBoard(int b_no){
        int deleteCnt = sqlSession.delete("com.naver.prj1.BoardDAO.deleteBoard", b_no);
        return deleteCnt;
    }
    public BoardDTO pwdMatch(BoardDTO boardDTO){
        BoardDTO pwdMatchList = sqlSession.selectOne(
            "com.naver.prj1.BoardDAO.pwdMatch",boardDTO
            );
        return pwdMatchList;
    }
    public int getChildrenCnt(BoardDTO boardDTO){
        int childrenCnt = sqlSession.selectOne("com.naver.prj1.BoardDAO.getChildrenCnt", boardDTO);
        return childrenCnt;
    }

    public int downPrintNo(BoardDTO boardDTO){
        int downPrintNo = sqlSession.update("com.naver.prj1.BoardDAO.downPrintNo", boardDTO);
        return downPrintNo;
    }

    public int updatePrintNo(BoardDTO boardDTO){
        int updatePrintNoCnt = sqlSession.update("com.naver.prj1.BoardDAO.updatePrintNo", boardDTO);
        return updatePrintNoCnt;
    }
    public int searchBoardCnt(BoardSearchDTO boardSearchDTO){
        int searchBoardCnt = sqlSession.selectOne("com.naver.prj1.BoardDAO.searchBoardCnt", boardSearchDTO);
        return searchBoardCnt;
    }

}
