package com.example.filter_exercise.config;


import com.example.filter_exercise.filter.Ex1_Filter;
import com.example.filter_exercise.filter.Ex2_Filter;
import com.example.filter_exercise.filter.Ex3_Filter;
import com.example.filter_exercise.interceptor.Ex1_Interceptor;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.EnumSet;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /*
        Log Filter
     */


    /*
        Xss Filter
     */


    /*
        OncePerRequestFilter
     */


    /*
        Interceptor
     */

}
