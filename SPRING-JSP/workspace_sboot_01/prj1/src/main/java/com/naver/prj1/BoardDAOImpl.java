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
        int boardRegCnt = sqlSession.insert("com.naver.prj1.BoardDAO.insertBoard", boardDTO);
        return boardRegCnt;
    }

    public List<Map<String,String>> getboardList(int pageNum) {
        List<Map<String,String>> list = sqlSession.selectList("com.naver.prj1.BoardDAO.getboardList", pageNum);
        return list;
    }

}
