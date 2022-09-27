package com.example.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//cors 설정 https://dev-pengun.tistory.com/entry/Spring-Boot-CORS-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

   // @Override //오류가 남
    public void addCorMappings(CorsRegistry registry){
        registry
                .addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","PATCH")
                .allowedHeaders("*");
    }


}
