package com.naver.prj1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Util {
    public static void addCookie(
        String cookieName,
        String cookieVal,
        int cookieAge,
        HttpServletResponse response
    ){
        // 쿠키 객체를 생성하고 쿠키명-쿠키값 저장
        Cookie cookie = new Cookie(cookieName,cookieVal);
        // 쿠키 객체에 저장된 쿠키의 수명 주기
        cookie.setMaxAge(cookieAge);
        // 쿠키 객체가 소유한 쿠키를 응답메시지에 저장하기.
        // 결국 쿠키객체가 소유한 쿠키명 쿠키값이 응답메시지에 저장된다.
        // 응답메시지에 저장된 쿠키는 클라이언트쪽으로 전송되어 클라이언트쪽에 저장된다.
        response.addCookie(cookie);
    }
    public static boolean isNull( String str ){
        return str==null || str.length()==0;
    }
    public static Map<String,Integer> getPagingNos(
        int totRowCnt,
        int selectPageNo,
        int rowCntPerPage
    ){
        int last_pageNo = 0;
        int min_pageNo = 0;
        int max_pageNo = 0;
        if(totRowCnt>0){
        last_pageNo = totRowCnt/rowCntPerPage;
            if( totRowCnt%rowCntPerPage > 0 ){last_pageNo++;}
        if(selectPageNo > last_pageNo){
            selectPageNo = 1;
        }
        min_pageNo = (((selectPageNo-1)/10) * 10) + 1;
        max_pageNo = (min_pageNo + 10) - 1;
            if( max_pageNo>last_pageNo){max_pageNo = last_pageNo;}
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("totRowCnt", totRowCnt);
        map.put("selectPageNo", selectPageNo);
        map.put("rowCntPerPage", rowCntPerPage);
        map.put("last_pageNo", last_pageNo);
        map.put("min_pageNo", min_pageNo);
        map.put("max_pageNo", max_pageNo);
        return map;
    }
}
