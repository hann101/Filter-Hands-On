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
    @Bean
    public FilterRegistrationBean<Filter> logFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new Ex1_Filter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        //추가설명 필요함
        filterRegistrationBean.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        return filterRegistrationBean;
    }

    /*
        Xss Filter
     */
    @Bean
    public FilterRegistrationBean<Filter> xssFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new Ex2_Filter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /*
        OncePerRequestFilter
     */
    @Bean
    public FilterRegistrationBean<Filter> exOncePerRequestFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new Ex3_Filter());
        filterRegistrationBean.setOrder(3);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
        return filterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Ex1_Interceptor())
                .order(1)
                .addPathPatterns("/interceptor/**")
                .excludePathPatterns("/login/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
