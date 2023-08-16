package com.example.filter_exercise.filter;

import com.example.filter_exercise.wrapper.XSSRequestWrapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class XssFilter implements Filter{
    /*
        XSS Filter 적용
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            log.info("  [Filter2] Request Xss Filter [{}]",request.getAttribute("uuid"));
            chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
        }finally {
            log.info("  [Filter2] Response Xss Filter [{}]",request.getAttribute("uuid"));
        }
    }
}
