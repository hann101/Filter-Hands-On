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
    @Bean
    public FilterRegistrationBean<Filter> logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));


        return filterRegistrationBean;
    }

    /*
        Xss Filter
     */
    @Bean
    public FilterRegistrationBean<Filter> xssFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }


    /*
        OncePerRequestFilter
     */
    @Bean
    public FilterRegistrationBean<Filter> oncePerRequestFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new exOncePerRequestFilter());
        filterRegistrationBean.setOrder(3);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

    /*
        Interceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Ex1_Interceptor())
                .order(1)
                .addPathPatterns("/interceptor/**")
                .excludePathPatterns("/login/**");
    }
}
