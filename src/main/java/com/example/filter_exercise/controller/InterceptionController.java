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
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("login","allow");
        return "login success";
    }

    @GetMapping("/login-info")
    public String infoLogin(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        return (String) session.getAttribute("login");
    }

    @GetMapping("/fail")
    public String deny(){
        return "fail";
    }
}
