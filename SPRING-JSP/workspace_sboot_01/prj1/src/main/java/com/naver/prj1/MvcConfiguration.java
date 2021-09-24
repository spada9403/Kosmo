package com.naver.prj1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
// SessionInterceptor 클래스를 인터셉터로 등록하기 위한 MvcConfiguration 클래스 선언하기.
// 설정을 위한 클래스이다.
//MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    //  SessionInterceptor 객체를 인터셉터로 등록하는 코딩이 내포된
    //  addInterceptors 메서드를 오버라이딩한다.
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SessionInterceptor()).excludePathPatterns(
            "/naver/loginForm.do",
            "/naver/loginProc.do",
            "/naver/logout.do",
            "/resources/**",
            "/naver/login_alert.do",
            "/naver/employeeList.do" 
        );
    }
}
