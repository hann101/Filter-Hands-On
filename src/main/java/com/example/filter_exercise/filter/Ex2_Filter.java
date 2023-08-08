package com.example.filter_exercise.filter;

import com.example.filter_exercise.wrapper.XSSRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class Ex2_Filter implements Filter {
    /*
        XSS Filter 적용
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("[Filter 2] XSS Filter [{}]",request.getAttribute("uuid"));
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }
}
