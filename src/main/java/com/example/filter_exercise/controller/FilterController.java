package com.example.filter_exercise.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@RestController
public class FilterController {

    /*
        Filter 예시
     */
    @GetMapping("/xss")
    public String test(@RequestParam String script) {;
        log.info(" Xss Filtering Result :[{}]",script);
        return "XSS";
    }

    /*
        OncePerRequestFilter 예시
     */
    @GetMapping("/will-redirect")
    public void willRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/redirected");
    }

    @GetMapping("/redirected")
    public String redirected() {
        return "redirected";
    }

    @GetMapping("/will-forward")
    public void willForward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/forwarded").forward(request, response);
    }

    @GetMapping("/forwarded")
    public String forwarded() {
        return "forwarded";
    }

}