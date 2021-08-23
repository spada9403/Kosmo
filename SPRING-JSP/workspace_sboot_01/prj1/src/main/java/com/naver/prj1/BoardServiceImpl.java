package com.naver.prj1;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    SqlSessionTemplate sqlSession;

    public int insertBoard(BoardDTO boardDTO){

        int insertBoardCnt = sqlSession.insert(
            "com.naver.prj1.board.getBoard_insertCnt",
            boardDTO
        );

        return insertBoardCnt;
    };

    public int getMaxPkNum(){
        

        int maxPkNum = sqlSession.selectOne(
            "com.naver.prj1.board.maxB_no"
        );

        return maxPkNum;
    }
}
