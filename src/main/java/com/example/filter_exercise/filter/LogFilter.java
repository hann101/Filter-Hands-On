package com.example.filter_exercise.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter{
    /*
        ex1) Log Filter 예제
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServeltRequest = (HttpServletRequest) request;
        String requestURI = ((HttpServletRequest) request).getRequestURI();
        String uuid = UUID.randomUUID().toString().substring(0, 8);

        request.setAttribute("uuid",uuid);

        try {
            log.info("[Filter 1] REQUEST [{}][{}]", uuid, requestURI);
            chain.doFilter(request, response);
        }catch (Exception e){
            throw e;
        }finally {
            log.info("[Filter 1] RESPONSE [{}][{}]", uuid, requestURI);
        }
    }
}
