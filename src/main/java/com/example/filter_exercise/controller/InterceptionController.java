package com.example.filter_exercise.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class InterceptionController {
    @GetMapping("/interceptor")
    public String interceptorTest() {
        return "interceptor success";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("login", "allow");
        return "login success";
    }

    @GetMapping("/login/info")
    public String infoLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String result = "not allowed";
        ;
        if (session != null) {
            result = (String) session.getAttribute("login");
        }
        return result;
    }

    @GetMapping("/login/fail")
    public String deny() {
        return "deny";
    }

    @GetMapping("/interceptor/exception")
    public void exception() throws Exception {
        throw new Exception();
    }
}
