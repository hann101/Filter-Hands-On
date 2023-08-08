package com.example.filter_exercise.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;


@Slf4j
public class Ex1_Interceptor implements HandlerInterceptor {
    public static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();
        request.setAttribute(LOG_ID, uuid);

        log.info("[Interceptor preHandle] REQUEST [{}][{}][{}]", request.getAttribute("uuid"), requestURI, handler);

        //Session 체크
        String session = (String) request.getSession().getAttribute("login");
        if (session == null) {
            log.info("[Interceptor] 미인증 사용자 요청");
            response.sendRedirect("/login/fail");
            return false;
        }
        return true; //false 진행X
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[Interceptor postHandle] [{}]", modelAndView);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);
        log.info("[Interceptor afterCompletion] RESPONSE [{}][{}]", logId, requestURI);
        if (ex != null) {
            log.error("[Interceptor afterCompletion] afterCompletion error!!", ex);
        }
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
