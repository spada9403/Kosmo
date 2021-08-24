package com.naver.prj1;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
    int insertBoard(BoardDTO boardDTO);
    List<Map<String,String>> getboardList(int pageNum);
}
