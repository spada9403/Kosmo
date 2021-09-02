package com.naver.prj1;

import java.util.Map;

public interface LoginDAO {
    public int getLogin_idCnt( Map<String,String> id_pwd );
}