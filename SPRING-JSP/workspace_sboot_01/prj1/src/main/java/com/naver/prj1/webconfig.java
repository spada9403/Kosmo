package com.naver.prj1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/employeeApi.do");
        registry.addMapping("/employeeInfoApi.do");
        registry.addMapping("/updateEmplInfo.do");
        registry.addMapping("/**");
    }
    
}
