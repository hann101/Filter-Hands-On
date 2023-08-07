package com.example.filter_exercise.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class Ex3_Filter extends OncePerRequestFilter {
    /*
        OncePerRequestFilter Filte 적용
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[Filter 3] OncePerRequestFilter 동작확인");
        filterChain.doFilter(request, response);
    }
}
