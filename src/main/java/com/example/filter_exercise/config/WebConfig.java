package com.example.filter_exercise.config;


import com.example.filter_exercise.filter.LogFilter;
import com.example.filter_exercise.filter.XssFilter;
import com.example.filter_exercise.filter.exOncePerRequestFilter;
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
